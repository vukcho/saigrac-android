// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.diffplug.spotless") version "8.0.0"
}

spotless {

    kotlin {
        target("**/*.kt")
        ktlint("1.2.1").editorConfigOverride(
            mapOf(
                "ktlint_standard_package-name" to "disabled",
                "ktlint_standard_annotation" to "disabled",
            ),
        )
        suppressLintsFor {
            step = "ktlint"
            shortCode = "standard:function-naming"
        }
        trimTrailingWhitespace()
        endWithNewline()
    }

    kotlinGradle {
        target("**/*.gradle.kts")
        ktlint()
    }

    format("xml") {
        target("src/**/*.xml")
        trimTrailingWhitespace()
        endWithNewline()
    }

    format("misc") {
        target("**/*.md", "**/.gitignore")
        trimTrailingWhitespace()
        endWithNewline()
    }
}
