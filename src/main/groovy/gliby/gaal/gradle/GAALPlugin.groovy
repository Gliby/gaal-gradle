package gliby.gaal.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class GAALPlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {
        def extension = project.extensions.create('gaal', GAALObject)
    }
}
