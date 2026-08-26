// SPDX-License-Identifier: MIT

/**
 * Extension functions for [Gradle].
 *
 * @author Laurent Pireyn
 */

import org.gradle.api.invocation.Gradle

/**
 * Gradle version as a [semantic version](SemanticVersion).
 */
val Gradle.gradleSemanticVersion: SemanticVersion
    get() = SemanticVersion.parseVersion(gradleVersion)
