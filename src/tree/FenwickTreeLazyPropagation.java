package tree;

public class FenwickTreeLazyPropagation {

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

        System.out.print("before -> ");
        for(int i=1; i< 10; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println("");

        //test
        System.out.println("tree[2]+tree[3]+tree[4]+tree[5] -> " + sum(tree, 2,5));

        //lazy propagation
        //1-5 2씩 더함
        int start = 1;
        int end = 5;
        int add = 2;
        int addval = (end - start + 1) * add;
        update(tree, start, 2);
        update(tree, end+1, -2);

        System.out.print("after1 -> ");
        for(int i=1; i< 10; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println("");

        //https://jason9319.tistory.com/283
        //합연산이 log시간에 처리되며 query(i)는 기존 1~i까지의 합을 나타내는것이 아닌 i위치의 누적합을 출력하게 된다.
        //출처: https://jason9319.tistory.com/283 [ACM-ICPC 상 탈 사람]
        System.out.println(sum(tree, 1)); //3
        System.out.println(sum(tree, 2)); //5
        System.out.println(sum(tree, 3)); //8
        System.out.println(sum(tree, 4)); //12
        System.out.println(sum(tree, 5)); //17
        System.out.println(sum(tree, 6)); //21
        System.out.println(sum(tree, 7)); //28
        System.out.println(sum(tree, 8)); //36
        System.out.println(sum(tree, 9)); //45
        //2부터 5까지의 합을 구하지는 못함
    }
}
