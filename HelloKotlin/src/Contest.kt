fun readLn() = readLine()!!
fun readInt() = readLn().toInt()
fun readStrings() = readLn().split(" ")
fun readInts() = readStrings().map { it.toInt() }

fun main() {

    val k = readInt()

    repeat(k) {
        val (a, b) = readStrings()
        if (b.length > a.length) println("NO")

        for (i in 0 until a.length) {
            if (a.elementAt(i) == b.elementAt(i) ||
                (b.elementAt(i) == '+' &&
                        a.elementAt(i) == '-' && a.elementAt(i+1) == '-')
            ) i.inc() else println("NO")
        }
        println("YES")
    }
}




//fun readLn() = readLine()!!
//fun readInt() = readLn().toInt()
//fun readStrings() = readLn().split(" ")
//fun readInts() = readStrings().map { it.toInt() }
//
//fun practice.functions.main() {
//
//    val k = readInt()
//
//    repeat(k) {
//        val (a, b) = readStrings()
//        if (b.length > a.length) println("NO")
//
//        for (i in 0 until a.length) {
//            if (a.elementAt(i) == b.elementAt(i) ||
//                (b.elementAt(i) == '+' &&
//                        a.elementAt(i) == '-' && a.elementAt(i+1) == '-')
//            ) i.inc() else println("NO")
//        }
//        println("YES")
//    }
//}