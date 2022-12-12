fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        var i = 0
        var x = 1
        for (line in input) {
            if (line == "noop") {
                i++
                if ((i - 20) % 40 == 0 && i <= 220) {
                    result += x * i
                }
            } else {
                val value = line.split(" ")[1].toInt()
                i++
                if ((i - 20) % 40 == 0 && i <= 220) {
                    result += x * i
                }
                i++
                if ((i - 20) % 40 == 0 && i <= 220) {
                    result += x * i
                }
                x += value
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        TODO()
    }

    val input = readInput("Day10")
    part1(input).println()
    part2(input).println()
}
