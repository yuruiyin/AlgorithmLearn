/**
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Problem155 {

    private val items by lazy {
        arrayListOf<Int>()
    }

    // 从大到小
    private val sortedList by lazy {
        arrayListOf<Int>()
    }

    fun push(x: Int) {
        items.add(x)

        if (sortedList.isEmpty()) {
            sortedList.add(x)
            return
        }

        for ((index, value) in sortedList.withIndex()) {
            if (x > value) {
                sortedList.add(index, x)
                break
            }

            if (index == sortedList.size - 1) {
                // 要插入的是最小的元素，直接插到末尾即可
                sortedList.add(x)
                break
            }
        }
    }

    fun pop() {
        if (items.isEmpty()) {
            return
        }

        val topValue = items[items.size - 1]
        items.removeAt(items.size - 1)

        // 更新排序好的列表：删除被弹出的数
        sortedList.removeAt(sortedList.indexOf(topValue))
    }

    fun top(): Int {
        if (items.isEmpty()) {
            return -1
        }

        return items[items.size - 1]
    }

    fun getMin(): Int {
        if (sortedList.isEmpty()) {
            return -1
        }

        return sortedList[sortedList.size - 1]
    }

}

fun main(args: Array<String>) {
    val minStack = Problem155()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())
    minStack.pop()
    println(minStack.top())
    println(minStack.getMin())

}
