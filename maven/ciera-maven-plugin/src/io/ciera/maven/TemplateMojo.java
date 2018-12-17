package io.ciera.maven;

import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import org.apache.maven.project.MavenProject;

import io.ciera.tool.TemplateTool;

import java.io.File;

/**
 * Goal which runs the Template builder.
 */
@Mojo(name="template", defaultPhase=LifecyclePhase.GENERATE_SOURCES)
public class TemplateMojo extends AbstractCieraMojo {

    @Parameter
    private String input;

    @Parameter
    private String output;

    @Parameter(readonly=true, defaultValue="${project}")
    private MavenProject project;

    public void execute() throws MojoExecutionException {
        String projectDir = getProject().getBasedir().getPath();
        String inFile = null == input ? "" : new File(projectDir).toURI().relativize(new File(input).toURI()).getPath();
        String outFile = null == output ? "" : new File(projectDir).toURI().relativize(new File(output).toURI()).getPath();
        TemplateTool.main(new String[]{"-i", inFile, "-o", outFile, "--cwd", projectDir});
        waitForThreads();
        copyCustomCode();
        addSrcGen();
        refreshFiles();
    }

    public MavenProject getProject() {
        return project;
    }

}
