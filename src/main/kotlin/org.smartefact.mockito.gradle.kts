// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Mockito
 *
 * Uses Mockito in all JVM test suites.
 *
 * Reference: https://site.mockito.org/
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.junit-platform")
}

val mockitoVersion = "5.22.0"

testing {
    jvmTestSuites {
        dependencies {
            implementation(platform("org.mockito:mockito-bom:$mockitoVersion"))
            implementation("org.mockito:mockito-core")
        }
    }
}
