package gliby.gaal.gradle

import org.ajoberstar.grgit.Grgit
import org.gradle.api.Plugin
import org.gradle.api.Project

class GAALPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def extension = project.extensions.create('gaal', GAALObject)
        // Add a task that uses configuration from the extension object
        // The "right" way with configuration


        def cleanTask = project.task("cleanGaal", type: GAALClean) {
            group = "gaal"
            description = "Cleans gaal directory."
        }

        def setupWorkspaceTask = project.task("setupGaalWorkspace", type: GAALSetupTask) {
            group = "gaal"
            description = "Setups GAAL Workspace for modding."
        }

        project.task("runClient", type: GAALRunTasks.RunClient, dependsOn: setupWorkspaceTask) {
            group = "gaal"
            description = "Runs implementation client."
        }

        project.task("runServer", type: GAALRunTasks.RunServer, dependsOn: setupWorkspaceTask) {
            group = "gaal"
            description = "Runs implementation server."
        }
    }
}
