package games.gameOfFifteen

interface GameOfFifteenInitializer {
    /*
     * Even permutation of numbers 1..15
     * used to initialized the first 15 cells on a board.
     * The last cell is empty.
     */
    val initialPermutation: List<Int>
}

class RandomGameInitializer : GameOfFifteenInitializer {
    /*
     * Generate a random permutation from 1 to 15.
     * `shuffled()` function might be helpful.
     * If the permutation is not even, make it even (for instance,
     * by swapping two numbers).
     */
    override val initialPermutation by lazy {
      //  val l = (1..15).toList()
      //          .shuffled().toMutableList()
      //  val temp = l.get(0)
      //  l.set(0,l.get(1))
      //  l.set(1,temp)
      //  l
        val l = (1..15).toList()
                .shuffled().toMutableList()
        val temp = l[0]
        l[0] = l[1]
        l[1] = temp
        l
    }
}

