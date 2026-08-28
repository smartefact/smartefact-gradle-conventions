// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - JUnit Jupiter
 *
 * Uses JUnit Jupiter in all JVM test suites.
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.junit-platform")
}

testing {
    jvmTestSuites {
        dependencies {
            implementation("org.junit.jupiter:junit-jupiter")
            implementation("org.junit.jupiter:junit-jupiter-params")
        }
    }
}
