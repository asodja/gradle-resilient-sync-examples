import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction

abstract class MyTask extends DefaultTask {

    @InputDirectory
    abstract DirectoryProperty getInputFile()


    @TaskAction
    def run() {
        println("My input dir: " + inputFile.asFile.get())
    }
}