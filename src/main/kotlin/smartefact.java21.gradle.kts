// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Java 21
 *
 * @author Laurent Pireyn
 */

plugins {
    id("smartefact.java")
}

val javaVersion = 21

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(javaVersion)
    }
}

tasks.withType<Javadoc> {
    standardOptions {
        links?.add("https://docs.oracle.com/en/java/javase/$javaVersion/docs/api")
    }
}
