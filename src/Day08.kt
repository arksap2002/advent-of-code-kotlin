import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        val arr = mutableListOf<MutableList<Boolean>>()
        for (i in input.indices) {
            val l = mutableListOf<Boolean>()
            for (j in 0 until input[0].length) {
                l.add(false)
            }
            arr.add(l)
        }
        var result = 0
        result += 2 * input.size
        result += 2 * input[0].length
        result -= 4
        for (i in 1 until input.size - 1) {
            var max = input[i][0]
            for (j in 1 until input[0].length - 1) {
                if (input[i][j] > max) {
                    if (!arr[i][j]) {
                        result++
                        arr[i][j] = true
                    }
                    max = input[i][j]
                }
            }
            max = input[i][input[0].length - 1]
            for (k in 1 until input[0].length - 1) {
                val j = input[0].length - k - 1
                if (input[i][j] > max) {
                    if (!arr[i][j]) {
                        result++
                        arr[i][j] = true
                    }
                    max = input[i][j]
                }
            }
        }
        for (i in 1 until input[0].length - 1) {
            var max = input[0][i]
            for (j in 1 until input.size - 1) {
                if (input[j][i] > max) {
                    if (!arr[j][i]) {
                        result++
                        arr[j][i] = true
                    }
                    max = input[j][i]
                }
            }
            max = input[input.size - 1][i]
            for (k in 1 until input.size - 1) {
                val j = input.size - k - 1
                if (input[j][i] > max) {
                    if (!arr[j][i]) {
                        result++
                        arr[j][i] = true
                    }
                    max = input[j][i]
                }
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        val n = input[0].length
        val m = input.size
        var result = 0
        for (i in 1 until m - 1) {
            for (j in 1 until n - 1) {
                var current = 1
                for (k in i + 1 until m) {
                    if (input[k][j] >= input[i][j]) {
                        current *= k - i
                        break
                    }
                    if (k == m - 1) {
                        current *= k - i
                    }
                }
                for (k in j + 1 until n) {
                    if (input[i][k] >= input[i][j]) {
                        current *= k - j
                        break
                    }
                    if (k == n - 1) {
                        current *= k - j
                    }
                }
                for (w in 0 until i) {
                    val k = i - w - 1
                    if (input[k][j] >= input[i][j]) {
                        current *= k - i
                        break
                    }
                    if (w == i - 1) {
                        current *= k - i
                    }
                }
                for (w in 0 until j) {
                    val k = j - w - 1
                    if (input[i][k] >= input[i][j]) {
                        current *= k - j
                        break
                    }
                    if (w == j - 1) {
                        current *= k - j
                    }
                }
                result = max(result, current)
            }
        }
        return result
    }

    val input = readInput("Day08")
    part1(input).println()
    part2(input).println()
}
