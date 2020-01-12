package queue

/**
 * 基于数组实现的队列
 */
class ArrayQueue(private val capacity: Int) {

    private val items by lazy {
        arrayOfNulls<String>(capacity)
    }

    private var head = 0
    private var tail = 0

    /**
     * 入队
     */
    fun enqueue(item: String): Boolean {
        if (tail == capacity) {
            if (head == 0) {
                // 真的满了
                return false
            }

            // 整体左移
            for (i in head until tail) {
                items[i - head] = items[i]
            }

            tail -= head
            head = 0
        }

        items[tail] = item
        tail++
        return true
    }

    /**
     * 出队
     */
    fun dequeue(): String? {
        if (head == tail) {
            // 队已空
            return null
        }

        val item = items[head]
        head++
        return item
    }

}

fun main(args: Array<String>) {
    val arrayQueue = ArrayQueue(5)
    arrayQueue.enqueue("1")
    arrayQueue.enqueue("2")
    arrayQueue.enqueue("3")
    arrayQueue.enqueue("4")
    arrayQueue.enqueue("5")
    arrayQueue.dequeue()
    arrayQueue.enqueue("6")

    println(arrayQueue.dequeue())
    println(arrayQueue.dequeue())
    println(arrayQueue.dequeue())
    println(arrayQueue.dequeue())
    println(arrayQueue.dequeue())
    println(arrayQueue.dequeue())

}
