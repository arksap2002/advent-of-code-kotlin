fun main() {
    fun part1(input: List<String>): Int {
        var i = 0
        while (i < input[0].length) {
            val hashSet = HashSet<Char>()
            var flag = true
            for (j in i..i + 3) {
                if (hashSet.contains(input[0][j])) {
                    flag = false
                }
                hashSet.add(input[0][j])
            }
            if (flag) {
                return i + 4
            }
            i++
        }
        return -1
    }

    fun part2(input: List<String>): Int {
        var i = 0
        while (i < input[0].length) {
            val hashSet = HashSet<Char>()
            var flag = true
            for (j in i..i + 13) {
                if (hashSet.contains(input[0][j])) {
                    flag = false
                }
                hashSet.add(input[0][j])
            }
            if (flag) {
                return i + 14
            }
            i++
        }
        return -1
    }

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}
