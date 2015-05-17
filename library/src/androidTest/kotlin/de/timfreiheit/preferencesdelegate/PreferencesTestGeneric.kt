package de.timfreiheit.preferencesdelegate

import android.content.Context
import android.content.SharedPreferences
import android.test.AndroidTestCase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.properties.Delegates
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull

/**
 *
 * Created by timfreiheit on 16.05.15.
 */

public class PreferencesTestGeneric: AndroidTestCase(){

    var prefs : PrefGeneric by Delegates.notNull()

    override fun setUp(){
        var preferences = mContext.getSharedPreferences("TEST_PREFS_2",Context.MODE_PRIVATE)
        preferences.edit().clear().commit()
        prefs = PrefGeneric(preferences)
    }

    override fun tearDown(){
        prefs.sharedPreferences.edit().clear().commit()
    }

    fun testWithDefault(){

        val defaultData = DataToStore(val1 = "" , val2 = 1);

        var data = prefs.dataToStoreWithDefault

        assertEquals(defaultData,data)

        val newData = DataToStore(val1 = "TEST", val2 = 42)
        prefs.dataToStoreWithDefault = newData

        assertEquals(newData,prefs.dataToStoreWithDefault)

    }

    fun testWithOutDefault(){

        var data = prefs.dataToStoreWithOutDefault

        assertNull(data)

        val newData = DataToStore(val1 = "TEST", val2 = 42)
        prefs.dataToStoreWithOutDefault = newData

        assertEquals(newData,prefs.dataToStoreWithOutDefault)

    }


    fun testWithOutDefaultNotNull(){

        try{
            var data = prefs.dataToStoreWithOutDefaultNotNull
            assertFalse(true, "Should throw NullPointerException: ${data}")
        }catch(e : NullPointerException){}

        val newData = DataToStore(val1 = "TEST", val2 = 42)
        prefs.dataToStoreWithOutDefaultNotNull = newData

        assertEquals(newData,prefs.dataToStoreWithOutDefaultNotNull)

    }


}

data class DataToStore(val val1: String, val val2: Int )

private class PrefGeneric(
        override var sharedPreferences : SharedPreferences
): ProvidePreferences{

    var dataToStoreWithDefault by PreferencesDelegate.anyNotNull(GsonType(javaClass<DataToStore>())){
        key = "dataToStore_Key1"
        defaultValue = DataToStore(val1 = "" , val2 = 1)
    }

    var dataToStoreWithOutDefault by PreferencesDelegate.any(GsonType(javaClass<DataToStore>())){
        key = "dataToStore_Key2"
    }


    var dataToStoreWithOutDefaultNotNull by PreferencesDelegate.anyNotNull(GsonType(javaClass<DataToStore>())){
        key = "dataToStore_Key3"
    }

}
