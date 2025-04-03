import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    `java-library`
    id("org.jetbrains.kotlin.jvm") version "2.1.20"
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
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

kotlin {
    compilerOptions {
        allWarningsAsErrors = true
    }
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<BootRun>("bootRun") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

sourceSets.getByName("main") {
    java.srcDir("src/main/java")
    kotlin.srcDir("src/main/kotlin")
}

tasks.named("compileJava", JavaCompile::class.java) {
    val moduleName = "io.github.rweeks.evertz.kotlin"
    options.compilerArgumentProviders.add(CommandLineArgumentProvider {
        // Provide compiled Kotlin classes to javac – needed for Java/Kotlin mixed sources to work
        listOf("--patch-module", "$moduleName=${sourceSets["main"].output.asPath}")
    })
}
