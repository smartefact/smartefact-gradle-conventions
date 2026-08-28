// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Error Prone
 *
 * Reference: https://errorprone.info/
 * Gradle plugin: https://github.com/tbroyer/gradle-errorprone-plugin
 *
 * @author Laurent Pireyn
 */

plugins {
    id("org.smartefact.java")
    id("net.ltgt.errorprone")
}

val errorproneVersion = "2.48.0"

dependencies {
    errorprone("com.google.errorprone:error_prone_core:$errorproneVersion")
    // TODO: Should this dependency be in the `api` configuration for Java libraries?
    implementation("com.google.errorprone:error_prone_annotations:$errorproneVersion")
}

tasks.withType<Javadoc> {
    standardOptions {
        links?.add("https://javadoc.io/doc/com.google.errorprone/error_prone_annotations/$errorproneVersion")
    }
}
