// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Integration tests
 *
 * Creates the `integrationTest` JVM test suite.
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.java")
}

testing {
    suites {
        val test = named(UNIT_TEST)
        val integrationTest = register(INTEGRATION_TEST, JvmTestSuite::class) {
            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
        tasks.check {
            dependsOn(integrationTest)
        }
    }
}
