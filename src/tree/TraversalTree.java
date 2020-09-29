package tree;

import java.util.ArrayList;
import java.util.List;

public class TraversalTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String args[]) {
        /**
         *              1
         *         2         3
         *     4    5     x     7
         *   x 9  10 11      14  x
         */
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t14 = new TreeNode(14);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t7;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        t7.left = t14;

        TreeNode curr = t1;
//        preorder(curr);
//        inorder(curr);
//        inorder(curr);
        getallpaths(curr);

        TreeNode bst1 = new TreeNode(10);
        TreeNode bst2 = new TreeNode(5);
        TreeNode bst3 = new TreeNode(15);
        TreeNode bst4 = new TreeNode(2);
        TreeNode bst5 = new TreeNode(7);
        TreeNode bst6 = new TreeNode(11);
        TreeNode bst7 = new TreeNode(19);
        TreeNode bst8 = new TreeNode(1);

        bst1.left = bst2;
        bst1.right = bst3;
        bst2.left = bst4;
        bst2.right = bst5;
        bst3.left = bst6;
        bst3.right = bst7;
        bst4.left = bst8;
//        inorder(bst1); //inorder in bst => sort data
//        preorder(bst1); //preorder in bst => dfs search
//        postorder(bst1); //
    }

    public static void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }

    public static void preorder(TreeNode root) {
        if(root != null) {
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }

    }

    public static void postorder(TreeNode root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.val);
        }
    }

    public static void getallpaths(TreeNode root) {
        List<List<Integer>> allpaths = new ArrayList<>();
        allpathsearch(root, allpaths, new ArrayList<>());

        for(List<Integer> allpath : allpaths) {
            allpath.forEach(path -> System.out.print(path + " "));
            System.out.println("");
        }
    }

    //모든 경로를 구하는 문제
    public static void allpathsearch(TreeNode root, List<List<Integer>> allpaths, List<Integer> paths) {
        paths.add(root.val);

        if(root.left == null && root.right == null) {
            System.out.println(root.val + "--------> no child!!");
            allpaths.add(new ArrayList<>(paths));
        }

        if(root.left != null) allpathsearch(root.left, allpaths, paths);
        if(root.right != null) allpathsearch(root.right, allpaths, paths);

        paths.remove(paths.size()-1);
    }
}
