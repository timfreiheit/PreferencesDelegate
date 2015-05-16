package de.timfreiheit.preferencesdelegate

import android.R
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 *
 * Created by timfreiheit on 16.05.15.
 */

/**
 * only use the subclasses
 * IntType, LongType, FloatType, BooleanType, StringType and their subclasses
 */
public trait GenericType<F, T> {
    fun typeFromValue(f: F?): T
    fun valueFromType(t: T): F
}

public trait IntType<F> : GenericType<Int, F>
public trait LongType<F> : GenericType<Long, F>
public trait FloatType<F> : GenericType<Float, F>
public trait BooleanType<F> : GenericType<Boolean, F>
public trait StringType<F> : GenericType<String, F>

/**
 * uses Gson to convert F into an String and reverse
 */
public class GsonType<F> : StringType<F> {

    var type : Type? = null
    var clazz : Class<F>? = null

    constructor(type : Type){
        this.type = type
    }

    constructor(clazz : Class<F>){
        this.clazz = clazz
    }

    val gson = Gson()

    override fun typeFromValue(f: String?): F {
        return if(type != null){
            gson.fromJson(f, type)
        }else{
            gson.fromJson(f, clazz)
        }
    }

    override fun valueFromType(t: F): String {
        return if(type != null) {
            gson.toJson(t, type)
        }else{
            gson.toJson(t,clazz)
        }
    }

}


/**
 * use the ProvidePreferences interface to get the sharedPreferences to read and write data
 */
public class PreferencesDelegateAnyWithProvider<F,T>(
        type: GenericType<F, T>
) : PreferencesDelegateAny<ProvidePreferences,F, T>(type) {
    override fun getSharedPreferences(thisRef: ProvidePreferences): SharedPreferences {
        return thisRef.sharedPreferences
    }
}

/**
 * holds an reference to the sharedPreferences to read and write data
 */
public class PreferencesDelegateAnyWithoutProvider<F,T>(
        type: GenericType<F, T>,
        var sharedPreferences: SharedPreferences
) : PreferencesDelegateAny<Any,F, T>(type) {

    override fun getSharedPreferences(thisRef: Any): SharedPreferences {
        return sharedPreferences
    }
}


/**
 * holds an reference to the sharedPreferences to read and write data
 */
public abstract class PreferencesDelegateAny<in R, F, T>(
        val type: GenericType<F, T>
) : BasePreferencesDelegate<R, T>(nullable = true) {

    [suppress("unchecked_cast")]
    override fun get(thisRef: R, desc: PropertyMetadata): T {
        val usedKey = key ?: desc.name
        val sharedPreferences = getSharedPreferences(thisRef)

        if (!sharedPreferences.contains(usedKey)) {
            return defaultValue
        }

        val returnVal: Any;
        when (type) {
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

            else -> throw IllegalArgumentException("${usedKey} for variable ${desc.name} type is not supported yet!!")

        }

        return type.typeFromValue(returnVal as? F)
    }

    override fun set(thisRef: R, desc: PropertyMetadata, value: T) {
        val usedKey = key ?: desc.name

        val editor = getSharedPreferences(thisRef).edit()

        val convertedValue = type.valueFromType(value)
        if (convertedValue == null) {
            editor.remove(usedKey)
        } else {
            [suppress("unchecked_cast")]
            when (type) {
                is StringType -> editor.putString(usedKey, convertedValue as? String)
                is FloatType -> editor.putFloat(usedKey, convertedValue as Float)
                is IntType -> editor.putInt(usedKey, value as Int)
                is BooleanType -> editor.putBoolean(usedKey, value as Boolean)
                is LongType -> editor.putLong(usedKey, value as Long)
                else -> throw IllegalArgumentException(" variable type is not supported yet!!")
            }
        }
        editor.apply()
    }

}