package de.timfreiheit.preferencesdelegate

import android.content.Context
import android.content.SharedPreferences
import android.test.AndroidTestCase
import android.test.suitebuilder.annotation.SmallTest
import kotlin.properties.Delegates
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull

public class PreferencesTestWithProvider: AndroidTestCase(){

    var prefs : Pref by Delegates.notNull()

    override fun setUp(){
        var preferences = mContext.getSharedPreferences("TEST_PREFS",Context.MODE_PRIVATE)
        preferences.edit().clear().commit()
        prefs = Pref(preferences)
    }

    override fun tearDown(){
        prefs.sharedPreferences.edit().clear().commit()
    }

    public fun testStringValue(){

        var currentValue = prefs.stringValue
        assertNull(currentValue)

        prefs.stringValue = "value"
        currentValue = prefs.stringValue
        assertEquals(currentValue,"value")

    }

    public fun testStringNotNull(){
        var currentValue = prefs.stringValueNotNull
        assertEquals(currentValue,"DEFAULT")

        prefs.stringValueNotNull = "value"
        currentValue = prefs.stringValueNotNull
        assertEquals("value",currentValue)
    }

    public fun testStringValueNotNullWithoutDefault() {
        var currentValue: String;
        try{
            currentValue = prefs.stringValueNotNullWithoutDefault
            assertFalse(true, "Should throw NullPointerException: ${currentValue}")
        }catch(e: NullPointerException){
        }

        prefs.stringValueNotNullWithoutDefault = "value"
        currentValue = prefs.stringValueNotNullWithoutDefault
        assertEquals("value",currentValue)
    }

    public fun testStringValueWithCustomKey() {

        val CUSTOM_KEY = "CUSTOM_KEY"

        var currentValue = prefs.stringValueWithCustomKey
        assertEquals(currentValue,
                prefs.sharedPreferences.getString(CUSTOM_KEY,"")
        )

        prefs.stringValueWithCustomKey = "value"
        currentValue = prefs.stringValueWithCustomKey
        assertEquals("value",currentValue)
        assertEquals(prefs.sharedPreferences.getString(CUSTOM_KEY,null),currentValue)
    }
}


private class Pref(
        override var sharedPreferences : SharedPreferences
): ProvidePreferences{

    var stringValue by PreferencesDelegate.string(sharedPreferences)

    var stringValueNotNull by PreferencesDelegate.stringNotNull{
        defaultValue = "DEFAULT"
    }

    var stringValueNotNullWithoutDefault by PreferencesDelegate.stringNotNull()

    var stringValueWithCustomKey by PreferencesDelegate.string{
        key = "CUSTOM_KEY"
        defaultValue = ""
    }
}
