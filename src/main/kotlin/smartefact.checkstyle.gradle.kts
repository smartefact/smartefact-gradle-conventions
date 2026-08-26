// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Checkstyle
 *
 * Reference: https://checkstyle.org/
 * Gradle plugin: https://docs.gradle.org/current/userguide/checkstyle_plugin.html
 *
 * @author Laurent Pireyn
 */

plugins {
    id("smartefact.java")
    id("checkstyle")
}

val checkstyleVersion = "14.0.0"

checkstyle {
    toolVersion = checkstyleVersion
}

tasks.withType<Checkstyle> {
    javaLauncher = javaToolchains.launcherFor {
        // Checkstyle 13+ requires Java 21
        languageVersion = JavaLanguageVersion.of(21)
    }
    reports {
        xml.required = true
        html.required = true
        sarif.required = true
    }
}

tasks.register<DefaultTask>("checkstyle") {
    description = "Runs the CheckStyle tasks of project '${project.path}'."
    group = JavaBasePlugin.VERIFICATION_GROUP
    dependsOn(tasks.withType<Checkstyle>())
    // NOTE:
    // This task is not added as a dependency in the `check` task,
    // as it already depends on the individual `checkstyle*` tasks
}
