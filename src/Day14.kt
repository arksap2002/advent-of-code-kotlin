import kotlin.math.max
import kotlin.math.min

fun main() {
    val board = mutableListOf<MutableList<Char>>()
    val n = 700

    fun put(x: Int, y: Int): Boolean {
        if (x == board.size - 1) return false
        if (board[x + 1][y] == '.') return put(x + 1, y)
        if (board[x + 1][y - 1] == '.') return put(x + 1, y - 1)
        if (board[x + 1][y + 1] == '.') return put(x + 1, y + 1)
        board[x][y] = 'o'
        return true
    }

    fun part1(input: List<String>): Int {
        for (i in 0..n) {
            val line = mutableListOf<Char>()
            for (j in 0..n) {
                line.add('.')
            }
            board.add(line)
        }
        for (line in input) {
            val points = line.split(" -> ")
            for (i in points.indices) {
                if (i == points.size - 1) break
                val x1 = points[i].split(",")[0].toInt()
                val y1 = points[i].split(",")[1].toInt()
                val x2 = points[i + 1].split(",")[0].toInt()
                val y2 = points[i + 1].split(",")[1].toInt()
                if (x1 == x2) {
                    for (k in min(y1, y2)..max(y1, y2)) {
                        board[k][x1] = '#'
                    }
                }
                if (y1 == y2) {
                    for (k in min(x1, x2)..max(x1, x2)) {
                        board[y1][k] = '#'
                    }
                }
            }
        }
        var result = 0
        while (put(1, 500)) {
            result++
        }
        return result
    }

    fun part2(input: List<String>): Int {
        for (i in 0..n) {
            val line = mutableListOf<Char>()
            for (j in 0..n) {
                line.add('.')
            }
            board.add(line)
        }
        var depth = 0
        for (line in input) {
            val points = line.split(" -> ")
            for (i in points.indices) {
                if (i == points.size - 1) break
                val x1 = points[i].split(",")[0].toInt()
                val y1 = points[i].split(",")[1].toInt()
                val x2 = points[i + 1].split(",")[0].toInt()
                val y2 = points[i + 1].split(",")[1].toInt()
                depth = max(depth, max(y1, y2))
                if (x1 == x2) {
                    for (k in min(y1, y2)..max(y1, y2)) {
                        board[k][x1] = '#'
                    }
                }
                if (y1 == y2) {
                    for (k in min(x1, x2)..max(x1, x2)) {
                        board[y1][k] = '#'
                    }
                }
            }
        }
        depth += 2
        for (i in 0..n) {
            board[depth][i] = '#'
        }
        var result = 0
        while (put(0, 500)) {
            result++
            if (board[0][500] == 'o') break
        }
        return result
    }

    val input = readInput("Day14")
    part1(input).println()
    board.clear()
    part2(input).println()
}
