// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("com.google.dagger.hilt.android") version "2.49" apply false
    //id("kotlin-kapt") apply false
}

buildscript{
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.49")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.20")
        classpath("androidx.room:room-gradle-plugin:2.6.1")
    }
}
