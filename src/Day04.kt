fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        for (pairs in input) {
            val firstLeft = pairs.split(",")[0].split("-")[0].toInt()
            val firstRight = pairs.split(",")[0].split("-")[1].toInt()
            val secondLeft = pairs.split(",")[1].split("-")[0].toInt()
            val secondRight = pairs.split(",")[1].split("-")[1].toInt()
            if (firstLeft <= secondLeft && secondLeft <= secondRight && secondRight <= firstRight) {
                result++
            } else if (secondLeft <= firstLeft && firstLeft <= firstRight && firstRight <= secondRight) {
                result++
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (pairs in input) {
            val firstLeft = pairs.split(",")[0].split("-")[0].toInt()
            val firstRight = pairs.split(",")[0].split("-")[1].toInt()
            val secondLeft = pairs.split(",")[1].split("-")[0].toInt()
            val secondRight = pairs.split(",")[1].split("-")[1].toInt()
            if (firstLeft <= secondLeft && secondLeft <= secondRight && secondRight <= firstRight) {
                result++
            } else if (secondLeft <= firstLeft && firstLeft <= firstRight && firstRight <= secondRight) {
                result++
            } else if (secondLeft <= firstLeft && firstLeft <= secondRight && secondRight <= firstRight) {
                result++
            } else if (firstLeft <= secondLeft && secondLeft <= firstRight && firstRight <= secondRight) {
                result++
            }
        }
        return result
    }

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
