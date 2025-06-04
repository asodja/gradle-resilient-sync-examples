plugins {
    `java-library`
    // Test
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