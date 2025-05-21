plugins {
    `java-library`
    // id("custom")
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

abstract class MyTask : DefaultTask() {

    @get:InputDirectory
    abstract val inputFile: DirectoryProperty


    @TaskAction
    fun run() {
        println("My input dir: " + inputFile.asFile.get())
    }
}

val javaDoc: TaskProvider<Javadoc> = tasks.javadoc
tasks.register<MyTask>("myTask") {
    // TODO: Fix for Gradle 9
    inputFile = javaDoc.map { it.destinationDir!! }
}