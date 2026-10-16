// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Kotlin - JVM
 *
 * @author Laurent Pireyn
 */

import org.jetbrains.dokka.gradle.engine.parameters.VisibilityModifier

plugins {
    id("org.smartefact.java21")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.dokka")
}

// TODO: Use the same variable as in `org.smartefact.java21`
val javaVersion = 21

kotlin {
    jvmToolchain(javaVersion)
}

dokka {
    dokkaSourceSets.configureEach {
        documentedVisibilities(
            VisibilityModifier.Public,
            VisibilityModifier.Protected,
        )
    }
}
