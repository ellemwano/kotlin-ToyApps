package com.example.kotlinplayer

fun test() {

}

//private fun readLn() = readLine()!! // string line
//private fun readInt() = readLn().toInt() // single int
//private fun readStrings() = readLn().split(" ") // list of strings
//private fun readInts() = readStrings().map { it.toInt() } // list of ints
//
//fun main() {
//
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
//            array.add(arrayOf(a, b))   // we have an array of array
//        }
//
//        array.apply {
//            sortBy { it[0] }  // sort
//            startA = elementAt(0)[0]  // take the first segment and set start and finish
//            endA = elementAt(0)[1]
//        }
//
//        // for each other elements
//        for (i in 1 until n) {
//            val start = array.elementAt(i)[0]
//            val end = array.elementAt(i)[1]
//            // check if first element less than endA
//            if (start <= endA) {
//                // If so, check if less than start, then set new start
//                if (start < startA) startA = start
//                // check if end outside range and set new end
//                if (end > endA) endA = end
//            } else {
//                if (startB == null && endB == null) {
//                    startB = start
//                    endB = end
//                } else {
//                    if (start >= startB!!) {
//                        // check if end outside range and set new end
//                        if (end > endB!!) endB = end
//                    }
//                }
//            }
//        }
//        if (startB == null && endB == null) {
//            println("-1")
//        } else {
//            // Second iteration
//            val string = ""
//            array.forEach {
//                if (it[0] in startA..endA) string.plus("1").plus(" ") else string.plus("2").plus(" ")
//            }
//            println(string)
//        }
//    }
//


//    fun readLn() = readLine()!!
//    fun readInt() = readLn().toInt()
//    fun readStrings() = readLn().split(" ")
//    fun readInts() = readStrings().map { it.toInt() }
//
//    fun main() {
//        val t = readInt()
//        repeat(t) {
//            val n = readInt()
//
//            val array = mutableListOf<Array<Int>>()
//            var startA: Int
//            var endA: Int
//            var startB: Int? = null
//            var endB: Int? = null
//
//            repeat(n) {
//                val (a, b) = readInts()
//                array.add(arrayOf(a, b))
//            }
//
//            array.apply {
//                sortBy { it[0] }
//                startA = elementAt(0)[0]
//                endA = elementAt(0)[1]
//            }
//
//            if (n == 1) {
//                returnAnswer(array, startA, endA)
//            } else {
//                for (i in 1 until n) {
//                    val start = array.elementAt(i)[0]
//                    val end = array.elementAt(i)[1]
//                    if (start <= endA) {
//                        if (start < startA) startA = start
//                        if (end > endA) endA = end
//                    } else {
//                        if (startB == null && endB == null) {
//                            startB = start
//                            endB = end
//                        } else {
//                            if (start >= startB!!) {
//                                if (end > endB!!) endB = end
//                            }
//                        }
//                    }
//                }
//                if (startB == null && endB == null) {
//                    println("-1")
//                } else {
//                    returnAnswer(array, startA, endA)
//                }
//            }
//        }
//    }
//
//fun returnAnswer(array:MutableList<Array<Int>>, startA: Int, endA: Int) {
//    val answer = mutableListOf<Int>()
//    array.forEach {
//        if (it[0] in startA..endA) answer.add(1) else answer.add(2)
//    }
//    println(answer.joinToString(" "))
//}
