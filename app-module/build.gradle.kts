import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("io.spring.dependency-management") version "1.1.7"
    id("org.springframework.boot") version "3.4.4"
}

group = "io.github.rweeks.evertz"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":kotlin-module"))

    implementation("org.springframework.boot:spring-boot-starter")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(23))
    }
}

springBoot {
    mainClass = "io.github.rweeks.evertz.Main"
    buildInfo()
}

tasks.getByName<BootJar>("bootJar") {
    enabled = true
}