package gliby.gaal.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project


class GAALPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def extension = project.extensions.create('gaal', GAALObject)
        // Add a task that uses configuration from the extension object
        project.task('setupGaal') {
            doLast {
                println "working"
            }
        }
    }
}
