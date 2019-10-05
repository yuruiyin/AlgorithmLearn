package interview_bytedance.round01

class Problem02 {

    inner class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private val obtainRootMap = hashMapOf<TreeNode?, Int>()
    private val notObtainRootMap = hashMapOf<TreeNode?, Int>()

    private fun calcMaxValue(root: TreeNode?, isObtainRoot: Boolean = false): Int {
        if (root == null) {
            return 0
        }

        if (root.left == null && root.right == null) {
            return if (isObtainRoot) {
                root.`val`
            } else {
                0
            }
        }

        return if (isObtainRoot) {
            val left: Int = if (notObtainRootMap.containsKey(root.left)) {
                notObtainRootMap[root.left] ?: 0
            } else {
                calcMaxValue(root.left, false)
            }
            val right: Int = if (notObtainRootMap.containsKey(root.right)) {
                notObtainRootMap[root.right] ?: 0
            } else {
                calcMaxValue(root.right, false)
            }
            root.`val` + left + right
        } else {
            val leftTrue: Int = if (obtainRootMap.containsKey(root.left)) {
                obtainRootMap[root.left] ?: 0
            } else {
                calcMaxValue(root.left, true)
            }
            val leftFalse: Int = if (notObtainRootMap.containsKey(root.left)) {
                notObtainRootMap[root.left] ?: 0
            } else {
                calcMaxValue(root.left, false)
            }
            val rightTrue: Int = if (obtainRootMap.containsKey(root.right)) {
                obtainRootMap[root.right] ?: 0
            } else {
                calcMaxValue(root.right, true)
            }
            val rightFalse: Int = if (notObtainRootMap.containsKey(root.right)) {
                notObtainRootMap[root.right] ?: 0
            } else {
                calcMaxValue(root.right, false)
            }
            val valueList = mutableListOf(
                    leftTrue + rightTrue,
                    leftTrue + rightFalse,
                    leftFalse + rightTrue,
                    leftFalse + rightFalse
            )
            valueList.max()!!
        }
    }

    fun rob(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        obtainRootMap.clear()
        notObtainRootMap.clear()

        return Math.max(calcMaxValue(root, true), calcMaxValue(root, false))
    }
}

fun main(args: Array<String>) {
    val treeNode = Problem02().TreeNode(3)
    treeNode.left = Problem02().TreeNode(2)
    treeNode.right = Problem02().TreeNode(3)
    treeNode.left?.right = Problem02().TreeNode(3)
    treeNode.right?.right = Problem02().TreeNode(1)
    println(Problem02().rob(treeNode))

    val treeNode1 = Problem02().TreeNode(3)
    treeNode1.left = Problem02().TreeNode(4)
    treeNode1.right = Problem02().TreeNode(5)
    treeNode1.left?.left = Problem02().TreeNode(1)
    treeNode1.left?.right = Problem02().TreeNode(3)
    treeNode1.right?.right = Problem02().TreeNode(1)
    println(Problem02().rob(treeNode1))

    val treeNode2 = Problem02().TreeNode(4)
    treeNode2.left = Problem02().TreeNode(1)
    treeNode2.left?.left = Problem02().TreeNode(2)
    treeNode2.left?.left?.left = Problem02().TreeNode(3)
    println(Problem02().rob(treeNode2))
}
