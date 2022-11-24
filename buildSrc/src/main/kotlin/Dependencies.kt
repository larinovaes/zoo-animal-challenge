object Dependencies {

    private const val NAV_VERSION = "2.4.2"
    private const val RETROFIT_VERSION = "2.9.0"
    private const val MOSHI_VERSION = "1.13.0"
    private const val KOIN_VERSION = "3.2.0"
    private const val ROOM_VERSION = "2.4.1"
    const val DETEKT_VERSION = "1.20.0"

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:1.9.0"
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.5.1"
        const val VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
        const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
    }

    object UI {
        const val MATERIAL_DESIGN = "com.google.android.material:material:1.7.0"
        const val COIL_KTX = "io.coil-kt:coil:2.2.2"
        const val SWIPE_REFRESH = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
    }

    object DI {
        const val KOIN = "io.insert-koin:koin-android:$KOIN_VERSION"
    }

    object DataSource {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
        const val RETROFIT_CONVERTER = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VERSION"
        const val MOSHI = "com.squareup.moshi:moshi:$MOSHI_VERSION"
        const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:$MOSHI_VERSION"
        const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VERSION"
        const val ROOM = "androidx.room:room-ktx:$ROOM_VERSION"
        const val ROOM_COMPILER = "androidx.room:room-compiler:$ROOM_VERSION"
    }

    object UnitTest {
        const val KOIN = "io.insert-koin:koin-test:$KOIN_VERSION"
        const val JUNIT = "junit:junit:4.13.2"
        const val CORE_KTX = "androidx.test:core-ktx:1.4.0"
        const val CORE_TESTING = "androidx.arch.core:core-testing:2.1.0"
        const val MOCKK = "io.mockk:mockk:1.12.3"
        const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2"
    }

    object Classpath {
        const val GRADLE = "com.android.tools.build:gradle:7.2.1"
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"
        const val NAVIGATION = "androidx.navigation:navigation-safe-args-gradle-plugin:$NAV_VERSION"
        const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$DETEKT_VERSION"
        const val KTLINT = "org.jlleitschuh.gradle:ktlint-gradle:10.3.0"
        const val KOVER = "org.jetbrains.kotlinx:kover:0.5.0"
    }

    object Plugin {
        const val DETEKT = "io.gitlab.arturbosch.detekt"
        const val KTLINT = "org.jlleitschuh.gradle.ktlint"
    }
}
