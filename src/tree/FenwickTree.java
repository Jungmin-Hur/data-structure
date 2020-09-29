package tree;

public class FenwickTree {

    static void update(int[] tree, int i, int diff) {
        while(i < tree.length) {
            tree[i] += diff;
            i += (i & -i);
        }
    }

    static long sum(int[] tree, int i) {
        long ans = 0;
        while(i > 0) {
            ans += tree[i];
            i -= (i & -i);
        }
        return ans;
    }

    static long sum(int[] tree, int start, int end) {
        return sum(tree, end) - sum(tree, start-1);
    }

    public static void main(String args[]) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9}; //original data array
        int[] tree = new int[10]; //fenwick tree

        //초기화 : tree는 1부터 index시작
        for(int i=1; i < 10; i++) {
            update(tree, i, arr[i]);
        }

        //5번항목을 10으로 업데이트
        int val = 10;
        arr[5] = val;
        int diff = val - arr[5];
        update(tree, 5, diff); //5번을 10으로 업데이트

        System.out.println("tree[2]+tree[3] -> " + sum(tree, 2,3));
        System.out.println("tree[2]+tree[3]+tree[4] -> " + sum(tree, 2,4));
        System.out.println("tree[2]+tree[3]+tree[4]+tree[5] -> " + sum(tree, 2,5));
    }
}
