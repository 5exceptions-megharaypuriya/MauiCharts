# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Keep the classes related to Truvideo SDK
-keep class com.example.charts.TruvideoSdkCommonImpl { *; }
-keep class com.example.charts.TruvideoSdkContainer { *; }
-keep class com.example.charts.AuthContainer { *; }
-keep class com.example.charts.AuthService { *; }
-keep class com.example.charts.AuthServiceImpl { *; }
-keep class com.example.charts.TruvideoSdkCommon { *; }

# Keep the associated inner classes and methods
-keepclassmembers class com.example.charts.** {
    *;
}

# Keep code related to dependency injection (Kodein)
-keep class org.kodein.di.** { *; }

# Ensure that constructors are not stripped away
-keepclassmembers class * {
    public <init>(...);
}

# Prevent obfuscation of interfaces to maintain reflection compatibility
-keep interface com.example.charts.** { *; }

# Keep generic types and annotations for DI compatibility
-keepattributes Signature, Exceptions, RuntimeVisibleAnnotations, InnerClasses
