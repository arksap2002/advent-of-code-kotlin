import java.util.*
import kotlin.math.min

fun isCorrect(from: Char, to: Char): Boolean = to - from <= 1

fun main() {
    fun part1(input: List<String>): Int {
        val board = mutableListOf<MutableList<Int>>()
        val used = mutableListOf<MutableList<Boolean>>()
        var current = Pair(0, 0)
        var finish = Pair(0, 0)
        for (i in input.indices) {
            val tmpBoard = mutableListOf<Int>()
            val tmpUsed = mutableListOf<Boolean>()
            for (j in 0 until input[0].length) {
                if (input[i][j] == 'S') {
                    current = Pair(i, j)
                }
                if (input[i][j] == 'E') finish = Pair(i, j)
                tmpBoard.add(Int.MAX_VALUE)
                tmpUsed.add(false)
            }
            board.add(tmpBoard)
            used.add(tmpUsed)
        }
        board[current.first][current.second] = 0
        used[current.first][current.second] = true
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(current)
        while (!queue.isEmpty()) {
            current = queue.remove()!!
            val x = current.first
            val y = current.second
            val xes = listOf(0, 0, -1, 1)
            val yes = listOf(-1, 1, 0, 0)
            for (i in xes.indices) {
                val newX = x + xes[i]
                val newY = y + yes[i]
                if (newX < 0 || newX >= input.size || newY < 0 || newY >= input[0].length) continue
                if (isCorrect(input[x][y], input[newX][newY])
                    || (input[x][y] == 'S' && isCorrect('a', input[newX][newY]))
                    || (input[newX][newY] == 'E' && isCorrect(input[x][y], 'z'))
                ) {
                    board[newX][newY] = min(board[newX][newY], board[x][y] + 1)
                    if (!used[newX][newY]) {
                        queue.add(Pair(newX, newY))
                        used[newX][newY] = true
                    }
                }
            }
        }
        return board[finish.first][finish.second]
    }

    fun part2(input: List<String>): Int {
        var result = part1(input)
        val starts = mutableListOf<Pair<Int, Int>>()
        val newInput = mutableListOf<String>()
        var current = Pair(0, 0)
        for (i in input.indices) {
            newInput.add(input[i])
            for (j in 0 until input[0].length) {
                if (input[i][j] == 'a') starts.add(Pair(i, j))
                if (input[i][j] == 'S') current = Pair(i, j)
            }
        }
        for (pair in starts) {
            var s = ""
            for (i in 0 until newInput[current.first].length) {
                s += if (newInput[current.first][i] == 'S') {
                    'a'
                } else {
                    newInput[current.first][i]
                }
            }
            newInput[current.first] = s
            current = pair
            s = ""
            for (i in 0 until newInput[current.first].length) {
                s += if (i == current.second) {
                    'S'
                } else {
                    newInput[current.first][i]
                }
            }
            newInput[current.first] = s
            result = min(result, part1(newInput))
        }
        return result
    }

    val input = readInput("Day12")
    part1(input).println()
    part2(input).println()
}
