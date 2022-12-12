fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        for (bag in input) {
            val hashSet = mutableSetOf<Char>()
            for (i in bag.indices) {
                if (i < bag.length / 2) {
                    hashSet.add(bag[i])
                } else {
                    if (hashSet.contains(bag[i])) {
                        hashSet.remove(bag[i])
                        result += if (bag[i] in 'A'..'Z') {
                            27 + (bag[i] - 'A')
                        } else {
                            1 + (bag[i] - 'a')
                        }
                    }
                }
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        var index = 0
        while (index < input.size) {
            val hashSet1 = mutableSetOf<Char>()
            for (i in input[index].indices) {
                hashSet1.add(input[index][i])
            }
            index++
            val hashSet2 = mutableSetOf<Char>()
            for (i in input[index].indices) {
                hashSet2.add(input[index][i])
            }
            index++
            for (i in input[index].indices) {
                if (hashSet1.contains(input[index][i]) && hashSet2.contains(input[index][i])) {
                    result += if (input[index][i] in 'A'..'Z') {
                        27 + (input[index][i] - 'A')
                    } else {
                        1 + (input[index][i] - 'a')
                    }
                    break
                }
            }
            index++
        }
        return result
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
