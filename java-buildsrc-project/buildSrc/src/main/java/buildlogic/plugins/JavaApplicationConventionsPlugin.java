package buildlogic.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.compile.JavaCompile;

public class JavaApplicationConventionsPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getPlugins().apply("java-library");
        project.getPlugins().apply("application");

        project.getRepositories().mavenCentral();

        project.getTasks().withType(JavaCompile.class).configureEach(task -> {
            task.setDestinationDir(project.getLayout().getBuildDirectory().dir("classes").get().getAsFile());
        });
    }
}
