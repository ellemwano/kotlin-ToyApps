package Aquarium

fun labels() {

    // If i > 10, we break and resume execution at the label
    loop@ for (i in 1..100) {
        for (j in 1..100)
            if (i > 10) break@loop
    }
}