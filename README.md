PreferencesDelegate for Kotlin
==============================

Delegates to easily access SharedPreferences for Kotlin.

## ProvidePreferences

Classes which use the delegates can provide SharedPreferences by implementing ProvidePreferences

```kotlin

    public class Prefs : ProvidePreferences{
        override var sharedPreferences = /*some preferences*/


        var stringValue by PreferencesDelegate.string{
            key = "CUSTOM_KEY_STRING"       //optional
            defaultValue = "default value"  //optional
        }


        var boolValue by PreferencesDelegate.bool{
            key = "CUSTOM_KEY_BOOL"     //optional
            defaultValue = true         //optional
        }

        var intValue by PreferencesDelegate.int{
            key = "CUSTOM_KEY_INT"      //optional
            defaultValue = 1            //optional
        }

        var longValue by PreferencesDelegate.long{
            key = "CUSTOM_KEY_LONG"     //optional
            defaultValue = 1L           //optional
        }

        var floatValue by PreferencesDelegate.float{
            key = "CUSTOM_KEY_FLOAT"    //optional
            defaultValue = 1f           //optional
        }

        var stringSet by PreferencesDelegate.stringSet{
            key = "CUSTOM_KEY_STRING_SET"      //optional
            defaultValue = setOf()  //optional
        }

    }

```

## Without ProvidePreferences

Every delegate can be used without ProvidePreferences when you pass the preferences as an argument like:


```kotlin

    var stringValue by PreferencesDelegate.string(sharedPreferences)

```


## Store none primitive types
You can also store none primitive types in SharedPreferences when you convert them in one of the other types.
The most common example is store objects via Gson as string.
To Provide this transformation you can implement the following traits.
Do not use GenericType directly.

```kotlin

    public trait IntType<F> : GenericType<Int, F>
    public trait LongType<F> : GenericType<Long, F>
    public trait FloatType<F> : GenericType<Float, F>
    public trait BooleanType<F> : GenericType<Boolean, F>
    public trait StringType<F> : GenericType<String, F>

```

An example with Gson is predefined in the type GsonType
You can use these types like following:


```kotlin

    data class DataToStore(val val1: String, val val2: Int )

    var dataToStore by PreferencesDelegate.any(GsonType(javaClass<DataToStore>())){
        key = "dataToStore_Key"
        defaultValue = DataToStore(val1 = "" , val2 = 1)
    }

```

## Nullable and not Nullable

Every delegate exists in two different variants.
They can be nullable and not nullable.
Not nullable values without an default value will throw an NullPointerException when you try to read them before they have an value.

### Nullable

```kotlin

    var stringValue by PreferencesDelegate.string()

```

### Not Nullable

```kotlin

    var stringValue by PreferencesDelegate.stringNotNull()

```


License
-------

    Copyright 2015 Tim Freiheit

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.