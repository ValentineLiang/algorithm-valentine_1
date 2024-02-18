package algorithm.sort;

public class SmallSum {
    public static void main(String[] args) {
        int[] arr = {45, 78, 989, 879, 5641, 44, 354, 68793, 67971, 68979};
        System.out.println(smallSum(arr));
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static int MAXN = 20;
    static int[] help = new int[MAXN];

    // 结果比较大，用int会溢出的，所以返回long类型
    // 特别注意溢出这个点，笔试常见坑
    // 返回arr[l...r]范围上，小和的累加和，同时请把arr[l..r]变有序
    // 时间复杂度O(n * logn)
    public static long smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
//        int mid = (l + r) / 2;
        int lSum = process(arr, l, mid); //左组求小和
        int rSum = process(arr, mid + 1, r); // 右组求小和
        int mSum = merge(arr, l, mid, r); // merge求小和
        int smallSum = lSum + rSum + mSum;
        return smallSum;
    }

    // 返回跨左右产生的小和累加和，左侧有序、右侧有序，让左右两侧整体有序
    // arr[l...m] arr[m+1...r]
    static int merge(int[] arr, int l, int m, int r) {

        //统计部分
        int result = 0;
        for (int j = m + 1, i = l, sum = 0; j <= r; j++) {  // 左右对比
            while (i <= m && arr[i] <= arr[j]) { // 左边比右边小，就累加
                sum += arr[i++];
            }
            result += sum;
        }

        // 正常merge
        int i = l;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) { //判断不越界
//            result += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0; // merge过程中产生小和的行为
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return result;
    }

}
