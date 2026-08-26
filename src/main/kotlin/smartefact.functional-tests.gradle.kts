// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Functional tests
 *
 * Creates the `functionalTest` JVM test suite.
 *
 * @author Laurent Pireyn
 */

plugins {
    id("smartefact.java")
}

testing {
    suites {
        val test = named(UNIT_TEST)
        val functionalTest = register(FUNCTIONAL_TEST, JvmTestSuite::class) {
            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
        tasks.check {
            dependsOn(functionalTest)
        }
    }
}
