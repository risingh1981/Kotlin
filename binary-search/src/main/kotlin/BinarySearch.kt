object BinarySearch {
    // Returns index of item if item found. NoSuchElementException if element
    // not found and -1 if Error occured.
    fun search(list: List<Int>, item: Int): Int {
        var start = 0
        var end = list.lastIndex
        while(start <= end) {

            var mid = (start + end) / 2
            when {
                list[mid] == item -> return mid
                start == end -> throw NoSuchElementException("Item not found in list.")
                item > list[mid] -> start = mid + 1
                else -> end = mid
            }
        }
        return -1 // -1 means some Error occured.
    }
}