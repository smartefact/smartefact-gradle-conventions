// SPDX-License-Identifier: MIT

plugins {
    `kotlin-dsl`
    id("maven-publish")
}

group = "org.smartefact"
version = "0.1.0"
description = "Gradle conventions for Smartefact projects."

dependencies {
    api("biz.aQute.bnd.builder:biz.aQute.bnd.builder.gradle.plugin:7.2.1")
    api("com.gradle.plugin-publish:com.gradle.plugin-publish.gradle.plugin:2.1.1")
    api("me.champeau.jmh:me.champeau.jmh.gradle.plugin:0.7.3")
    api("net.ltgt.gradle:gradle-errorprone-plugin:5.1.0")
    api("net.ltgt.gradle:gradle-nullaway-plugin:3.0.0")
    api("org.jetbrains.dokka:dokka-gradle-plugin:2.2.0")
    api("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.10")
}

gradlePlugin {
    website = "https://smartefact.org/"
    vcsUrl = "https://github.com/smartefact/smartefact-gradle-conventions"
    plugins {
        // Plugins (alphabetically)
        getByName("org.smartefact.arch-tests") {
            displayName = "Smartefact Gradle conventions - Architecture tests"
        }
        getByName("org.smartefact.archunit-junit") {
            displayName = "Smartefact Gradle conventions - ArchUnit on JUnit"
        }
        getByName("org.smartefact.base") {
            displayName = "Smartefact Gradle conventions - Base"
        }
        getByName("org.smartefact.checkstyle") {
            displayName = "Smartefact Gradle conventions - Checkstyle"
        }
        getByName("org.smartefact.errorprone") {
            displayName = "Smartefact Gradle conventions - Error Prone"
        }
        getByName("org.smartefact.functional-tests") {
            displayName = "Smartefact Gradle conventions - Functional tests"
        }
        getByName("org.smartefact.gradle-plugin-publish") {
            displayName = "Smartefact Gradle conventions - Gradle plugin publish"
        }
        getByName("org.smartefact.integration-tests") {
            displayName = "Smartefact Gradle conventions - Integration tests"
        }
        getByName("org.smartefact.jacoco") {
            displayName = "Smartefact Gradle conventions - JaCoCo"
        }
        getByName("org.smartefact.java") {
            displayName = "Smartefact Gradle conventions - Java"
        }
        getByName("org.smartefact.java21") {
            displayName = "Smartefact Gradle conventions - Java 21"
        }
        getByName("org.smartefact.java-gradle-plugin") {
            displayName = "Smartefact Gradle conventions - Java Gradle plugin"
        }
        getByName("org.smartefact.java-library") {
            displayName = "Smartefact Gradle conventions - Java library"
        }
        getByName("org.smartefact.jmh") {
            displayName = "Smartefact Gradle conventions - JMH"
        }
        getByName("org.smartefact.junit-jupiter") {
            displayName = "Smartefact Gradle conventions - JUnit Jupiter"
        }
        getByName("org.smartefact.junit-pioneer") {
            displayName = "Smartefact Gradle conventions - JUnit Pioneer"
        }
        getByName("org.smartefact.junit-platform") {
            displayName = "Smartefact Gradle conventions - JUnit Platform"
        }
        getByName("org.smartefact.kotlin-gradle-plugin") {
            displayName = "Smartefact Gradle conventions - Kotlin Gradle plugin"
        }
        getByName("org.smartefact.kotlin-jvm") {
            displayName = "Smartefact Gradle conventions - Kotlin - JVM"
        }
        getByName("org.smartefact.maven-publish") {
            displayName = "Smartefact Gradle conventions - Maven publish"
        }
        getByName("org.smartefact.mockito") {
            displayName = "Smartefact Gradle conventions - Mockito"
        }
        getByName("org.smartefact.mockito-junit-jupiter") {
            displayName = "Smartefact Gradle conventions - JUnit Jupiter extension for Mockito"
        }
        getByName("org.smartefact.nullaway") {
            displayName = "Smartefact Gradle conventions - NullAway"
        }
        getByName("org.smartefact.osgi-bundle") {
            displayName = "Smartefact Gradle conventions - OSGi bundle"
        }
        // Common plugin properties
        configureEach {
            description = displayName
            tags = setOf("conventions")
        }
    }
}

val functionalTest = testing.suites.register<JvmTestSuite>("functionalTest") {
    dependencies {
        implementation(project())
        implementation(gradleTestKit())
    }
    targets {
        all {
            testTask.configure {
                shouldRunAfter(tasks.test)
            }
        }
    }
}

gradlePlugin {
    testSourceSets(functionalTest.get().sources)
}

testing.suites.withType<JvmTestSuite> {
    useJUnitJupiter("6.0.3")
}

tasks.check {
    dependsOn(functionalTest)
}

publishing {
    publications.withType<MavenPublication> {
        pom {
            url = "https://github.com/smartefact/smartefact-gradle-conventions"
            inceptionYear = "2026"
            licenses {
                license {
                    name = "MIT License"
                    url = "https://mit-license.org/"
                }
            }
            developers {
                developer {
                    id = "lpireyn"
                    name = "Laurent Pireyn"
                    email = "laurent.pireyn@smartefact.be"
                    timezone = "Europe/Brussels"
                    organization = "Smartefact"
                    organizationUrl = "https://smartefact.be/"
                }
            }
            scm {
                connection = "scm:git:https://github.com/smartefact/smartefact-gradle-conventions.git"
                developerConnection = "scm:git:ssh://git@github.com:smartefact/smartefact-gradle-conventions.git"
                url = "https://github.com/smartefact/smartefact-gradle-conventions"
            }
            issueManagement {
                system = "github"
                url = "https://github.com/smartefact/smartefact-gradle-conventions/issues"
            }
            ciManagement {
                system = "github"
                url = "https://github.com/smartefact/smartefact-gradle-conventions/actions"
            }
        }
    }
}
