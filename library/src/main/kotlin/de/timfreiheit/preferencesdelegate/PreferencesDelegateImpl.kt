package de.timfreiheit.preferencesdelegate

import android.R
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import kotlin.properties.ReadWriteProperty

/**
 *
 * Created by timfreiheit on 16.05.15.
 */

/**
 * only use the subclasses
 * IntType, LongType, FloatType, BooleanType, StringType and their subclasses
 */
public trait GenericType<F, T> {
    fun typeFromValue(f: F): T
    fun valueFromType(t: T): F
}

trait IdentityGenericType<T, T> : GenericType<T, T> {
    override fun typeFromValue(f: T) = f
    override fun valueFromType(t: T) = t
}

public trait IntType<F> : GenericType<Int, F>
public trait LongType<F> : GenericType<Long, F>
public trait FloatType<F> : GenericType<Float, F>
public trait BooleanType<F> : GenericType<Boolean, F>
public trait StringType<F> : GenericType<String, F>
public trait StringSetType<F> : GenericType<Set<String>, F>

public object BaseStringType : IdentityGenericType<String, String>, StringType<String>

public object BaseIntType : IdentityGenericType<Int, Int>, IntType<Int>

public object BaseLongType : IdentityGenericType<Long, Long>, LongType<Long>

public object BaseFloatType : IdentityGenericType<Float, Float>, FloatType<Float>

public object BaseBooleanType : IdentityGenericType<Boolean, Boolean>, BooleanType<Boolean>

public object BaseStringSetType : IdentityGenericType<Set<String>, Set<String>>, StringSetType<Set<String>>


/**
 * uses Gson to convert F into an String and reverse
 */
public class GsonType<T> : StringType<T> {

    var type: Type? = null
    var clazz: Class<T>? = null

    constructor(type: Type) {
        this.type = type
    }

    constructor(clazz: Class<T>) {
        this.clazz = clazz
    }

    val gson = Gson()

    override fun typeFromValue(f: String): T {
        return if (type != null) {
            gson.fromJson(f, type)
        } else {
            gson.fromJson(f, clazz)
        }
    }

    override fun valueFromType(t: T): String {
        return if (type != null) {
            gson.toJson(t, type)
        } else {
            gson.toJson(t, clazz)
        }
    }

}

/**
 * @pre TnotNull? = T
 */
[suppress("unchecked_cast")]
class NullableType<F, T, TnotNull>(val wrappedType: GenericType<F, TnotNull>) : GenericType<F, T> {
    override fun valueFromType(t: T): F {
        return wrappedType.valueFromType(t as TnotNull)
    }

    override fun typeFromValue(f: F): T {
        if (f == null) {
            return null
        } else {
            return wrappedType.typeFromValue(f) as T
        }
    }
}


/**
 * use the ProvidePreferences interface to get the sharedPreferences to read and write data
 */
public class PreferencesDelegateWithProvider<F, T>(
        type: GenericType<F, T>
) : BasePreferencesDelegateGeneric<ProvidePreferences, F, T>(type) {
    override fun getSharedPreferences(thisRef: ProvidePreferences): SharedPreferences {
        return thisRef.sharedPreferences
    }
}

/**
 * holds an reference to the sharedPreferences to read and write data
 */
public class PreferencesDelegateWithoutProvider<F, T>(
        type: GenericType<F, T>,
        var sharedPreferences: SharedPreferences
) : BasePreferencesDelegateGeneric<Any, F, T>(type) {

    override fun getSharedPreferences(thisRef: Any): SharedPreferences {
        return sharedPreferences
    }
}


/**
 * holds an reference to the sharedPreferences to read and write data
 */
public abstract class BasePreferencesDelegateGeneric<in R, F, T>(
        val type: GenericType<F, T>
) : BasePreferencesDelegate<R, T>() {

    [suppress("unchecked_cast")]
    override fun get(thisRef: R, desc: PropertyMetadata): T {
        val usedKey = key ?: desc.name
        val sharedPreferences = getSharedPreferences(thisRef)

        if (!sharedPreferences.contains(usedKey)) {
            if (defaultValue == null && type !is NullableType<*, *, *>) {
                return noDefaultValue(usedKey, desc.name)
            }
            return defaultValue
        }

        var typeToCheck: GenericType<*, *> = type
        if (type is NullableType<*, *, *>) {
            typeToCheck = type.wrappedType
        }
        val returnVal: Any;
        when (typeToCheck) {
            is StringType -> returnVal = sharedPreferences.getString(
                    usedKey, null)

            is FloatType -> returnVal = sharedPreferences.getFloat(
                    usedKey, 0f)

            is IntType -> returnVal = sharedPreferences.getInt(
                    usedKey, 0)

            is BooleanType -> returnVal = sharedPreferences.getBoolean(
                    usedKey, false)

            is LongType -> returnVal = sharedPreferences.getLong(
                    usedKey, 0L)

            is StringSetType -> returnVal = sharedPreferences.getStringSet(usedKey, null)

            else -> throw IllegalArgumentException("${usedKey} for variable ${desc.name} type is not supported yet!!")

        }

        return type.typeFromValue(returnVal as F)
    }

    override fun set(thisRef: R, desc: PropertyMetadata, value: T) {
        val usedKey = key ?: desc.name

        val editor = getSharedPreferences(thisRef).edit()

        val convertedValue = type.valueFromType(value)
        if (convertedValue == null) {
            editor.remove(usedKey)
        } else {
            var typeToCheck: GenericType<*, *> = type
            if (type is NullableType<*, *, *>) {
                typeToCheck = type.wrappedType
            }
            [suppress("unchecked_cast")]
            when (typeToCheck) {
                is StringType -> editor.putString(usedKey, convertedValue as? String)
                is FloatType -> editor.putFloat(usedKey, convertedValue as Float)
                is IntType -> editor.putInt(usedKey, convertedValue as Int)
                is BooleanType -> editor.putBoolean(usedKey, convertedValue as Boolean)
                is LongType -> editor.putLong(usedKey, convertedValue as Long)
                is StringSetType -> editor.putStringSet(usedKey, convertedValue as Set<String>)
                else -> throw IllegalArgumentException(" variable type is not supported yet!!")
            }
        }
        editor.apply()
    }

}


/**
 * base implementation of the PreferenceDelegate
 * does not provide a reference to an Instance of SharedPreference
 */
abstract class BasePreferencesDelegate<in R, T>() : ReadWriteProperty<R, T> {

    public var key: String? = null
    public var defaultValue: T = null

    /**
     * @return the SharedPreferences to read and write the values
     */
    abstract fun getSharedPreferences(thisRef: R): SharedPreferences

    protected fun noDefaultValue(key: String, variableName: String): T =
            throw NullPointerException("${key} for variable ${variableName} is null but is assigned as not nullable")
}