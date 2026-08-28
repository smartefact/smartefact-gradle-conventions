// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - JaCoCo
 *
 * Generates JaCoCo reports for the unit tests.
 *
 * Reference: https://www.jacoco.org/jacoco/
 * Gradle plugin: https://docs.gradle.org/current/userguide/jacoco_plugin.html
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.java")
    id("jacoco")
}

val jacocoVersion = "0.8.14"

jacoco {
    toolVersion = jacocoVersion
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required = true
        html.required = true
    }
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}
