package gliby.gaal.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GAALClean extends DefaultTask {

    @TaskAction
    def action() {
        GAALObject gaal = project.gaal
        def clones = project.file(gaal.getCloneDir())
        if (clones.exists()) {
            clones.deleteDir()
            logger.lifecycle "Cleaned $clones"
        }

    }
}
