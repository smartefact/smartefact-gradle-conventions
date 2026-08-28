// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Architecture tests
 *
 * Creates the `archTest` JVM test suite.
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.java")
}

val archTest = testing.suites.register<JvmTestSuite>(ARCH_TEST) {
    dependencies {
        implementation(project())
    }
}
