// SPDX-License-Identifier: MIT

/**
 * Semantic version.
 *
 * This class does not support pre-release identifiers and build identifiers
 * (i.e., it only supports the *version core*).
 *
 * See [Semantic Versioning](https://semver.org/) for more information.
 *
 * @author Laurent Pireyn
 */
data class SemanticVersion(
    val major: Int,
    val minor: Int = 0,
    val patch: Int = 0,
) {
    override fun toString(): String = "$major.$minor.$patch"

    operator fun compareTo(other: SemanticVersion): Int {
        var d = major.compareTo(other.major)
        if (d != 0) return d
        d = minor.compareTo(other.minor)
        if (d != 0) return d
        return patch.compareTo(other.patch)
    }

    companion object {
        fun parseVersion(string: String): SemanticVersion {
            val coreString = string
                // Strip pre-release identifiers
                .substringBefore('-')
                // Strip build identifiers
                .substringBefore('+')
            val parts = coreString.split('.')
            if (parts.size != 3) {
                throw IllegalArgumentException("Illegal semantic version: $string")
            }
            val (major, minor, patch) = parts.map { it.toInt() }
            return SemanticVersion(major, minor, patch)
        }
    }
}
