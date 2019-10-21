package tree;

/**
 * @Author: Li Wanfang
 * @Date: 2019/10/21 16:22
 */
public class treeNode {
    private int val;
    private treeNode leftChild;
    private treeNode rightChild;

    public treeNode(){
        this.val=0;
        this.leftChild=null;
        this.rightChild=null;
    }
    public treeNode(int val){
        this.val=val;
        this.leftChild=null;
        this.rightChild=null;;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public treeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(treeNode leftChild) {
        this.leftChild = leftChild;
    }

    public treeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(treeNode rightChild) {
        this.rightChild = rightChild;
    }

}
