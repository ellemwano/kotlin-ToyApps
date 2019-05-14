package com.example.kotlinplayer


/*
  Implementing a callback without a lambda
 */
//interface Callback {
//    fun onCallback(result: String)
//}

//fun doAsync(x: Int, callback: Callback) {
//    // (...) Background
//    callback.onCallback("Finished")
//}

//fun test2() {
//    doAsync(20, object: Callback {
//        override fun onCallback(result: String) {
//            print(result)
//        }
//    })
//}


/*
  Implementing a callback using a lambda
 */
fun doAsync(x: Int, callback: (String) -> Unit) {
    // (...) Background
    callback("Finished")  // Same as callback.invoke("Finished")
}

fun test2() {
    doAsync(20) { result -> print(result) }
}



/*
  Lambdas intro
 */
fun test1() {

    val sum = { a: Int, b: Int -> a + b }
    applyOp(2, 3, sum)  // 5

    val mul = { a: Int, b: Int -> a * b }
    applyOp(2, 3, mul)  // 6

    // Removing the intermediate variable
    applyOp(2,3) { first, second -> first - second }  // -1
}

fun applyOp(x: Int, y: Int, f: (Int, Int) -> Int): Int = f(x, y)