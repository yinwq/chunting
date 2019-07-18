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
        bst.insert(8);
        BSTNode node = bst.getRoot();
        System.err.println(node.getData());
        while (node != null){
            if(node.getLeft() != null){
                System.err.print(node.getLeft().getData());
            }
            if(node.getRight() != null){
                System.err.println(node.getRight().getData());
            }
            node = node.getRight();
        }
        System.err.println("====" + JSON.toJSONString(bst));
    }
}
