// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Functional tests
 *
 * Creates the `functionalTest` JVM test suite.
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.java")
}

val functionalTest = testing.suites.register<JvmTestSuite>(FUNCTIONAL_TEST) {
    dependencies {
        implementation(project())
    }
    targets {
        all {
            testTask.configure {
                shouldRunAfter(tasks.test)
            }
        }
    }
}

tasks.check {
    dependsOn(functionalTest)
}
