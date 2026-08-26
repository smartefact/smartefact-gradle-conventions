// SPDX-License-Identifier: MIT

package org.smartefact.gradle.conventions

import SemanticVersion
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class SemanticVersionTests {
    @ParameterizedTest
    @MethodSource
    fun testParseVersion(string: String, expected: SemanticVersion) {
        assertEquals(expected, SemanticVersion.parseVersion(string))
    }

    companion object {
        @JvmStatic
        fun testParseVersion() = listOf(
            arguments(
                "1.2.3",
                SemanticVersion(1, 2, 3)
            ),
            arguments(
                "1.2.3-x",
                SemanticVersion(1, 2, 3)
            ),
            arguments(
                "1.2.3+x",
                SemanticVersion(1, 2, 3)
            ),
        )
    }
}
