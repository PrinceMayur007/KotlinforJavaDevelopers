package board


fun IntProgression.applyBounds(bound: Int): IntProgression =
        when {
            last > bound -> first..bound
            first > bound -> bound..last
            else -> this
        }