// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Kotlin - JVM
 *
 * @author Laurent Pireyn
 */

import org.jetbrains.dokka.gradle.engine.parameters.VisibilityModifier

plugins {
    id("org.smartefact.java")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.dokka")
}

dokka {
    dokkaSourceSets.configureEach {
        documentedVisibilities(
            VisibilityModifier.Public,
            VisibilityModifier.Protected,
        )
    }
}
