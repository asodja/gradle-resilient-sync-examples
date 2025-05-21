plugins {
    id("java-gradle-plugin")
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        create("javaApplicationConventionsPlugin") {
            id = "buildlogic.java-application-conventions"
            implementationClass = "buildlogic.plugins.JavaApplicationConventionsPlugin"
        }
    }
}
