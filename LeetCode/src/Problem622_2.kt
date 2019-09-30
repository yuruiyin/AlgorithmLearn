/**
 * 循环队列的第二种解法
 * 主要区别是这里维护了一个size变量来存在队列中已有元素的个数
 */
class Problem622_2(val k: Int) {

    private val items by lazy {
        Array(k, {0})
    }

    private var head = 0
    private var tail = -1
    private var size = 0

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            // 队列已满
            return false
        }

        tail = (++tail) % k
        items[tail] = value
        size++
        return true
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        }

        head = (++head) % k
        size--
        return true
    }

    /** Get the front item from the queue. */
    fun Front(): Int {
        return if (isEmpty()) {
            -1
        } else {
            items[head]
        }
    }

    /** Get the last item from the queue. */
    fun Rear(): Int {
        return if (isEmpty()) {
            -1
        } else {
            items[tail]
        }
    }

    /** Checks whether the circular queue is empty or not. */
    fun isEmpty(): Boolean {
        return size == 0
    }

    /** Checks whether the circular queue is full or not. */
    fun isFull(): Boolean {
        return size == k
    }

}