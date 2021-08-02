
class ChangeCalculator(val coinList:List<Int>){

    fun computeMostEfficientChange(grandTotal: Int): List<Int> {
        var minCoinList: MutableList<MutableList<Int>> = mutableListOf()
        // Start by filling with empty lists upto smallest coin.
        val minCoin = coinList.reduce {minimum, value -> if (value<minimum) {value} else {minimum} }
        for (i in 0..grandTotal) {
            minCoinList.add(mutableListOf())
        }
        if (minCoin <= grandTotal) {
            minCoinList[minCoin].add(minCoin)
        } else {
            return emptyList()
        }
        for (coin in coinList.sorted()) {
            for (idx in coin..grandTotal) {
                val numNewCoin: Int = idx / coin
                for (search in numNewCoin downTo 1) {
                    var newCoinListToAdd = MutableList(search) { coin }
                    if ((idx - coin*search) == 0) {
                        minCoinList[idx] = newCoinListToAdd
                        break
                    } else if (minCoinList[idx - coin*search].isNotEmpty()) {
                        minCoinList[idx] = (newCoinListToAdd + minCoinList[idx - coin*search]) as MutableList<Int>
                        break
                    }
                }
            }
        }
        println(minCoinList)

        return minCoinList[grandTotal].sorted()
    }
}
