// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - NullAway
 *
 * Adds NullAway checks to Java compilation via Error Prone.
 * Uses [JSpecify](https://jspecify.dev/) annotations.
 *
 * Reference: https://github.com/uber/NullAway
 * Gradle plugin: https://github.com/tbroyer/gradle-nullaway-plugin
 *
 * @author Laurent Pireyn
 */

import net.ltgt.gradle.errorprone.errorprone
import net.ltgt.gradle.nullaway.nullaway

plugins {
    id("smartefact.errorprone")
    id("net.ltgt.nullaway")
}

val jspecifyVersion = "1.0.0"
val nullawayVersion = "0.13.1"

dependencies {
    errorprone("com.uber.nullaway:nullaway:$nullawayVersion")
    val configurationName = if (pluginManager.hasPlugin("java-library")) "api" else "implementation"
    add(configurationName, "org.jspecify:jspecify:$jspecifyVersion")
}

tasks.withType<JavaCompile> {
    options.errorprone.nullaway {
        error()
        jspecifyMode = true
        onlyNullMarked = true
        assertsEnabled = true
        checkOptionalEmptiness = true
        checkContracts = true
        handleTestAssertionLibraries = true
    }
}

tasks.withType<Javadoc> {
    standardOptions {
        links?.add("https://javadoc.io/doc/org.jspecify/jspecify/$jspecifyVersion")
    }
}
