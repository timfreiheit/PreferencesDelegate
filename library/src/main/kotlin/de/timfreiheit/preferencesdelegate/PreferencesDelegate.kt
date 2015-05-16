package de.timfreiheit.preferencesdelegate

import android.content.SharedPreferences

/**
 *
 * Created by timfreiheit on 15.05.15.
 */

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
        return privateDelegate(
                prototype = 0,
                nullable = true,
                builder = builder)
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
        return privateDelegate(
                prototype = 0,
                nullable = false,
                builder = builder)
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
        return privateDelegate(
                prototype = 0L,
                nullable = true,
                builder = builder)
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
        return privateDelegate(
                prototype = 0L,
                nullable = false,
                builder = builder)
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
        return privateDelegate(
                prototype = "",
                nullable = true,
                builder = builder)
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
        return privateDelegate(
                prototype = "",
                nullable = false,
                builder = builder)
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
        return privateDelegate(
                prototype = false,
                nullable = true,
                builder = builder)
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
        return privateDelegate(
                prototype = false,
                nullable = false,
                builder = builder)
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
        return privateDelegate(
                prototype = 0f,
                nullable = true,
                builder = builder)
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
        return privateDelegate(
                prototype = 0f,
                nullable = false,
                builder = builder)
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
        return privateDelegate(
                prototype = setOf<String>(),
                nullable = true,
                builder = builder)
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
        return privateDelegate(
                prototype = setOf<String>(),
                nullable = false,
                builder = builder)
    }

    private fun privateDelegate<T : Any?>(
            nullable : Boolean = true,
            prototype : T = null,
            builder: (BasePreferencesDelegate<ProvidePreferences, T>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, T> {
        var delegate = PreferencesDelegateWithProvider(
                nullable = nullable,
                prototype = prototype)
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
        return privateDelegate(
                prototype = 0,
                nullable = true,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = 0,
                nullable = false,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = 0L,
                nullable = true,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = 0L,
                nullable = false,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = "",
                nullable = true,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = "",
                nullable = false,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = false,
                nullable = true,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = false,
                nullable = false,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = 0f,
                nullable = true,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = 0f,
                nullable = false,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = setOf<String>(),
                nullable = true,
                prefs = prefs,
                builder = builder)
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
        return privateDelegate(
                prototype = setOf<String>(),
                nullable = false,
                prefs = prefs,
                builder = builder)
    }

    private fun privateDelegate<T : Any?>(
            nullable : Boolean = true,
            prototype : T = null,
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, T>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, T> {
        var delegate = PreferencesDelegateWithoutProvider(
                nullable = nullable,
                prototype = prototype,
                sharedPreferences = prefs)
        if (builder != null) {
            delegate.builder()
        }
        return delegate
    }

    //end delegates without ProvidePreferences


    //generic delegates

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param type the type which is used to parse the raw value
     * @param builder init key and default value
     */
    public fun any<F,T>(
            type: GenericType<F,T>,
            builder: (BasePreferencesDelegate<ProvidePreferences, T>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, T> {
        var delegate = PreferencesDelegateAnyWithProvider(
                type = type)
        if(builder != null){
            delegate.builder()
        }
        return delegate
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * @param type the type which is used to parse the raw value
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun any<F,T>(
            type: GenericType<F,T>,
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, T>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, T> {
        var delegate = PreferencesDelegateAnyWithoutProvider(
                type = type,
                sharedPreferences = prefs)
        if(builder != null){
            delegate.builder()
        }
        return delegate
    }

}