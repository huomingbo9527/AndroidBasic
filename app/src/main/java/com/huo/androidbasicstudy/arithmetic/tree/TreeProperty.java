package com.huo.androidbasicstudy.arithmetic.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeProperty {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    };

    /**
     * 获取tree的最大深度
     * @param node
     * @return
     */
    public static int getMaxDeep(TreeNode node){
        if (node == null)
            return 0;
        int left = getMaxDeep(node.left);
        int right = getMaxDeep(node.right);
        return 1 + Math.max(left,right);
    }

    /**
     * 获取树的最大广度
     * @param node
     * @return
     */
    public static int getMaxWidth(TreeNode node){
        if (node == null)
            return 0;
        int maxWidth = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (true){//遍历每一层
            int size = queue.size();
            if (size == 0)
                break;
            while (size > 0){//遍历每一层里面的元素
                size --;
                TreeNode poll = queue.poll();
                TreeNode left = poll.left;
                if (left != null){
                    queue.add(left);//下一层节点入队
                }
                TreeNode right = poll.right;
                if (right != null){
                    queue.add(right);//下一层节点入队
                }
            }
            maxWidth = Math.max(maxWidth,queue.size());
        }
        return maxWidth;
    }


}
