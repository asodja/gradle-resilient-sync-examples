import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction

abstract class MyTask : DefaultTask() {

    @get:InputDirectory
    abstract val inputFile: DirectoryProperty


    @TaskAction
    fun run() {
        println("My input dir: " + inputFile.asFile.get())
    }
}