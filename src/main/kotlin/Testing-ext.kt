// SPDX-License-Identifier: MIT

/**
 * Extension functions for testing-related types.
 *
 * @author Laurent Pireyn
 */

import org.gradle.api.DomainObjectCollection
import org.gradle.api.NamedDomainObjectCollection
import org.gradle.api.plugins.JvmTestSuitePlugin
import org.gradle.api.plugins.jvm.JvmTestSuite
import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.base.TestSuite
import org.gradle.testing.base.TestingExtension

const val ARCH_TEST = "archTest"
const val FUNCTIONAL_TEST = "functionalTest"
const val INTEGRATION_TEST = "integrationTest"
const val UNIT_TEST = JvmTestSuitePlugin.DEFAULT_TEST_SUITE_NAME

val TestingExtension.jvmTestSuites: NamedDomainObjectCollection<JvmTestSuite>
    get() = suites.withType()

fun TestingExtension.jvmTestSuites(configure: JvmTestSuite.() -> Unit): DomainObjectCollection<JvmTestSuite> =
    suites.withType(configure)

fun NamedDomainObjectCollection<out TestSuite>.jvmTestSuite(name: String): JvmTestSuite =
    getByName(name, JvmTestSuite::class)

fun NamedDomainObjectCollection<out TestSuite>.jvmTestSuite(name: String, configure: JvmTestSuite.() -> Unit): JvmTestSuite =
    getByName(name, JvmTestSuite::class, configure)

val NamedDomainObjectCollection<out TestSuite>.archTest: JvmTestSuite
    get() = jvmTestSuite(ARCH_TEST)

fun NamedDomainObjectCollection<out TestSuite>.archTest(configure: JvmTestSuite.() -> Unit): JvmTestSuite =
    jvmTestSuite(ARCH_TEST, configure)

val NamedDomainObjectCollection<out TestSuite>.functionalTest: JvmTestSuite
    get() = jvmTestSuite(FUNCTIONAL_TEST)

fun NamedDomainObjectCollection<out TestSuite>.functionalTest(configure: JvmTestSuite.() -> Unit): JvmTestSuite =
    jvmTestSuite(FUNCTIONAL_TEST, configure)

val NamedDomainObjectCollection<out TestSuite>.integrationTest: JvmTestSuite
    get() = jvmTestSuite(INTEGRATION_TEST)

fun NamedDomainObjectCollection<out TestSuite>.integrationTest(configure: JvmTestSuite.() -> Unit): JvmTestSuite =
    jvmTestSuite(INTEGRATION_TEST, configure)

val NamedDomainObjectCollection<out TestSuite>.unitTest: JvmTestSuite
    get() = jvmTestSuite(UNIT_TEST)

fun NamedDomainObjectCollection<out TestSuite>.unitTest(configure: JvmTestSuite.() -> Unit): JvmTestSuite =
    jvmTestSuite(UNIT_TEST, configure)
