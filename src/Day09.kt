import kotlin.math.abs

class Point(a: Int, b: Int) {
    private var x = a
    private var y = b
    fun isNear(other: Point): Boolean = abs(x - other.x) <= 1 && abs(y - other.y) <= 1

    fun goUp() = y++

    fun goDown() = y--

    fun goLeft() = x--

    fun goRight() = x++

    fun goToHead(head: Point) {
        if (isNear(head)) return
        if (y < head.y) y++
        if (y > head.y) y--
        if (x < head.x) x++
        if (x > head.x) x--
    }

    fun getPair() = Pair(x, y)
}

fun main() {
    fun part1(input: List<String>): Int {
        val hashSet = HashSet<Pair<Int, Int>>()
        val head = Point(0, 0)
        val tail = Point(0, 0)
        hashSet.add(tail.getPair())
        for (line in input) {
            val way = line.split(" ")[0]
            val count = line.split(" ")[1].toInt()
            repeat(count) {
                if (way == "U") head.goUp()
                if (way == "D") head.goDown()
                if (way == "L") head.goLeft()
                if (way == "R") head.goRight()
                tail.goToHead(head)
                hashSet.add(tail.getPair())
            }
        }
        return hashSet.size
    }

    fun part2(input: List<String>): Int {
        val n = 9
        val hashSet = HashSet<Pair<Int, Int>>()
        val head = Point(0, 0)
        val tails = mutableListOf<Point>()
        repeat(n) {
            tails.add(Point(0, 0))
        }
        hashSet.add(tails[n - 1].getPair())
        for (line in input) {
            val way = line.split(" ")[0]
            val count = line.split(" ")[1].toInt()
            repeat(count) {
                if (way == "U") head.goUp()
                if (way == "D") head.goDown()
                if (way == "L") head.goLeft()
                if (way == "R") head.goRight()
                tails[0].goToHead(head)
                for (i in 1 until n) {
                    tails[i].goToHead(tails[i - 1])
                }
                hashSet.add(tails[n - 1].getPair())
            }
        }
        return hashSet.size
    }

    val input = readInput("Day09")
    part1(input).println()
    part2(input).println()
}
