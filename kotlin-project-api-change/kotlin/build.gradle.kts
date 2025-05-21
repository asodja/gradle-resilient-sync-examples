plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

testing {
    suites {
        register<JvmTestSuite>("weirdTest") {
            testType = "weird"
        }
    }
}
