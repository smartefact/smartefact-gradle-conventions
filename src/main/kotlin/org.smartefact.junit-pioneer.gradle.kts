// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - JUnit Pioneer
 *
 * Uses JUnit Pioneer in all JVM test suites.
 *
 * Reference: https://junit-pioneer.org/
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.junit-platform")
}

val junitpioneerVersion = "2.3.0"

testing {
    jvmTestSuites {
        dependencies {
            implementation("org.junit-pioneer:junit-pioneer:$junitpioneerVersion")
        }
    }
}
