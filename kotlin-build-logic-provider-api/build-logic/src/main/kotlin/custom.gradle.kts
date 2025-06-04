plugins {
    `java-library`
    // Test
}

tasks.withType<Exec>().configureEach {
    // With Gradle 9 you have to use
    // commandLine(listOf("echo", "Hello, world!"))
    commandLine = listOf("echo", "Hello, world!")
}

tasks.withType<JavaCompile>().configureEach {
    doLast {
        // With Gradle 9 you have to call
        // options.allCompilerArgs.get().forEach(::println)
        options.allCompilerArgs.forEach(::println)
    }
}

val javaDoc: TaskProvider<Javadoc> = tasks.javadoc
tasks.register<MyTask>("myTask") {
    // With Gradle 9 one option is to call
    // inputFile = javaDoc.flatMap { it.destinationDir }
    inputFile = javaDoc.map { it.destinationDir!! }
}