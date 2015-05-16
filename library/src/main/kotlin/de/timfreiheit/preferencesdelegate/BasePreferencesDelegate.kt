package de.timfreiheit.preferencesdelegate

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty

/**
 *
 * Created by timfreiheit on 16.05.15.
 */

/**
 * use the ProvidePreferences interface to get the sharedPreferences to read and write data
 */
public class PreferencesDelegateWithProvider<T>(
        nullable : Boolean = true,
        prototype : T = null
) : BasePreferencesDelegate<ProvidePreferences, T>(nullable = nullable, prototype = prototype) {
    override fun getSharedPreferences(thisRef: ProvidePreferences): SharedPreferences {
        return thisRef.sharedPreferences
    }
}

/**
 * holds an reference to the sharedPreferences to read and write data
 */
public class PreferencesDelegateWithoutProvider<T>(
        nullable : Boolean = true,
        prototype : T = null,
        var sharedPreferences: SharedPreferences
) : BasePreferencesDelegate<Any, T>(nullable = nullable, prototype = prototype) {

    override fun getSharedPreferences(thisRef: Any): SharedPreferences {
        return sharedPreferences
    }
}

/**
 * base implementation of the PreferenceDelegate
 * does not provide a reference to an Instance of SharedPreference
 */
abstract class BasePreferencesDelegate<in R, T>(
        private var nullable : Boolean = true,
        private var prototype : T = null) : ReadWriteProperty<R, T> {

    public var key: String? = null
    public var defaultValue: T = null

    override fun get(thisRef: R, desc: PropertyMetadata): T {
        val usedKey = key ?: desc.name
        val sharedPreferences = getSharedPreferences(thisRef)

        if (!sharedPreferences.contains(usedKey)) {
            if (!nullable && defaultValue == null) {
                throw NullPointerException("${usedKey} for variable ${desc.name} is null but is assigned as not nullable")
            }
            return defaultValue
        }

        val returnVal: T;
        [suppress("unchecked_cast")]
        when (prototype) {
            is String -> returnVal = sharedPreferences.getString(
                    usedKey,
                    defaultValue as? String) as T

            is Float -> returnVal = sharedPreferences.getFloat(
                    usedKey,
                    (defaultValue as? Float) ?: noDefaultValue()) as T

            is Int -> returnVal = sharedPreferences.getInt(
                    usedKey,
                    (defaultValue as? Int) ?: noDefaultValue()) as T

            is Boolean -> returnVal = sharedPreferences.getBoolean(
                    usedKey,
                    (defaultValue as? Boolean) ?: noDefaultValue()) as T

            is Long -> returnVal = sharedPreferences.getLong(
                    usedKey,
                    (defaultValue as? Long) ?: noDefaultValue()) as T

            is Set<*> -> returnVal = sharedPreferences.getStringSet(
                    usedKey,
                    defaultValue as? Set<String>) as T

            else -> throw IllegalArgumentException("${usedKey} for variable ${desc.name} type is not supported yet!!")

        }

        if (!nullable && returnVal == null) {
            throw NullPointerException("${usedKey} for variable ${desc.name} is null but is assigned as not nullable")
        }

        return returnVal
    }

    override fun set(thisRef: R, desc: PropertyMetadata, value: T) {
        val usedKey = key ?: desc.name

        val editor = getSharedPreferences(thisRef).edit()

        [suppress("unchecked_cast")]
        when (value) {
            is String -> editor.putString(usedKey, value)
            is Float -> editor.putFloat(usedKey, value)
            is Int -> editor.putInt(usedKey, value)
            is Boolean -> editor.putBoolean(usedKey, value)
            is Long -> editor.putLong(usedKey, value)
            is Set<*> -> editor.putStringSet(usedKey,value as? Set<String>)
            else -> throw IllegalArgumentException(" variable type is not supported yet!!")
        }
        editor.apply()
    }

    /**
     * @return the SharedPreferences to read and write the values
     */
    abstract fun getSharedPreferences(thisRef: R): SharedPreferences

    private fun noDefaultValue() = throw NullPointerException("no default value provided but try to read from SharedPreferences")
}