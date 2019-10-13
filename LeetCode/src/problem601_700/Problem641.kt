package problem601_700

/**
    设计实现双端队列。
    你的实现需要支持以下操作：

    MyCircularDeque(k)：构造函数,双端队列的大小为k。
    insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
    insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
    deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
    deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
    getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
    getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
    isEmpty()：检查双端队列是否为空。
    isFull()：检查双端队列是否满了。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/design-circular-deque
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Problem641(val k: Int) {

    private val items by lazy {
        Array(k, {0})
    }

    private var head = 0
    private var tail = -1
    private var size = 0

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    fun insertFront(value: Int): Boolean {
        if (isFull()) {
            return false
        }

        head = (head + k - 1) % k
        items[head] = value
        size++
        if (size == 1 && tail == -1) {
            tail = head
        }
        return true
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    fun insertLast(value: Int): Boolean {
        if (isFull()) {
            return false
        }

        tail = (++tail) % k
        items[tail] = value
        size++
        return true
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    fun deleteFront(): Boolean {
        if (isEmpty()) {
            return false
        }

        head = (++head) % k
        size--
        return true
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    fun deleteLast(): Boolean {
        if (isEmpty()) {
            return false
        }

        tail = (tail + k - 1) % k
        size--
        return true
    }

    private fun getItem(index: Int): Int {
        return if (isEmpty()) {
            -1
        } else {
            items[index]
        }
    }

    /** Get the front item from the deque. */
    fun getFront(): Int {
        return getItem(head)
    }

    /** Get the last item from the deque. */
    fun getRear(): Int {
        return getItem(tail)
    }

    /** Checks whether the circular deque is empty or not. */
    fun isEmpty(): Boolean = size == 0

    /** Checks whether the circular deque is full or not. */
    fun isFull(): Boolean = size == k

}

fun main(args: Array<String>) {
    val circularDeque = Problem641(3)
    println(circularDeque.insertFront(9))
    println(circularDeque.getRear())
    println(circularDeque.insertFront(9))
    println(circularDeque.getRear())
    println(circularDeque.insertLast(5))
    println(circularDeque.getFront())
    println(circularDeque.getRear())
    println(circularDeque.getFront())
    println(circularDeque.insertLast(8))
    println(circularDeque.deleteLast())
    println(circularDeque.getFront())


}
