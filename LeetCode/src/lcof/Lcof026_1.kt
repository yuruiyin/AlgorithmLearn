package lcof

import common.TreeNode
import java.util.ArrayList

class Lcof026_1 {

    private fun recursive(root: TreeNode?, value: Int, list: MutableList<TreeNode>) {
        if (root == null) {
            return
        }

        if (root.`val` == value) {
            list.add(root)
        }

        recursive(root.left, value, list)
        recursive(root.right, value, list)
    }

    private fun isMatch(rootB: TreeNode?, nodeA: TreeNode?): Boolean {
        if (rootB == null) {
            return true
        }

        if (nodeA == null) {
            return false
        }

        return rootB.`val` == nodeA.`val` && isMatch(rootB.left, nodeA.left) && isMatch(rootB.right, nodeA.right)
    }

    fun isSubStructure(rootA: TreeNode?, rootB: TreeNode? = null): Boolean {
        if (rootA == null || rootB == null) {
            return false
        }

        val rootBVal = rootB.`val`
        val firstNodeList = ArrayList<TreeNode>()
        recursive(rootA, rootBVal, firstNodeList)

        for (node in firstNodeList) {
            val isFound = isMatch(rootB, node)
            if (isFound) {
                return true
            }
        }

        return false
    }

}