fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        for (game in input) {
            if (game[2] == 'X') {
                result += 1
                if (game[0] == 'C') {
                    result += 6
                }
            }
            if (game[2] == 'Y') {
                result += 2
                if (game[0] == 'A') {
                    result += 6
                }
            }
            if (game[2] == 'Z') {
                result += 3
                if (game[0] == 'B') {
                    result += 6
                }
            }
            if (game[0] - 'A' == game[2] - 'X') {
                result += 3
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (game in input) {
            if (game[2] == 'X') {
                if (game[0] == 'A') {
                    result += 3
                }
                if (game[0] == 'B') {
                    result += 1
                }
                if (game[0] == 'C') {
                    result += 2
                }
            }
            if (game[2] == 'Y') {
                result += 3
                if (game[0] == 'A') {
                    result += 1
                }
                if (game[0] == 'B') {
                    result += 2
                }
                if (game[0] == 'C') {
                    result += 3
                }
            }
            if (game[2] == 'Z') {
                result += 6
                if (game[0] == 'A') {
                    result += 2
                }
                if (game[0] == 'B') {
                    result += 3
                }
                if (game[0] == 'C') {
                    result += 1
                }
            }
        }
        return result
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
