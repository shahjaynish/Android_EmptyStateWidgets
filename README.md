## EmptyStateKit
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-green)](LICENSE)
[![API](https://img.shields.io/badge/API-24%2B-orange)](#)
---

EmptyStateKit is a lightweight, customizable Android Kotlin library that helps you display beautiful and consistent Empty States such as:

- No Internet
- No Data
- Error
- Custom Empty Screens

It is designed to be easy to integrate, developer-friendly, and fully customizable, while providing sensible defaults out of the box.

---

### Features

- Plug-and-play Empty State View
- Predefined states: No Internet, No Data, Error
- Optional action button per state (Retry / Refresh)
- Override icons, messages, and button text
- Clean Kotlin API
- XML + Kotlin support
- Lightweight & dependency-free

---

## Installation (JitPack)

### 1️⃣ Add JitPack to your **root `settings.gradle` or `build.gradle`**

```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
### Add Dependency
```
dependencies {
	        implementation 'com.github.Excelsior-Technologies-Community:Android_AppDialogs:1.0.0'
	}
```

---

### Basic Usage (XML)

Add EmptyStateView to your layout:
```xml
<com.ext.emptystatekit.ui.EmptyStateView
    android:id="@+id/emptyView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:es_title="No Data"
    app:es_message="Nothing to show here"
    app:es_buttonText="Retry"/>
```

### Usage (Kotlin – Recommended)

Show predefined states

No Internet
```kotlin
emptyView.showNoInternet()
```

No Data
```kotlin
emptyView.showNoData()
```

Error
```kotlin
emptyView.showError()
```

----

### State with Action Button

No Internet with Retry
```kotlin
emptyView.showNoInternet {
    retryApiCall()
}
```

No Data with Refresh
```kotlin
emptyView.showNoData(
    actionText = "Refresh"
) {
    reloadData()
}
```

Error with custom message + action
```kotlin
emptyView.showError(
    message = "Server not responding",
    actionText = "Retry"
) {
    callApiAgain()
}
```

----

### Override Icons & Messages

You can override icons and messages for any predefined state.

```kotlin
emptyView.showNoInternet(
    icon = R.drawable.ic_custom_wifi,
    message = "Turn on mobile data or Wi-Fi"
)
```

```kotlin
emptyView.showError(
    icon = R.drawable.ic_server_error,
    message = "Internal server error"
)
```

Show / Hide View
```kotlin
emptyView.show()
emptyView.hide()
```

----

### Custom State (Manual)

You can also control the view manually via XML attributes:
```xml
app:es_icon="@drawable/ic_empty"
app:es_title="Empty"
app:es_message="Nothing here yet"
app:es_buttonText="Reload"
```

---

### Included Default States

| State        | Default Icon     | Default Button |
|--------------|------------------|----------------|
| No Internet  | `ic_no_internet` | Retry          |
| No Data      | `ic_no_data`     | Refresh        |
| Error        | `ic_error`       | Retry          |

**All can be overridden**

---

### License

```
MIT License

Copyright (c) 2025 Excelsior Technologies 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```



