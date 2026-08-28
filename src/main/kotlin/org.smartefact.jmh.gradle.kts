// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - JMH
 *
 * Reference: https://github.com/openjdk/jmh
 * Gradle plugin: https://plugins.gradle.org/plugin/me.champeau.jmh
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.java")
    id("me.champeau.jmh")
}

val theJmhVersion = "1.37"

jmh {
    jmhVersion = theJmhVersion
    resultFormat = "CSV"
    // TODO: Configure Async Profiler
}
