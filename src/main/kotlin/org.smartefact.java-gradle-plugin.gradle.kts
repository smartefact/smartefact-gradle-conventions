// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Java Gradle plugin
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.java")
    id("java-gradle-plugin")
    id("org.smartefact.functional-tests")
}

gradlePlugin {
    // Use Gradle TestKit in functional tests only
    testSourceSets(testing.suites.functionalTest.sources)
}
