package practice.functionalManipulation

fun main() {

    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    // lamda here is getting remainder of division by 3  for each item(rem: remainder)
    print(numbers.divisibleBy { it.rem(3) })  // [3, 6, 9, 0]
}

// Returns all numbers divisible by (Int) in a given list
fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {

    val result = mutableListOf<Int>()
    for (item in this) {
        // if the result of the lambda is null
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}