import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    fun part1(input: List<String>): String {
        var result = ""
        val letters = mutableListOf<ArrayDeque<Char>>(
            ArrayDeque(listOf('V', 'C', 'D', 'R', 'Z', 'G', 'B', 'W')),
            ArrayDeque(listOf('G', 'W', 'F', 'C', 'B', 'S', 'T', 'V')),
            ArrayDeque(listOf('C', 'B', 'S', 'N', 'W')),
            ArrayDeque(listOf('Q', 'G', 'M', 'N', 'J', 'V', 'C', 'P')),
            ArrayDeque(listOf('T', 'S', 'L', 'F', 'D', 'H', 'B')),
            ArrayDeque(listOf('J', 'V', 'T', 'W', 'M', 'N')),
            ArrayDeque(listOf('P', 'F', 'L', 'C', 'S', 'T', 'G')),
            ArrayDeque(listOf('B', 'D', 'Z')),
            ArrayDeque(listOf('M', 'N', 'Z', 'W'))
        )
        for (line in input) {
            if (!line.contains("move")) continue
            val n = line.split(' ')[1].toInt()
            val x = line.split(' ')[3].toInt() - 1
            val y = line.split(' ')[5].toInt() - 1
            for (i in 0 until n) {
                letters[y].addLast(letters[x].removeLast())
            }
        }
        for (q in letters) {
            result += q.removeLast()
        }
        return result
    }

    fun part2(input: List<String>): String {
        var result = ""
        val letters = mutableListOf<ArrayDeque<Char>>(
            ArrayDeque(listOf('V', 'C', 'D', 'R', 'Z', 'G', 'B', 'W')),
            ArrayDeque(listOf('G', 'W', 'F', 'C', 'B', 'S', 'T', 'V')),
            ArrayDeque(listOf('C', 'B', 'S', 'N', 'W')),
            ArrayDeque(listOf('Q', 'G', 'M', 'N', 'J', 'V', 'C', 'P')),
            ArrayDeque(listOf('T', 'S', 'L', 'F', 'D', 'H', 'B')),
            ArrayDeque(listOf('J', 'V', 'T', 'W', 'M', 'N')),
            ArrayDeque(listOf('P', 'F', 'L', 'C', 'S', 'T', 'G')),
            ArrayDeque(listOf('B', 'D', 'Z')),
            ArrayDeque(listOf('M', 'N', 'Z', 'W'))
        )
        for (line in input) {
            if (!line.contains("move")) continue
            val n = line.split(' ')[1].toInt()
            val x = line.split(' ')[3].toInt() - 1
            val y = line.split(' ')[5].toInt() - 1
            val arr = mutableListOf<Char>()
            for (i in 0 until n) {
                arr.add(letters[x].removeLast())
            }
            arr.reverse()
            for (i in 0 until n) {
                letters[y].addLast(arr[i])
            }
        }
        for (q in letters) {
            result += q.removeLast()
        }
        return result
    }

    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}
