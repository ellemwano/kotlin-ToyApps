package practice.functions

import kotlin.random.Random


fun main() {
    gamePlay(rollDice2(10))
}

// Returns a dice roll between 1 and 12
val rollDice = { Random.nextInt(12) + 1 }

// Returns number of sides used for the roll
val rollDiceAlt = { sides: Int ->
    Random.nextInt(sides) + 1
}

// Return 0 if number of sides passed in is 0
val rollDice0 = { sides: Int ->
    if (sides == 0) 0
    else Random.nextInt(sides) + 1
}

// As above, using function type notation
val rollDice2: (Int) -> Int = { sides ->
    if (sides == 0) 0
    else Random.nextInt(sides) + 1
}

fun gamePlay(diceRoll: Int) {
    println(diceRoll)
}