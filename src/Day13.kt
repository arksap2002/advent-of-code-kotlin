enum class Type {
    RIGHT, UNKNOWN, WRONG
}

fun main() {
    fun stringToArray(s: String): MutableList<String> {
        val arr = mutableListOf<String>()
        var bal = 0
        var currentString = ""
        for (i in s.indices) {
            if (s[i] == ',' && bal == 0) {
                arr.add(currentString)
                currentString = ""
                continue
            }
            if (s[i] == '[') {
                bal++
            }
            if (s[i] == ']') {
                bal--
            }
            currentString += s[i]
        }
        arr.add(currentString)
        return arr
    }

    fun run(first: String, second: String): Type {
        if (first[0] != '[') return run("[$first]", second)
        if (second[0] != '[') return run(first, "[$second]")
        val newFirst = first.substring(1, first.length - 1)
        val newSecond = second.substring(1, second.length - 1)
        if (newFirst.isEmpty() && newSecond.isEmpty()) return Type.UNKNOWN
        if (newFirst.isEmpty()) return Type.RIGHT
        if (newSecond.isEmpty()) return Type.WRONG
        if (newFirst.toIntOrNull() != null && newSecond.toIntOrNull() != null) {
            if (newFirst.toInt() == newSecond.toInt()) return Type.UNKNOWN
            if (newFirst.toInt() < newSecond.toInt()) return Type.RIGHT
            return Type.WRONG
        }
        val elementsFirst = stringToArray(newFirst)
        val elementsSecond = stringToArray(newSecond)
        for (i in elementsFirst.indices) {
            if (i == elementsSecond.size) return Type.WRONG
            val result = run(elementsFirst[i], elementsSecond[i])
            if (result == Type.UNKNOWN) continue
            return result
        }
        if (elementsFirst.size == elementsSecond.size) return Type.UNKNOWN
        return Type.RIGHT
    }

    fun part1(input: List<String>): Int {
        var result = 0
        var i = 0
        while (i < input.size) {
            val x = run(input[i], input[i + 1])
            if (x == Type.RIGHT) {
                result += i / 3 + 1
            }
            i += 3
        }
        return result
    }

    fun part2(input: List<String>): Int {
        val tmpInput: MutableList<String> = mutableListOf()
        for (s in input) {
            tmpInput.add(s)
        }
        tmpInput.add("[[2]]")
        tmpInput.add("[[6]]")
        val lines = tmpInput.filter { it.isNotEmpty() }
        val myCustomComparator =  Comparator<String> { a, b ->
            when {
                run(a, b) == Type.UNKNOWN -> 0
                run(a, b) == Type.RIGHT -> -1
                else -> 1
            }
        }
        val sortedLines = lines.sortedWith(myCustomComparator)
        var result = 1
        for (i in sortedLines.indices) {
            if (sortedLines[i] == "[[2]]") result *= i + 1
            if (sortedLines[i] == "[[6]]") result *= i + 1
        }
        return result
    }

    val input = readInput("Day13")
    part1(input).println()
    part2(input).println()
}
