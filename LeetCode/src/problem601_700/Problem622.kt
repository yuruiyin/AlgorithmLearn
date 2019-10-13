package problem601_700

/**
    设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
    循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
    你的实现应该支持如下操作：

    MyCircularQueue(k): 构造器，设置队列长度为 k 。
    Front: 从队首获取元素。如果队列为空，返回 -1 。
    Rear: 获取队尾元素。如果队列为空，返回 -1 。
    enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    isEmpty(): 检查循环队列是否为空。
    isFull(): 检查循环队列是否已满。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/design-circular-queue
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Problem622(val k: Int) {

    enum class OperationType {
        ENQUEUE,
        DEQUEUE
    }

    private val items by lazy {
        Array(k, {0})
    }

    private var head = 0
    private var tail = -1

    private var lastOperation = OperationType.ENQUEUE

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            // 队列已满
            return false
        }

        tail = (++tail) % k
        items[tail] = value
        lastOperation = OperationType.ENQUEUE
        return true
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        }

        head = (++head) % k
        lastOperation = OperationType.DEQUEUE
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
        // 空和满的情况都是head指针在tail指针前面，但是会导致队列为空，只要可能上一次执行了出队操作
        return tail == -1 || ((tail - head + 1) % k == 0) && lastOperation == OperationType.DEQUEUE
    }

    /** Checks whether the circular queue is full or not. */
    fun isFull(): Boolean {
        // 空和满的情况都是head指针在tail指针前面，但是会导致队列为满，只要可能上一次执行了入队操作
        return tail != -1 && ((tail - head + 1) % k == 0) && lastOperation == OperationType.ENQUEUE
    }

}

fun main(args: Array<String>) {
    val circularQueue = Problem622_2(3)
    println(circularQueue.enQueue(1))
    println(circularQueue.enQueue(2))
    println(circularQueue.enQueue(3))
    println(circularQueue.enQueue(4))
    println(circularQueue.Rear())
    println(circularQueue.isFull())
    println(circularQueue.deQueue())
    println(circularQueue.enQueue(4))
    println(circularQueue.Rear())
    println(circularQueue.Front())
    println(circularQueue.isEmpty())
    println(circularQueue.deQueue())
    println(circularQueue.deQueue())
    println(circularQueue.deQueue())
    println(circularQueue.isEmpty())
    println(circularQueue.enQueue(1))
    println(circularQueue.enQueue(2))
    println(circularQueue.enQueue(3))
    println(circularQueue.enQueue(4))

}

