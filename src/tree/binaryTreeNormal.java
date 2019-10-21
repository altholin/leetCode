package tree;

/**
 * @Author: Li Wanfang
 * @Date: 2019/10/21 16:02
 */
public class binaryTreeNormal {
    private treeNode root;

    public binaryTreeNormal(int[] arr){
        this.root=new treeNode(arr[0]);
        for(int i=1;i<arr.length;i++){
            buildTree(root,arr[i]);
        }

    }

    public void buildTree(treeNode root,int leaf){
        if(leaf>root.getVal()){
            if(root.getRightChild()==null){
                root.setRightChild(new treeNode(leaf));
            }else {
                buildTree(root.getRightChild(),leaf);
            }
        }else {
            if(root.getLeftChild()==null){
                root.setLeftChild(new treeNode(leaf));
            }else {
                buildTree(root.getLeftChild(),leaf);
            }
        }

    }


    public static void inOrder1(treeNode root){
        if(root.getLeftChild()!=null){
            inOrder1(root.getLeftChild());
        }
        System.out.println(root.getVal());
        if(root.getRightChild()!=null){
            inOrder1(root.getRightChild());
        }
    }


    public static void inOrder(treeNode node){
        if(node != null){
            inOrder(node.getLeftChild());
            System.out.println(node.getVal());
            inOrder(node.getRightChild());
        }
    }


    public static void main(String[] args) {
        int[] array = {2,4,12,45,21,6,111};
        binaryTreeNormal tree = new binaryTreeNormal(array);
        inOrder1(tree.root);

    }
}
