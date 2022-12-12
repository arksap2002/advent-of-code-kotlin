import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        var current = 0
        for (number in input) {
            if (number.isEmpty()) {
                result = max(result, current)
                current = 0
            } else {
                current += number.toInt()
            }
        }
        return max(result, current)
    }

    fun part2(input: List<String>): Int {
        val arr = mutableListOf<Int>()
        var current = 0
        for (number in input) {
            if (number.isEmpty()) {
                arr.add(current)
                current = 0
            } else {
                current += number.toInt()
            }
        }
        arr.add(current)
        arr.sort()
        arr.reverse()
        return arr[0] + arr[1] + arr[2]
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
