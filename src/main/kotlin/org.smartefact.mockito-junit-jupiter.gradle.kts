// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - JUnit Jupiter extension for Mockito
 *
 * Uses the JUnit Jupiter extension for Mockito in all JVM test suites.
 *
 * Reference: https://javadoc.io/doc/org.mockito/mockito-junit-jupiter/latest/org.mockito.junit.jupiter/org/mockito/junit/jupiter/MockitoExtension.html
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.junit-jupiter")
    id("org.smartefact.mockito")
}

testing {
    jvmTestSuites {
        dependencies {
            implementation("org.mockito:mockito-junit-jupiter")
        }
    }
}
