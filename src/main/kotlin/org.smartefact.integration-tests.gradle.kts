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

val integrationTest = testing.suites.register<JvmTestSuite>(INTEGRATION_TEST) {
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
    dependsOn(integrationTest)
}
