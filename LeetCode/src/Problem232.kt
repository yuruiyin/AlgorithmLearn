import java.util.*

/**
    使用栈实现队列的下列操作：

    push(x) -- 将一个元素放入队列的尾部。
    pop() -- 从队列首部移除元素。
    peek() -- 返回队列首部的元素。
    empty() -- 返回队列是否为空。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Problem232 {

    // 专门用来往队列尾部添加元素的栈
    private val pushStack = Stack<Int>()
    // 专门用来删除队列首部的栈
    private val popStack = Stack<Int>()


    /** Push element x to the back of queue. */
    fun push(x: Int) {
        pushStack.add(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        // 先将pushStack中的元素全部pop到popStack中
        // 然后popStack执行pop操作，移除栈顶元素
        // 最后将popStack的元素在全部pop到pushStack中
        while (pushStack.isNotEmpty()) {
            popStack.push(pushStack.pop())
        }

        val popedValue = popStack.pop()

        while (popStack.isNotEmpty()) {
            pushStack.push(popStack.pop())
        }

        return popedValue
    }

    /** Get the front element. */
    fun peek(): Int {
        // 算法类似pop操作
        while (pushStack.isNotEmpty()) {
            popStack.push(pushStack.pop())
        }

        val popedValue = popStack.peek()

        while (popStack.isNotEmpty()) {
            pushStack.push(popStack.pop())
        }

        return popedValue
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return pushStack.isEmpty()
    }

}

fun main(args: Array<String>) {
    val queue = Problem232()
    queue.push(1)
    queue.push(2)
    println(queue.peek())  // 返回 1
    println(queue.pop())   // 返回 1
    println(queue.empty()) // 返回 false

}
