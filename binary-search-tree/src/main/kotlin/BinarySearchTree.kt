
class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, var left: Node<T>? = null, var right: Node<T>? = null, var parent:Node<T>? = null) {
        override fun toString(): String {
            return "Node: Val=${this.data}, Left=${left?.data}, Right=${right?.data}, Parent=${parent?.data}"
        }
    }


    var root: Node<T>? = null

    fun insert(value: T) {
        if (root == null) {
            root = Node<T>(value)
        } else {
            var current = root
            while (current != null) {
                if (value <= current.data)   {
                    if (current.left == null) {
                        current.left = Node<T>(value, parent = current)
                        current = null
                    } else {
                        current = current.left
                    }
                } else if (value >= current.data) {
                    if (current.right == null) {
                        current.right = Node<T>(value, parent = current)
                        current = null
                    } else {
                        current = current.right
                    }
                }
            }
        }
    }
    // Depth-First on BST gives sorted list.
    fun asSortedList(): List<T> {
        var sortedList: MutableList<T> = mutableListOf()
        var u = root
        var prev: Node<T>? = null
        var next:Node<T>?

        while (u != null) {
            if (prev == u.parent) {
                if (u.left != null) {
                    next = u.left
                } else if (u.right != null) {
                    next = u.right
                    sortedList.add(u.data)
                } else {
                    next = u.parent
                    sortedList.add(u.data)
                }
            } else if (prev == u.left) {
                sortedList.add(u.data)
                if (u.right != null) {
                    next = u.right
                } else {
                    next = u.parent
                }
            } else {
                next = u.parent
            }
            prev = u
            u = next
        }
        return sortedList
    }

    // Level Order is same as Breadth First(level by level top to bottom and left to right)
    // Algo: Use a Queue(or a MutableList, adding like regular and removing at idx 0.)
    // Add root of tree to Queue(Q)
    // While (Q.size > 0):
    //      u = Q[0]; delete Idx 0 of Q
    //      if u.left != null, add u.L to Q
    //      if u.right != null, add u.R to Q
    fun asLevelOrderList(): List<T> {
        var levelOrderList: MutableList<T> = mutableListOf()
        var queueQ: MutableList<Node<T>?> = mutableListOf()
        var u: Node<T>

        queueQ.add(root)

        while (queueQ.size > 0) {
            u = queueQ.removeAt(0)!!
            levelOrderList.add(u.data)
            if (u.left != null) { queueQ.add(u.left) }
            if (u.right != null) { queueQ.add(u.right) }
        }

        return levelOrderList
    }

}