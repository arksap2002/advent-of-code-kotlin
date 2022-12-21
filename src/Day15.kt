import kotlin.math.abs

fun main() {
    fun dist(x: Long, y: Long, x1: Long, y1: Long): Long = abs(x - x1) + abs(y - y1)

    fun part1(input: List<String>): Long {
        val arr = mutableListOf<Boolean>()
        val n = 100_000_000
        val y: Long = 2000000
        for (i in -n..n) {
            arr.add(false)
        }
        val hashSet: HashSet<Long> = hashSetOf()
        for (line in input) {
            val sensorX = line.split(" ")[2].substring(2, line.split(" ")[2].length - 1).toLong()
            val sensorY = line.split(" ")[3].substring(2, line.split(" ")[3].length - 1).toLong()
            val beaconX = line.split(" ")[8].substring(2, line.split(" ")[8].length - 1).toLong()
            val beaconY = line.split(" ")[9].substring(2).toLong()
            if (beaconY == y) hashSet.add(beaconX)
            for (i in -n..n) {
                if (dist(sensorY, sensorX, beaconY, beaconX) >= dist(sensorY, sensorX, y, i.toLong())) {
                    arr[i + n] = true
                }
            }
        }
        var result: Long = 0
        for (i in arr.indices) {
            if (arr[i] && !hashSet.contains((i - n).toLong())) {
                result++
            }
        }
        return result
    }

    fun good(x: Long): Boolean = x in 0..4000000


    fun fullCheck(input: List<String>, y: Long, x: Long): Boolean {
        for (line in input) {
            val sensorX = line.split(" ")[2].substring(2, line.split(" ")[2].length - 1).toLong()
            val sensorY = line.split(" ")[3].substring(2, line.split(" ")[3].length - 1).toLong()
            val beaconX = line.split(" ")[8].substring(2, line.split(" ")[8].length - 1).toLong()
            val beaconY = line.split(" ")[9].substring(2).toLong()
            if (dist(sensorY, sensorX, beaconY, beaconX) >= dist(sensorY, sensorX, y, x)) {
                return false
            }
        }
        return true
    }

    fun part2(input: List<String>): Long {
        for (line in input) {
            val sensorX = line.split(" ")[2].substring(2, line.split(" ")[2].length - 1).toLong()
            val sensorY = line.split(" ")[3].substring(2, line.split(" ")[3].length - 1).toLong()
            val beaconX = line.split(" ")[8].substring(2, line.split(" ")[8].length - 1).toLong()
            val beaconY = line.split(" ")[9].substring(2).toLong()
            val d = dist(sensorY, sensorX, beaconY, beaconX) + 1
            for (y in sensorY - d..sensorY + d) {
                val x1 = d - abs(sensorY - y) + sensorX
                val x2 = abs(sensorY - y) - d + sensorX
                if (good(y) && good(x1) && fullCheck(input, y, x1)) return 4000000 * x1 + y
                if (good(y) && good(x2) && fullCheck(input, y, x2)) return 4000000 * x2 + y
            }
        }
        return -1
    }

    val input = readInput("Day15")
    part1(input).println()
    part2(input).println()
}
