package algorithm.sort;

// 归并排序O(NlogN)
public class MergeSort {
    public static void main(String[] args) {

    }

    public static void process(int[] arr, int L, int R) {
        if (L == R || arr.length == R) {
            System.out.println("条件输入不对");
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++]; // 哪个数小，就拷贝到help的i位置上去
        }
        // 这两个while只会中一个，从上面下来，只会出现一个越界一个不越界
        while (p1 <= M) {
            help[i++] = arr[p1++]; // 如果p1没越界，就把p1剩下的东西拷贝到help上去
        }
        while (p2 <= R) {
            help[i++] = arr[p2++]; // 如果p2没越界，就把p2剩下的东西拷贝到help上去
        }
        // 把help的东西拷贝回arr
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
