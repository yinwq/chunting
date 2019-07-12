package com.yinwq.chunting.study.tree;

import com.alibaba.fastjson.JSON;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/7/12 19:30
 */
public class Test {

    public static void main(String[] args) {

        BST bst = new BST();
        bst.insert(10);
        bst.insert(13);
        bst.insert(9);
        bst.insert(11);
        bst.insert(14);
        bst.insert(15);
        bst.insert(16);
        BSTNode parent = bst.getRoot().getRight();
        while (parent != null){
            System.err.println(bst.getRoot().getData());
            System.err.print(bst.getRoot().getLeft());
            System.err.println(bst.getRoot().getRight());
            parent = bst.getRoot().getRight();
        }
        System.err.println("====" + JSON.toJSONString(bst));
    }
}
