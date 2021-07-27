class Deque<T> {

    data class Node<T>(var value: T?, var prev: Node<T>?,var next: Node<T>?)
    var head = Node<T>(null,null,null)
    var tail = Node<T>(null,null,null)

    // Insert at back
    fun push(value: T) {
        if (head.value != null) {
            var newNode = Node(value, null, head)
            head.prev = newNode
            head = newNode

        } else {
            var newNode = Node(value, null, null)
            head = newNode
            tail = newNode
        }
    }
    // Remove from back
    fun pop(): T? {
        var toReturn = head.value
        if (head.value != null) {
            if (head.next == null) {
                head.value = null
                tail.value = null
                head.prev = null
                tail.prev = null
                head.next = null
                tail.next = null
            } else {
                head = head.next!!
                head.prev = null
            }
        } else {
            println("Cannot pop from back, Linked-list is empty")
        }
        return toReturn
    }
    // Insert at front
    fun unshift(value: T) {
        if (tail.value != null) {
            var newNode = Node(value, tail, null)
            tail.next = newNode
            tail = newNode
        } else {
            var newNode = Node(value, null, null)
            head = newNode
            tail = newNode
        }
    }
    // Remove from front
    fun shift(): T? {
        var toReturn = tail.value
        if (tail.value != null) {
            if (tail.prev == null) {
                head.value = null
                tail.value = null
                tail.prev = null
                head.prev = null
                tail.next = null
                head.next = null
            } else {
                tail = tail.prev!!
                tail.next = null
            }
        } else {
            println("Cannot shift from front, Linked-list is empty")
        }
        return toReturn
    }
}