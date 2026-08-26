// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Base
 *
 * @author Laurent Pireyn
 */

plugins {
    id("base")
}

group = "org.smartefact"

val gradleVersion = gradle.gradleSemanticVersion

// Check Gradle version
// TODO: Review min required Gradle version
val minRequiredGradleVersion = SemanticVersion(8)
if (gradleVersion < minRequiredGradleVersion) {
    throw GradleException("Unsupported Gradle version: $gradleVersion; minimum required version: $minRequiredGradleVersion")
}

// Make archive tasks produce reproducible archives
// This is already done by Gradle 9+
// Reference: https://docs.gradle.org/9.0.0/userguide/working_with_files.html#sec:reproducible_archives
// Release note: https://docs.gradle.org/9.0.0/release-notes.html#archive-tasks-produce-reproducible-archives-by-default
if (gradleVersion.major < 9) {
    tasks.withType<AbstractArchiveTask> {
        isReproducibleFileOrder = true
        isPreserveFileTimestamps = false
        dirPermissions { unix("755") }
        filePermissions { unix("644") }
    }
}
