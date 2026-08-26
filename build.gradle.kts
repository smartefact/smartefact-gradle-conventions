// SPDX-License-Identifier: MIT

plugins {
    `kotlin-dsl`
}

group = "org.smartefact"
version = "0.1.0"
description = "Gradle conventions for Smartefact projects."

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
