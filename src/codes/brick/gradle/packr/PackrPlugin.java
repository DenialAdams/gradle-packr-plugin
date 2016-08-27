package codes.brick.gradle.packr;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class PackrPlugin implements Plugin<Project> {

  @Override
  public void apply(Project project) {
    project.getExtensions().create("packr", PackrPluginExtension.class);
    project.getTasks().create("packr", PackrTask.class);
  }

}