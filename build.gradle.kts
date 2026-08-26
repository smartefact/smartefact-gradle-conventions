// SPDX-License-Identifier: MIT

plugins {
    `kotlin-dsl`
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
