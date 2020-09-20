package games.gameOfFifteen

/*
 * This function should return the parity of the permutation.
 * true - the permutation is even
 * false - the permutation is odd
 * https://en.wikipedia.org/wiki/Parity_of_a_permutation

 * If the game of fifteen is started with the wrong parity, you can't get the correct result
 *   (numbers sorted in the right order, empty cell at last).
 * Thus the initial permutation should be correct.
 */
fun isEven(permutation: List<Int>): Boolean {
    fun numOfS(num: Int, list: List<Int>):Int{
        var returnNum=0
        for (i in list){
            if( num > i) returnNum++
        }
        return returnNum
    }

    var i = 0
    var num = 0
    val len = permutation.size
    while(i < len){
        num += numOfS(permutation[i],permutation.subList(i+1,len))

        i++
    }

    return num%2==0
}