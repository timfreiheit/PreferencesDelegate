package de.timfreiheit.preferencesdelegate

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty

public trait ProvidePreferences {
    var sharedPreferences: SharedPreferences
}

public object PreferencesDelegate {

    //start delegates with ProvidePreferences
    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun int(
            builder: (BasePreferencesDelegate<ProvidePreferences, Int?>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Int?> {
        return privateDelegate(builder).apply {
            value = 0
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun intNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, Int>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Int> {
        return privateDelegate(builder).apply {
            value = 0
            nullable = false
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun long(
            builder: (BasePreferencesDelegate<ProvidePreferences, Long?>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Long?> {
        return privateDelegate(builder).apply {
            value = 0L
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun longNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, Long>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Long> {
        return privateDelegate(builder).apply {
            value = 0L
            nullable = false
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun string(
            builder: (BasePreferencesDelegate<ProvidePreferences, String?>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, String?> {
        return privateDelegate(builder).apply {
            value = ""
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun stringNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, String>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, String> {
        return privateDelegate(builder).apply {
            value = ""
            nullable = false
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun bool(
            builder: (BasePreferencesDelegate<ProvidePreferences, Boolean?>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Boolean?> {
        return privateDelegate(builder).apply {
            value = false
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun boolNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, Boolean>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Boolean> {
        return privateDelegate(builder).apply {
            value = false
            nullable = false
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun float(
            builder: (BasePreferencesDelegate<ProvidePreferences, Float?>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Float?> {
        return privateDelegate(builder).apply {
            value = 0f
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun floatNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, Float>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Float> {
        return privateDelegate(builder).apply {
            value = 0f
            nullable = false
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun stringSet(
            builder: (BasePreferencesDelegate<ProvidePreferences, Set<String>?>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Set<String>?> {
        return privateDelegate(builder).apply {
            value = setOf<String>()
            nullable = true
        }
    }


    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * @param builder init key and default value
     */
    public fun stringSetNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, Set<String>>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Set<String>> {
        return privateDelegate(builder).apply {
            value = setOf<String>()
            nullable = false
        }
    }

    private fun privateDelegate<T : Any?>(
            builder: (BasePreferencesDelegate<ProvidePreferences, T>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, T> {
        var delegate = PreferencesDelegateWithProvider<T>()
        if (builder != null) {
            delegate.builder()
        }
        return delegate
    }

    //end delegates with ProvidePreferences



    //start delegates without ProvidePreferences
    //users must give an extra instance of SharedPreferences

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun int(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Int?>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Int?> {
        return privateDelegate(prefs, builder).apply {
            value = 0
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun intNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Int>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Int> {
        return privateDelegate(prefs, builder).apply {
            value = 0
            nullable = false
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun long(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Long?>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Long?> {
        return privateDelegate(prefs, builder).apply {
            value = 0L
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun longNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Long>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Long> {
        return privateDelegate(prefs, builder).apply {
            value = 0L
            nullable = false
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun string(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, String?>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, String?> {
        return privateDelegate(prefs, builder).apply {
            value = ""
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun stringNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, String>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, String> {
        return privateDelegate(prefs, builder).apply {
            value = ""
            nullable = false
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun bool(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Boolean?>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Boolean?> {
        return privateDelegate(prefs, builder).apply {
            value = false
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun boolNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Boolean>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Boolean> {
        return privateDelegate(prefs, builder).apply {
            value = false
            nullable = false
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun float(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Float?>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Float?> {
        return privateDelegate(prefs, builder).apply {
            value = 0f
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun floatNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Float>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Float> {
        return privateDelegate(prefs, builder).apply {
            value = 0f
            nullable = false
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun stringSet(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Set<String>?>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Set<String>?> {
        return privateDelegate(prefs, builder).apply {
            value = setOf<String>()
            nullable = true
        }
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun stringSetNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Set<String>>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Set<String>> {
        return privateDelegate(prefs, builder).apply {
            value = setOf<String>()
            nullable = false
        }
    }

    private fun privateDelegate<T : Any?>(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, T>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, T> {
        var delegate = PreferencesDelegateWithoutProvider<T>(prefs)
        if (builder != null) {
            delegate.builder()
        }
        return delegate
    }

    //end delegates without ProvidePreferences

}

/**
 * use the ProvidePreferences interface to get the sharedPreferences to read and write data
 */
public class PreferencesDelegateWithProvider<T> : BasePreferencesDelegate<ProvidePreferences, T>() {
    override fun getSharedPreferences(thisRef: ProvidePreferences): SharedPreferences {
        return thisRef.sharedPreferences
    }
}

/**
 * holds an reference to the sharedPreferences to read and write data
 */
public class PreferencesDelegateWithoutProvider<T>(
        var sharedPreferences: SharedPreferences
) : BasePreferencesDelegate<Any, T>() {

    override fun getSharedPreferences(thisRef: Any): SharedPreferences {
        return sharedPreferences
    }
}

/**
 * base implementation of the PreferenceDelegate
 * does not provide a reference to an Instance of SharedPreference
 */
abstract class BasePreferencesDelegate<in R, T> : ReadWriteProperty<R, T> {

    var nullable: Boolean = true
    var value: T = null

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

        val retrunVal: T;
        [suppress("unchecked_cast")]
        when (value) {
            is String -> retrunVal = sharedPreferences.getString(
                    usedKey,
                    defaultValue as? String) as T

            is Float -> retrunVal = sharedPreferences.getFloat(
                    usedKey,
                    (defaultValue as? Float) ?: noDefaultValue()) as T

            is Int -> retrunVal = sharedPreferences.getInt(
                    usedKey,
                    (defaultValue as? Int) ?: noDefaultValue()) as T

            is Boolean -> retrunVal = sharedPreferences.getBoolean(
                    usedKey,
                    (defaultValue as? Boolean) ?: noDefaultValue()) as T

            is Long -> retrunVal = sharedPreferences.getLong(
                    usedKey,
                    (defaultValue as? Long) ?: noDefaultValue()) as T

            else -> throw IllegalArgumentException("${usedKey} for variable ${desc.name} type is not supported yet!!")

        }

        if (!nullable && retrunVal == null) {
            throw NullPointerException("${usedKey} for variable ${desc.name} is null but is assigned as not nullable")
        }

        return retrunVal
    }

    override fun set(thisRef: R, desc: PropertyMetadata, value: T) {
        val usedKey = key ?: desc.name

        val editor = getSharedPreferences(thisRef).edit()

        when (value) {
            is String -> editor.putString(usedKey, value)
            is Float -> editor.putFloat(usedKey, value)
            is Int -> editor.putInt(usedKey, value)
            is Boolean -> editor.putBoolean(usedKey, value)
            is Long -> editor.putLong(usedKey, value)
            else -> throw IllegalArgumentException(" variable type is not supported yet!!")
        }
        editor.apply()
    }

    /**
     * @return the SharedPreferences to read and write the values
     */
    abstract fun getSharedPreferences(thisRef: R): SharedPreferences

    private fun noDefaultValue() = throw NullPointerException("no default value provided but try to read from sharedpreferences")
}

/**
 * apply an function to an Object and returns this afterwards
 */
private fun T.apply<T>(t: T.() -> Unit): T {
    this.t()
    return this
}
