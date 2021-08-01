
class ChainNotFoundException(msg: String) : RuntimeException(msg)

data class Domino(val left: Int, val right: Int)

object Dominoes {

    fun formChain(vararg inputA: Domino): List<Domino> {
        val input: List<Domino> = inputA.toList()
        return if (input.isEmpty()) {
            input
        } else {
            formChain(inputA.toList())
        }
    }

    fun formChain(inputDominoes: List<Domino>): List<Domino> {
        var mutableID = inputDominoes.toMutableList()
        // Handle Simples Case of Empty Input
        if (mutableID.isEmpty()) {
            return mutableID
        } else if (mutableID.size == 1) {
            if (mutableID[0].left != mutableID[0].right) {
                throw ChainNotFoundException("A chain cannot be formed with the input Dominoes")
            } else {
                return mutableID
            }
        }
        // Convert inputDominoes into Graph DS: 1) Adjacency Map and
        // 2) Degree Map and 3) Strongly Connected Components
        var adjMap: MutableMap<Int, MutableList<Int>> = generateAdjMap(mutableID)
        var degreeMap: MutableMap<Int, Int> = generateDegreeMap(mutableID)
        var scc: Int = connectedComponents(adjMap)
        // Determine if Solvable
        var isSolvable = solvable(degreeMap, scc)
        // formChain if solvable, otherwise return ChainNotFoundException
        if (!isSolvable) {
            throw ChainNotFoundException("A chain cannot be formed with the input Dominoes")
        } else {
            return createChain(adjMap, degreeMap, mutableID).toList()
        }
    }

    private fun createChain(adjMap: MutableMap<Int, MutableList<Int>>, degreeMap: MutableMap<Int,Int>, mutableID: MutableList<Domino>): List<Domino> {
        var chainSoFar: MutableList<Domino> = mutableListOf()
        var dominoLeft = 0
        var adjMapToModify: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        var adjMapToModify2: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for ((k,v) in adjMap) {
            adjMapToModify[k.toInt()] = adjMap[k]!!.toMutableList()
            adjMapToModify2[k.toInt()] = adjMap[k]!!.toMutableList()
        }
        var degreeMapToModify: MutableMap<Int,Int> = degreeMap.toMutableMap()
        while (chainSoFar.size != mutableID.size) {
            if (chainSoFar.isEmpty()) {
                dominoLeft = adjMapToModify.keys.first()
            } else {
                dominoLeft = chainSoFar[chainSoFar.lastIndex].right
            }

            var notModified = true
            if (adjMapToModify2[dominoLeft]!!.contains { dominoLeft }) {
                chainSoFar.add(Domino(left = dominoLeft, right = dominoLeft))
                degreeMapToModify[dominoLeft] = degreeMapToModify[dominoLeft]!!.minus(2)
                adjMapToModify[dominoLeft]!!.remove(dominoLeft)
                adjMapToModify[dominoLeft]!!.remove(dominoLeft)
                adjMapToModify2[dominoLeft]!!.remove(dominoLeft)
                adjMapToModify2[dominoLeft]!!.remove(dominoLeft)
            } else {
                for (endVert in adjMapToModify[dominoLeft]!!) {
                    adjMapToModify2[dominoLeft]!!.remove(endVert)
                    adjMapToModify2[endVert]!!.remove(dominoLeft)
                    if (dominoLeft in adjMapToModify2.keys && adjMapToModify2[dominoLeft]!!.isEmpty()) {
                        adjMapToModify2.remove(dominoLeft)
                    }
                    if (endVert in adjMapToModify2.keys && adjMapToModify2[endVert]!!.isEmpty()) {
                        adjMapToModify2.remove(endVert)
                    }
                    if (connectedComponents(adjMapToModify2) > 1) {
                        if (dominoLeft in adjMapToModify2.keys) {
                            adjMapToModify2[dominoLeft]!!.add(endVert)
                        } else {
                            adjMapToModify2[dominoLeft] = mutableListOf(endVert)
                        }
                        if (endVert in adjMapToModify2.keys) {
                            adjMapToModify2[endVert]!!.add(dominoLeft)
                        } else {
                            adjMapToModify2[endVert] = mutableListOf(dominoLeft)
                        }
                        continue
                    }
                    chainSoFar.add(Domino(left = dominoLeft, right = endVert))
                    adjMapToModify[dominoLeft]!!.remove(endVert)
                    adjMapToModify[endVert]!!.remove(dominoLeft)
                    if (dominoLeft in adjMapToModify.keys && adjMapToModify[dominoLeft]!!.isEmpty()) {
                        adjMapToModify.remove(dominoLeft)
                    }
                    if (endVert in adjMapToModify.keys && adjMapToModify[endVert]!!.isEmpty()) {
                        adjMapToModify.remove(endVert)
                    }
                    degreeMapToModify[dominoLeft] = degreeMapToModify[dominoLeft]!!.minus(1)
                    degreeMapToModify[endVert] = degreeMapToModify[endVert]!!.minus(1)
                    notModified = false
                    break
                }
                if (notModified) {
                    var dominoRight = adjMapToModify[dominoLeft]!![0]
                    chainSoFar.add(Domino(left = dominoLeft, right = dominoRight))
                    degreeMapToModify[dominoLeft] = degreeMapToModify[dominoLeft]!!.minus(1)
                    degreeMapToModify[dominoRight] = degreeMapToModify[dominoRight]!!.minus(1)
                    adjMapToModify[dominoLeft]!!.remove(dominoRight)
                    adjMapToModify[dominoRight]!!.remove(dominoLeft)
                }
            }
        }
        return chainSoFar
    }

