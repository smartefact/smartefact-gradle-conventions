// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Architecture tests
 *
 * Creates the `archTest` JVM test suite.
 *
 * @author Laurent Pireyn
 */

plugins {
    id("smartefact.java")
}

testing {
    suites.register(ARCH_TEST, JvmTestSuite::class)
}
