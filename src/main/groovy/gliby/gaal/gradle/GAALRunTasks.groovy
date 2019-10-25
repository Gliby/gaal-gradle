package gliby.gaal.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

import java.util.concurrent.TimeUnit

class GAALRunTasks {

    static class RunClient extends DefaultTask {

        @TaskAction
        def action() {
            GAALObject gaal = project.gaal

            def cloneDir = gaal.getCloneDirectory(project)
            def env = System.getenv().collect { k, v -> "$k=$v" }


            def config = gaal.readConfig(project)
            println config
            logger.lifecycle("Running client.")
            def command = ["gradlew.bat", "runClient", "--refresh-dependencies"]


            def prc = command.execute(env, cloneDir)
            prc.consumeProcessOutput(System.out, System.err)
            prc.waitFor()
//            logger.lifecycle prc.text
            logger.lifecycle "Process exit code: ${prc.exitValue()}"

        }
    }

    static class RunServer extends DefaultTask {

        @TaskAction
        def action() {
            GAALObject gaal = project.gaal

            def cloneDir = gaal.getCloneDirectory(project)
            logger.lifecycle("Running server.")

        }
    }
}
