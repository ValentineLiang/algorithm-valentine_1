package algorithm.sort;

// 基数排序
public class RadixSort {
    static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) { // 得到最大值
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) { // 最大值除10，res++，最后表示这个最大值有多少个10进制位
            res++;
            max /= 10;
        }
        return res;
    }

    // arr[begin..end]排序 digit表示这一批数中，最大的值有几个十进制位
    static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10; // 以10为基底
        int i = 0, j = 0;
        int[] bucket = new int[R - L + 1];  // 有多少个数准备多少个辅助空间
        for (int d = 1; d <= digit; d++) { // 有多少位就进出几次
            /**
             * 10个空间
             * count[0] 当前位（d位）是0的数字有多少个
             * count[1] 当前位(d位) 是（0和1）的数字有多少个
             * count[2] 当前位(d位) 是（0、1、2）的数字有多少个
             * count[i] 当前位(d位) 是 (0~i)的数字有多少个
             */
            int[] count = new int[radix]; // count[0,9] count就准备10个空间，因为这个东西永远都是10
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d); // d如果是1就取出个位数字，d如果是2就取出十位数字，d如果是3就取出百位数字
                count[j]++;
            }
            for (i = 1; i < radix; i++) {  // count搞成前缀和
                count[i] = count[i] + count[i - 1];
            }
            // 出桶放到bucket辅助数组里面去
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d); // 数组从右往左遍历，每个数到了第几位，把那个位的数拿出来
                bucket[count[j] - 1] = arr[i]; // 根据count的值再减一，填到辅助数组里去
                count[j]--; // 当个的个位词频减减
            }
            for (i = L, j = 0; i <= R; i++, j++) { // 出桶搞到原来的数组里面去
                arr[i] = bucket[j];
            }
        }
    }

    static int getDigit(int x, int d) {
        return ((x / (int) (Math.pow(10, d - 1))) % 10);
    }

}
