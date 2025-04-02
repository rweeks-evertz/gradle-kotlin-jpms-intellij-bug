plugins {
    java
    kotlin("jvm") version "2.1.20"
}

group = "io.github.rweeks.evertz"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.20")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(23))
    }
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(23))
    }
}

tasks.named("compileJava", JavaCompile::class.java) {
    val moduleName = "io.github.rweeks.evertz.kotlin"
    options.compilerArgumentProviders.add(CommandLineArgumentProvider {
        // Provide compiled Kotlin classes to javac – needed for Java/Kotlin mixed sources to work
        listOf("--patch-module", "$moduleName=${sourceSets["main"].output.asPath}")
    })
}
