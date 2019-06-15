package practice.functionalManipulation

enum class Direction {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game() {

    var path = mutableListOf<Direction>(Direction.START)
    val north = { path.add(Direction.NORTH) }
    val south = { path.add(Direction.SOUTH)}
    val east = { path.add(Direction.EAST)}
    val west = { path.add(Direction.WEST)}
    val end = {
        path.add(Direction.END)
        println("Game Over")
        println(path)
//        println(path.joinToString(" "))  // prints without []
        path.clear()
        false
    }

    fun move(where: () -> Boolean) {
        where()
    }

    fun makeMove(command: String?) {
        when (command) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)

        }
    }
}

fun main() {
    var game = Game()
//    println(game.path)
//    game.north()
//    game.east()
//    game.south()
//    game.west()
//    game.end()
//    println(game.path)

    while (true) {
        print("Enter a direction: n/s/e/w: ")
        game.makeMove(readLine())
    }
}


// Solution code
//fun makeMove(command:String?) {
//    if (command.equals("n")) move(north)
//    else if (command.equals("s")) move(south)
//    else if (command.equals("e")) move(east)
//    else if (command.equals("w")) move(west)
//    else move(end)
//}