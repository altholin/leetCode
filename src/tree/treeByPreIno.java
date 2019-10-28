package tree;

import java.util.Arrays;

/**
 * Created by altho on 2019-10-28.
 */
public class treeByPreIno {
    public treeNode buildTree(int[] preoder,int[] inorder){
        treeNode root = new treeNode(preoder[0]);
        int num=0;
        for(int i =0; i<inorder.length; i++){
            if(inorder[i]==root.getVal()){
                num=i;
            }
        }
        int[] preLeft = Arrays.copyOfRange(preoder,0,num);
        int[] preRight = Arrays.copyOfRange(preoder,num+1,preoder.length);
        int[] inoLeft = Arrays.copyOfRange(inorder,0,num);
        int[] inoRight = Arrays.copyOfRange(inorder,num+1,inorder.length);
        root.setLeftChild(buildTree(preLeft,inoLeft));
        root.setRightChild(buildTree(preRight,inoRight));
        return root;
    }
}
