// SPDX-License-Identifier: MIT

/**
 * Smartefact Gradle conventions - OSGi bundle
 *
 * Converts the JAR into an OSGi bundle using Bnd.
 *
 * @author Laurent Pireyn
 */

plugins {
    id("smartefact.java")
    id("biz.aQute.bnd.builder")
}

dependencies {
    compileOnly("org.osgi:org.osgi.annotation.bundle:2.0.0")
    compileOnly("org.osgi:org.osgi.annotation.versioning:1.1.2")
}

tasks.jar {
    bundle {
        properties = provider {
            val description = project.description
                ?: throw GradleException("Project description not set")
            mapOf(
                // Properties (alphabetically)
                // TODO: Make copyright year configurable
                "Bundle-Copyright" to "Copyright 2026 Smartefact",
                "Bundle-Description" to description,
                "Bundle-Developers" to "lpireyn;name=Laurent Pireyn;email=laurent.pireyn@smartefact.be;organization=Smartefact;organization-url=https://smartefact.org/;roles=maintainer",
                "Bundle-License" to "Apache-2.0;link=https://www.apache.org/licenses/LICENSE-2.0.html",
                // TODO: `Bundle-SCM`
            )
        }
        bnd(mapOf(
            "-check" to "ALL",
            "-noextraheaders" to "true",
        ))
    }
}
