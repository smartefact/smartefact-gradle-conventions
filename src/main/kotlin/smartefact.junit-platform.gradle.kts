// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - JUnit Platform
 *
 * Uses JUnit Platform in all JVM test suites.
 *
 * @author Laurent Pireyn
 */

plugins {
    id("smartefact.java")
}

val junitVersion = "6.0.3"

testing {
    jvmTestSuites {
        dependencies {
            implementation(platform("org.junit:junit-bom:$junitVersion"))
            runtimeOnly("org.junit.platform:junit-platform-reporting")
        }
        targets.configureEach {
            testTask {
                useJUnitPlatform()
                systemProperty(
                    "junit.platform.reporting.open.xml.enabled",
                    true
                )
                systemProperty(
                    "junit.platform.reporting.output.dir",
                    java.testResultsDir.dir(name).get().asFile.path
                )
            }
        }
    }
}
