package gliby.gaal.gradle

import groovy.json.JsonSlurper
import org.ajoberstar.grgit.Grgit
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

import java.nio.file.Paths

class GAALSetupTask extends DefaultTask {

    GAALSetupTask() {
        onlyIf {
           !project.gaal.getCloneDirectory(project).exists()
        }
    }


    @TaskAction
    def action() {
        def cloneDir = project.gaal.getCloneDirectory(project)
        logger.lifecycle("Cloning " + project.gaal.getGaalImplGit() + " branch [" + project.gaal.gaalImplBranch + "]")
        Grgit.clone {
            dir = cloneDir
            uri = project.gaal.getGaalImplGit()
            refToCheckout = project.gaal.getGaalImplBranch()
        }

    }
}
