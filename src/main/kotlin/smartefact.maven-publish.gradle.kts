// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - Maven publish
 *
 * Configures the Maven publications.
 *
 * @author Laurent Pireyn
 */

plugins {
    id("smartefact.base")
    id("maven-publish")
}

publishing {
    publications.withType<MavenPublication> {
        pom {
            name = project.name
            description = project.description
            // TODO: `url`
            // TODO: `inceptionYear`
            organization {
                name = "Smartefact"
                url = "https://smartefact.org/"
            }
            licenses {
                license {
                    name = "Apache-2.0"
                    url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                }
            }
            developers {
                developer {
                    id = "lpireyn"
                    name = "Laurent Pireyn"
                    email = "laurent.pireyn@smartefact.be"
                }
            }
            // TODO: `scm`
            // TODO: `issueManagement`
            // TODO: `ciManagement`
        }
    }
}

if (pluginManager.hasPlugin("java")) {
    publishing {
        publications {
            register<MavenPublication>("main") {
                from(components["java"])
            }
        }
    }
}
