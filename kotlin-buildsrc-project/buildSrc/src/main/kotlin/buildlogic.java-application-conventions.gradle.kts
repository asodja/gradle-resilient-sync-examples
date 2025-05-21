plugins {
    id("java-library")
    application
}

tasks.withType<JavaCompile>().configureEach {
    destinationDir = layout.buildDirectory.dir("classes").get().asFile
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}