plugins {
    `java-library`
    id("custom")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<Exec>().configureEach {
    // TODO: Fix for Gradle 9
    commandLine = listOf("echo", "Hello, world!")
}


tasks.withType<JavaCompile>().configureEach {
    doLast {
        // TODO: Fix for Gradle 9
        options.allCompilerArgs.forEach(::println)
    }
}

val javaDoc: TaskProvider<Javadoc> = tasks.javadoc
tasks.register<MyTask>("myOtherTask") {
    // TODO: Fix for Gradle 9
    inputFile = javaDoc.map { it.destinationDir!! }
}
