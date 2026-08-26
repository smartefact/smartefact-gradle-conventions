// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Java library
 *
 * @author Laurent Pireyn
 */

plugins {
    id("smartefact.java")
    id("java-library")
}

java {
    withSourcesJar()
    withJavadocJar()
}
