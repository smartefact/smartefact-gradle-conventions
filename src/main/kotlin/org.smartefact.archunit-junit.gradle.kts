// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - ArchUnit on JUnit
 *
 * Uses ArchUnit in the architecture tests.
 *
 * Reference: https://www.archunit.org/userguide/html/000_Index.html#_junit_5
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.junit-platform")
    id("org.smartefact.arch-tests")
}

val archunitVersion = "1.4.2"

testing {
    suites {
        archTest {
            dependencies {
                implementation("com.tngtech.archunit:archunit-junit5:$archunitVersion")
            }
        }
    }
}
