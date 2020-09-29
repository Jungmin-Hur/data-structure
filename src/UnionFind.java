public class UnionFind {

    static int find(int[] arr, int i) {
        if(arr[i] == i) return i;
        return arr[i] = find(arr, arr[i]); //path 압축
    }

    static void union(int[] arr, int a, int b) {
        int aRoot = find(arr, a);
        int bRoot = find(arr, b);

        if(aRoot > bRoot) {
            arr[aRoot] = bRoot;
        } else if(aRoot < bRoot) {
            arr[bRoot] = aRoot;
        }
    }

    static boolean isSameRoot(int[]arr, int a, int b) {
        int aRoot = find(arr, a);
        int bRoot = find(arr, b);
        return aRoot == bRoot;
    }

    public static void main(String args[]) {
        int[] arr = new int[11];
        for(int i=1; i<=10; i++) {
            arr[i] = i; //index로 값을 초기화 시켜줌
        }

        //test
        union(arr, 6, 5);
        union(arr, 2, 3);
        union(arr, 2, 5);
        union(arr, 3, 2);
        union(arr, 2, 3);
        union(arr, 1, 8);
        union(arr, 8, 9);
        union(arr, 2, 7);

        for(int i=1; i<=10; i++) {
            System.out.println(i + "--> " + find(arr, i));
        }
    }
}
