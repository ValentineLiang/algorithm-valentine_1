package algorithm.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {45, 78, 989, 879, 5641, 44, 354, 683, 971, 979};
        quickSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // 因为有随机行为，时间复杂度就是O(NlogN)
    static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R); // 等概率随机选一个位置，跟右边的数做交换
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1); // <区
            quickSort(arr,p[1] + 1,  R); // >区
        }
    }

    // 处理arr[l...r]的方法，默认以arr[r]做划分, arr[r] -> p   <p  ==p  >p
    // 返回等于区域(左边界，右边界)，所以返回一个长度为2的数组res,res[0] res[1]
    static int[] partition(int[] arr, int L, int R) {
        int less = L - 1; // <区右边界
        int more = R; // >区左边界
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
