import org.junit.Test

class GameTest {

    @Test
    fun kingInFirstFoundationPile() {
        // arrange
        var numGames = 0
        val maxGames = 10000

        // act
        for (i in 1..maxGames) {
            numGames++
            GameModel.resetGame()
            // Simulate a game: tap deck, tap waste pile, tap last card in each tableau pile x100
            for (j in 1..100) {
                GamePresenter.onDeckTap()
                GamePresenter.onWasteTap()
                GameModel.tableauPiles.forEachIndexed { index, tableauPile ->
                    GamePresenter.onTableauTap(index,
                        tableauPile.cards.lastIndex)
                }
            }
            // Check if King in first foundation pile (top card)
            if (GameModel.foundationPiles[0].cards.size == 13) {
                break
            }
        }

        // assert
        GameModel.debugPrint()
        println("# Games: $numGames")
        assert(numGames < maxGames)  // Assert we'll get a King in less than 10000 games, after 100 tries in each
    }
}