# Topic 6 notes

[pom.xml file](https://github.com/colewarner24/solvd_ta_course/blob/main/pom.xml)

[jar file](https://github.com/colewarner24/solvd_ta_course/blob/main/target/solvd_ta_course-1.0-SNAPSHOT-jar-with-dependencies.jar)

plugins
- check style, generates a report of code stylings
- maven assembly plugin, combines project output into a single distributable archive that also contains dependencies, modules, site documentation, and other files. 

# 1. What is M2_HOME? How to setup Maven?
M2_HOME is the environment variable that points to the location where Maven is installed.

Download Maven and setup the M2_HOME environment variable for command line usage.
# 2. What is settings.xml file for?
The settings.xml file is a configuration file that Maven uses to customize the build process and files and directories.
# 3. How to work with maven profile?
To work with a Maven profile, one must create a pom.xml file that customizes the build process.

Build profiles can also be defined by user in the settings.xml file.
# 4. Describe maven project structure.
A Maven project structure will have a pom.xml file located at the root of the project directory.

The src directory will contain the main and test directories.

The main directory will contain the java and resources directories.

The target directory will contain the compiled classes and the jar file.
# 5. Describe maven lifecycle. Each step.

validate - validate the project is correct and all necessary information is available

compile - compile the source code of the project

test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed

package - take the compiled code and package it in its distributable format, such as a JAR.

verify - run any checks on results of integration tests to ensure quality criteria are met

install - install the package into the local repository, for use as a dependency in other projects locally

deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

# 6. What do you know about pom.xml file structure?

The pom.xml file is layed out in the following structure:
Project - The POM file's root element contains information about the current project.

Dependencies - The dependencies element contains a list of dependencies the project needs to build, test, and run.

Build - The build element contains the configuration data for the build process.

Plugins - The plugins element contains a list of plugins that are used to build the project.
# 7. What do you know about local/remote repositories?
The local repository is a directory on the developer's machine where Maven stores all the project dependencies.

The remote repository is a directory on a remote server such as Maven Central to fetch dependencies to local.
# 8. What is target directory?
The target directory is where Maven stores the compiled classes, the jar file, and any other build output.
# 9. How to work with maven plugin?
To work with a Maven plugin, one must add the plugin to the pom.xml file and configure it with the necessary parameters.
# 10. What Maven flags do you know?
Some of the Maven flags are:
- -D - Pass custom properties to Maven
- -P - Activate a profile
- -U - Force update of snapshots and releases
- -T - Set the number of threads to use for the build
- -q - Quiet output
- -B - Batch mode
- -X - Print debug information
- -e - Print errors