    private fun connectedComponents(adjMap: MutableMap<Int,MutableList<Int>>):Int {
        var listOfSets: MutableList<MutableSet<Int>> = mutableListOf()
        for (key in adjMap.keys) {
            if (listOfSets.isEmpty()) {
                listOfSets.addAll(listOf(adjMap[key]?.toMutableSet() as MutableSet<Int>))
                listOfSets[0].add(key)
            } else {
                var tempSet: MutableSet<Int> = mutableSetOf()
                tempSet = tempSet.union(adjMap[key] as Iterable<Int>) as MutableSet<Int>
                tempSet.add(key)
                var joinedSets: MutableList<Int> = mutableListOf()
                listOfSets.forEachIndexed { idx, set -> if (tempSet.intersect(set).isNotEmpty()) { tempSet = tempSet.union(set) as MutableSet<Int>; joinedSets.add(idx) } }

                var counter = 0
                for (idx in joinedSets) {
                    listOfSets.removeAt(idx - counter)
                    counter++
                }
                listOfSets.add(tempSet)
            }
        }
        return listOfSets.size
    }

    private fun generateAdjMap(mutableID: MutableList<Domino>): MutableMap<Int,MutableList<Int>> {
        var newMap: MutableMap<Int,MutableList<Int>> = mutableMapOf()
        for (domino in mutableID) {
            if (domino.left !in newMap.keys) {
                newMap[domino.left] = mutableListOf(domino.right)
            } else {
                newMap[domino.left] = newMap[domino.left]?.plus(domino.right) as MutableList<Int>
            }
            if (domino.right !in newMap.keys) {
                newMap[domino.right] = mutableListOf(domino.left)
            } else {
                newMap[domino.right] = newMap[domino.right]?.plus(domino.left) as MutableList<Int>
            }
        }
        return newMap
    }

    private fun generateDegreeMap(mutableID: MutableList<Domino>): MutableMap<Int, Int> {
        var newMap: MutableMap<Int,Int> = mutableMapOf()
        for (domino in mutableID) {
            if (domino.left !in newMap.keys) {
                newMap[domino.left] = 1
            } else {
                newMap[domino.left] = newMap[domino.left]!!.plus(1)
            }
            if (domino.right !in newMap.keys) {
                newMap[domino.right] = 1
            } else {
                newMap[domino.right] = newMap[domino.right]!!.plus(1)
            }
        }
        return newMap
    }

    private fun solvable(degreeMap: MutableMap<Int, Int>, scc: Int): Boolean {
        return ((degreeMap.values.all { it % 2 == 0 }) && (scc == 1))
    }
}