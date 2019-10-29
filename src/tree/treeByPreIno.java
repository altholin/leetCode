package tree;

import java.util.Arrays;

/**
 * Created by altho on 2019-10-28.
 */
public class treeByPreIno {
    public treeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length > 0 && inorder.length > 0) {
            treeNode root = new treeNode(preorder[0]);
            int num = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == root.getVal()) {
                    num = i;
                }
            }
            //构造左子树
            int[] preLeft = Arrays.copyOfRange(preorder, 1, num+1);
            int[] inoLeft = Arrays.copyOfRange(inorder, 0, num);
            root.setLeftChild(buildTree(preLeft, inoLeft));
            //构造右子树
            int[] preRight = Arrays.copyOfRange(preorder, num + 1, preorder.length);
            int[] inoRight = Arrays.copyOfRange(inorder, num + 1, inorder.length);
            root.setRightChild(buildTree(preRight, inoRight));

            return root;
        } else {
            return null;
        }

    }
}
