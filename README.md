# 📱 Algorithm Task - Android App (JaixLabs)

An Android application built in **Kotlin** that displays numbers from 1 to 100 in a grid layout.  
Users can dynamically highlight numbers based on the following mathematical patterns:

- 🟢 Odd Numbers  
- 🔵 Even Numbers  
- 🟠 Prime Numbers  
- 🟣 Fibonacci Numbers

---

## ✨ Features

- 📊 Grid of Numbers (1 to 100)
- 🔁 Rule-based Highlighting: Odd, Even, Prime, Fibonacci
- 🎨 Dynamic UI with Smooth Color Transitions
- 🌗 Light and Dark Theme Support (Material 3)
- 🧩 Rounded Cards with Elevation & Padding
- 🎛️ Custom Spinner with Themed Background & Drop-down Arrow
- ⚡ Optimized for Performance and Clarity

---

## 📷 Screenshots

### 🔆 Light Mode
<img src="screenshots/screenshot_light_1.png" width="300"/> <img src="screenshots/screenshot_light_2.png" width="300"/>

### 🌙 Dark Mode
<img src="screenshots/screenshot_dark_1.png" width="300"/> <img src="screenshots/screenshot_dark_2.png" width="300"/>

> 📌 **Tip**: Place your screenshots inside a `/screenshots/` folder in the root of the repository.

---

## 🛠 Built With

- [Kotlin](https://kotlinlang.org/)
- [Android Jetpack Components](https://developer.android.com/jetpack)
- [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- [CardView](https://developer.android.com/jetpack/androidx/releases/cardview)
- [Material 3 Theme](https://m3.material.io/)
- XML Layouts

---


🧑‍💻 Open in Android Studio:

    Open Project in Android Studio

    Let it Sync Gradle

    Run the app on Emulator or Real Device

📁 Project Structure

  algorithm-task-android/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com.jaixlabs.algorithmtask/
│   │       │       ├── MainActivity.kt
│   │       │       └── adapter/
│   │       │           └── NumberAdapter.kt
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml
│   │       │   │   └── item_number.xml
│   │       │   ├── drawable/
│   │       │   │   └── spinner_background_with_icon.xml
│   │       │   ├── values/
│   │       │   │   ├── colors.xml
│   │       │   │   ├── themes.xml
├── screenshots/
│   ├── screenshot_light_1.png
│   ├── screenshot_light_2.png
│   ├── screenshot_dark_1.png
│   └── screenshot_dark_2.png

