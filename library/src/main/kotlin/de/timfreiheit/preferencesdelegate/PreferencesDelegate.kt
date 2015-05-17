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
        return any(type = BaseIntType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param builder init key and default value
     */
    public fun intNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, Int>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Int> {
        return anyNotNull(type = BaseIntType, builder = builder)
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
        return any(type = BaseLongType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param builder init key and default value
     */
    public fun longNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, Long>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Long> {
        return anyNotNull(type = BaseLongType, builder = builder)
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
        return any(type = BaseStringType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param builder init key and default value
     */
    public fun stringNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, String>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, String> {
        return anyNotNull(type = BaseStringType, builder = builder)
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
        return any(type = BaseBooleanType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param builder init key and default value
     */
    public fun boolNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, Boolean>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Boolean> {
        return anyNotNull(type = BaseBooleanType, builder = builder)
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
        return any(type = BaseFloatType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param builder init key and default value
     */
    public fun floatNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, Float>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Float> {
        return anyNotNull(type = BaseFloatType, builder = builder)
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
        return any(type = BaseStringSetType, builder = builder)
    }


    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     * The instance of the SharedPreferences are provided over
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param builder init key and default value
     */
    public fun stringSetNotNull(
            builder: (BasePreferencesDelegate<ProvidePreferences, Set<String>>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, Set<String>> {
        return anyNotNull(type = BaseStringSetType, builder = builder)
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
        return any(prefs = prefs,type = BaseIntType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun intNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Int>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Int> {
        return anyNotNull(prefs = prefs,type = BaseIntType, builder = builder)
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
        return any(prefs = prefs,type = BaseLongType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun longNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Long>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Long> {
        return anyNotNull(prefs = prefs,type = BaseLongType, builder = builder)
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
        return any(prefs = prefs,type = BaseStringType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun stringNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, String>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, String> {
        return anyNotNull(prefs = prefs,type = BaseStringType, builder = builder)
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
        return any(prefs = prefs,type = BaseBooleanType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun boolNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Boolean>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Boolean> {
        return anyNotNull(prefs = prefs,type = BaseBooleanType, builder = builder)
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
        return any(prefs = prefs,type = BaseFloatType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun floatNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Float>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Float> {
        return anyNotNull(prefs = prefs,type = BaseFloatType, builder = builder)
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
        return any(prefs = prefs,type = BaseStringSetType, builder = builder)
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param prefs the SharedPreferences where the property values are stored.
     * @param builder init key and default value
     */
    public fun stringSetNotNull(
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, Set<String>>.() -> Unit)? = null
    ): BasePreferencesDelegate<Any, Set<String>> {
        return anyNotNull(prefs = prefs,type = BaseStringSetType, builder = builder)
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
            builder: (BasePreferencesDelegate<ProvidePreferences, T?>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, T?> {
        var delegate = PreferencesDelegateWithProvider<F,T?>(
                type = NullableType(type))
        if(builder != null){
            delegate.builder()
        }
        return delegate
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param type the type which is used to parse the raw value
     * @param builder init key and default value
     */
    public fun anyNotNull<F,T>(
            type: GenericType<F,T>,
            builder: (BasePreferencesDelegate<ProvidePreferences, T>.() -> Unit)? = null
    ): BasePreferencesDelegate<ProvidePreferences, T> {
        var delegate = PreferencesDelegateWithProvider(
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
     * @param builder init key and default value
     */
    public fun any<F,T>(
            type: GenericType<F,T>,
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, T?>.() -> Unit)? = null
    ): BasePreferencesDelegateGeneric<Any, F,T?> {
        var delegate = PreferencesDelegateWithoutProvider<F,T?>(
                sharedPreferences = prefs,
                type = NullableType(type))
        if(builder != null){
            delegate.builder()
        }
        return delegate
    }

    /**
     * Returns a property delegate for a read-only property that takes its value from a SharedPreferences,
     * using the property name or the defined key in the builder as the key.
     *
     * Trying to read the property before the initial value has been
     * assigned and not having an defaultValue results in an exception.
     *
     * @param type the type which is used to parse the raw value
     * @param builder init key and default value
     */
    public fun anyNotNull<F,T>(
            type: GenericType<F,T>,
            prefs: SharedPreferences,
            builder: (BasePreferencesDelegate<Any, T>.() -> Unit)? = null
    ): BasePreferencesDelegateGeneric<Any, F,T> {
        var delegate = PreferencesDelegateWithoutProvider<F,T>(
                sharedPreferences = prefs,
                type = NullableType(type))
        if(builder != null){
            delegate.builder()
        }
        return delegate
    }


}