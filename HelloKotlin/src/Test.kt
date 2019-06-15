
//fun readLn() = readLine()!!
//fun readInt() = readLn().toInt()
//fun readStrings() = readLn().split(" ")
//fun readInts() = readStrings().map { it.toInt() }
//
//data class Segment(
//    val l: Int,
//    val r: Int
//)
//
//fun practice.functions.main() {
//    val t = readInt()
//    repeat(t) {
//        val n = readInt()
//
//        val array = mutableListOf<Segment>()
//        var minA: Int
//        var maxA: Int
//        var minB: Int? = null
//        var maxB: Int? = null
//
//        repeat(n) {
//            val (a, b) = readInts()
//            array.add(Segment(a, b))
//        }
//
//        minA = array.minBy { it.l }
//        maxA = array.maxBy { it.r } - 1
//        minB = maxA + 1
//        maxB = array.maxBy { it.r }
//
//
//
//}
//
//
//
//}

//fun readLn() = readLine()!!
//fun readInt() = readLn().toInt()
//fun readStrings() = readLn().split(" ")
//fun readInts() = readStrings().map { it.toInt() }
//
//fun practice.functions.main() {
//    val t = readInt()
//    repeat(t) {
//        val n = readInt()
//
//        val array = mutableListOf<Array<Int>>()
//        var startA: Int
//        var endA: Int
//        var startB: Int? = null
//        var endB: Int? = null
//
//        repeat(n) {
//            val (a, b) = readInts()
//            array.add(arrayOf(a, b))
//        }
//
//        array.apply {
//            sortBy { it[0] }
//            startA = elementAt(0)[0]
//            endA = elementAt(0)[1]
//        }
//
//        for (i in 1 until n) {
//            val start = array.elementAt(i)[0]
//            val end = array.elementAt(i)[1]
//            if (start <= endA) {
//                if (start < startA) startA = start
//                if (end > endA) endA = end
//            } else {
//                if (startB == null && endB == null) {
//                    startB = start
//                    endB = end
//                } else {
//                    if (start >= startB!!) {
//                        if (end > endB!!) endB = end
//                    }
//                    if (start < startB) startB = start
//                }
//            }
//        }
//        if (startB == null && endB == null) {
//            println("-1")
//        } else {
//            returnAnswer(array, startA, endA)
//        }
//    }
//}
//
//fun returnAnswer(array:MutableList<Array<Int>>, startA: Int, endA: Int) {
//    var answer = mutableListOf<Int>()
//    array.forEach {
//        if (it[0] in startA..endA) answer.add(1) else answer.add(2)
//    }
//    println(answer.joinToString(" "))
//}