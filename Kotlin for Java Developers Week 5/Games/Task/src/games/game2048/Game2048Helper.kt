package games.game2048

/*
 * This function moves all the non-null elements to the beginning of the list
 * (by removing nulls) and merges equal elements.
 * The parameter 'merge' specifies the way how to merge equal elements:
 * it returns a new element that should be present in the resulting list
 * instead of two merged elements.
 *
 * If the function 'merge("a")' returns "aa",
 * then the function 'moveAndMergeEqual' transforms the input in the following way:
 *   a, a, b -> aa, b
 *   a, null -> a
 *   b, null, a, a -> b, aa
 *   a, a, null, a -> aa, a
 *   a, null, a, a -> aa, a
 *
 * You can find more examples in 'TestGame2048Helper'.
*/
fun <T : Any> List<T?>.moveAndMergeEqual(merge: (T) -> T): List<T>{

    val listMutable= mutableListOf<T>()
    val list =this.filter{it!= null}
    if(list.isEmpty())return listOf<T>()


    if(list.size == 1) return list.filterNotNull()


    var i = 1
    listMutable.add(0, list[0]!!)
    while ( i < list.size) {
        if (listMutable.last() == list[i]) {
            listMutable.removeAt(listMutable.lastIndex)
            listMutable.add(listMutable.lastIndex+1, merge(list[i-1]!!))

        }else{
            listMutable.add(listMutable.lastIndex+1, list[i]!!)
        }
        i++
    }
    return listMutable


}

