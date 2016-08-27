package codes.brick.gradle.packr;

import com.badlogicgames.packr.Packr;
import com.badlogicgames.packr.PackrConfig;

import org.gradle.api.DefaultTask;
import org.gradle.api.InvalidUserDataException;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.TaskExecutionException;

import java.io.IOException;

public class PackrTask extends DefaultTask {

  /**
   * Package the app with packr using the given configuration.
   */
  @TaskAction
  public void pack() {
    PackrPluginExtension extension =
        getProject().getExtensions().findByType(PackrPluginExtension.class);

    if (extension == null) {
      throw new InvalidUserDataException("Packr needs to be configured!");
    }

    PackrConfig config = extension.config;

    try {
      new Packr().pack(config);
    } catch (IOException ex) {
      throw new TaskExecutionException(this, ex);
    }
  }
}
