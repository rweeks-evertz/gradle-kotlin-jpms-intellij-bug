plugins {
    java
}

group = "io.github.rweeks.evertz"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":kotlin-module"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(23))
    }
}
