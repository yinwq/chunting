package com.yinwq.chunting.study.tree;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/7/12 19:25
 */
public class BST<T extends Comparable<T>> {
    private BSTNode<T> root;

    public BST() {
        this.root = null;
    }


    public BSTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BSTNode<T> root) {
        this.root = root;
    }

    //非递归实现插入节点
    public void non_insert(T data){
        // 1.判断如果root是null，如果root是null，直接生成根节点，让root指向，结束
        if(root == null){
            this.root = new BSTNode<>(data, null, null);
            return;
        }
        // 2.如果root不为空，从根节点开始搜索一个合适的位置
        BSTNode<T> cur = this.root;
        BSTNode<T> parent = null; // this.root
        while(cur != null){
            if(cur.getData().compareTo(data) > 0){
                parent = cur;
                cur = cur.getLeft();
            } else if(cur.getData().compareTo(data) < 0){
                parent = cur;
                cur = cur.getRight();
            } else {
                return;
            }
        }
        // 3.生成新节点，把节点的地址，写入父节点相应的地址域
        if(parent.getData().compareTo(data) > 0){
            parent.setLeft(new BSTNode<T>(data, null, null));
        } else {
            parent.setRight(new BSTNode<T>(data, null, null));
        }
    }

    //递归实现节点的插入
    public void insert(T data) {
        this.root = insert(root , data);
    }

    private BSTNode<T> insert(BSTNode<T> root, T data) {
        //找到位置
        if(root == null) {
            return new BSTNode<>(data,null,null);
        }
        if(data.compareTo(root.getData())<0) {
            //比当前节点小，往左走
            root.setLeft(insert(root.getLeft(),data));
        } else if (data.compareTo(root.getData())>0) {
            //比当前节点大，往右走
            root.setRight(insert(root.getRight(),data));
        }
        //回溯过程中重复设置节点，返回当前节点
        return root;
    }


    public void non_remove(T data) {
        // 1. 先搜索BST树，找到待删除的节点
        BSTNode<T> cur = root;
        BSTNode<T> parent = null;
        while (cur != null) {
            if(cur.getData().compareTo(data) < 0) {
                parent = cur;
                cur = cur.getRight();
            } else if(cur.getData().compareTo(data) > 0) {
                parent = cur;
                cur = cur.getLeft();
            } else {
                break;
            }
        }
        if(cur==null) {
            System.out.println("没找到");
            return;
        }
        // 2. 判断删除节点是否有两个孩子，如果有，用前驱的值代替，直接删除前驱
        if(cur.getLeft()!=null && cur.getRight()!=null) {
            BSTNode<T> old = cur;
            parent = cur;
            cur = cur.getLeft();
            while(cur.getRight()!=null) {
                parent = cur;
                cur = cur.getRight();
            }
            old.setData(cur.getData());
        }
        // 3. 删除有一个孩子的节点，或者没有孩子的节点（看作有一个孩子，孩子是null）
        BSTNode<T> child = cur.getLeft();
        if(child==null) {
            child=cur.getRight();
        }
        if(parent==null) {
            root = child;
        } else {
            if(parent.getLeft()==cur) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
    }


    public void remove(T data) {
        remove(root,data);
    }
    //将删除节点的孩子进行返回
    private BSTNode<T> remove(BSTNode<T> root, T data) {
        //没有找到数据为data的节点
        if(root == null) {
            return null;
        }
        if(root.getData().compareTo(data) < 0) {
            root.setRight(remove(root.getRight(),data));
        } else if (root.getData().compareTo(data) > 0) {
            root.setLeft(remove(root.getLeft(),data));
        } else {
            if(root.getLeft()!=null && root.getRight()!=null) {
                //有两个孩子，找前驱节点
                BSTNode<T> cur = root.getLeft();
                while(cur.getRight()!=null) {
                    cur = cur.getRight();
                }
                root.setData(cur.getData());
                //删除cur：前驱节点
                root.setLeft(remove(root.getLeft(),cur.getData()));
            } else {
                if(root.getLeft()!=null) {
                    return root.getLeft();
                } else if (root.getRight()!=null) {
                    return  root.getRight();
                } else {
                    return null;
                }
            }
        }
        return root;
    }


    public boolean non_query(T data){
        BSTNode<T> cur = this.root;
        while(cur != null){
            if(cur.getData().compareTo(data) > 0){
                cur = cur.getLeft();
            } else if(cur.getData().compareTo(data) < 0){
                cur = cur.getRight();
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean query(T data) {
        return query(this.root,data);
    }

    private boolean query(BSTNode<T> root, T data) {
        if(root == null) {
            return false;
        }
        if(root.getData().compareTo(data) == 0) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if(root.getData().compareTo(data) < 0) {
            left = query(root.getRight(),data);
        } else if(root.getData().compareTo(data) > 0) {
            right = query(root.getLeft(),data);
        }
        return left || right ;
    }


    public void preOrder() {
        System.out.print("前序遍历：");
        preOrder(root);
    }

    private void preOrder(BSTNode<T> node) {
        if(node!=null) {
            System.out.print(node.getData()+" ");
            inOrder(node.getLeft());
            inOrder(node.getRight());
        }
    }


    public void inOrder() {
        System.out.print("中序遍历：");
        inOrder(root);
    }

    private void inOrder(BSTNode<T> node) {
        if(node!=null) {
            inOrder(node.getLeft());
            System.out.print(node.getData()+" ");
            inOrder(node.getRight());
        }
    }


    public void postOrder() {
        System.out.print("后序遍历：");
        postOrder(root);
    }

    private void postOrder(BSTNode<T> node) {
        if(node!=null) {
            inOrder(node.getLeft());
            inOrder(node.getRight());
            System.out.print(node.getData()+" ");
        }
    }

    public int level() {
        return level(root);
    }

    private int level(BSTNode<T> node) {
        if(node != null) {
            int left = level(node.getLeft());
            int right = level(node.getRight());
            //当前节点的高度是左子树和右子树较大的高度加1
            return Math.max(left,right) + 1;
        }
        return 0;
    }


    public void levelOrder() {
        int hight = level();
        for (int i = 0; i < hight; i++) {
            levelOrder(root,i);
        }
    }

    private void levelOrder(BSTNode<T> node,int level) {
        if(node != null) {
            if(level==0) {
                System.out.print(node.getData()+" ");
            }
            levelOrder(node.getLeft(),level-1);
            levelOrder(node.getRight(),level-1);
        }
    }


    public int number() {
        return number(root);
    }

    private int number(BSTNode<T> node) {
        if(node!=null) {
            return number(node.getLeft())+number(node.getRight())+1;
        }
        return 0;
    }


}


