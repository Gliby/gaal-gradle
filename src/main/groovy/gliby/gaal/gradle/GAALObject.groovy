package gliby.gaal.gradle

import groovy.json.JsonSlurper
import org.gradle.api.Project

import java.nio.file.Paths

class GAALObject {
    String gaalImplGit = "https://github.com/Gliby/gaal-imp.git"
    String gaalImplBranch = "1.7.10"

    String cloneDir = "gaal/clones"

    def getClonePath() {
        Paths.get(getCloneDir(), getGaalImplBranch())
    }

    File getCloneDirectory(Project project) {
        project.file(getClonePath())
    }

    def gaalConfig

    def readConfig(Project project) {
        if (gaalConfig == null) {
            File gaalConfigPath = project.file(Paths.get(getClonePath().toString(), "gaal.json"))
            gaalConfig = new JsonSlurper().parseText(gaalConfigPath.text)
        }
        gaalConfig
    }

}
