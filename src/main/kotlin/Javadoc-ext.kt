// SPDX-License-Identifier: MIT

/**
 * Extension functions for [Javadoc].
 *
 * @author Laurent Pireyn
 */

import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.external.javadoc.StandardJavadocDocletOptions

val Javadoc.standardOptions: StandardJavadocDocletOptions
    get() = options as StandardJavadocDocletOptions

fun Javadoc.standardOptions(action: StandardJavadocDocletOptions.() -> Unit) = standardOptions.action()
