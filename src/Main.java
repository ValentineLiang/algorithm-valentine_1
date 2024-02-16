public class Main {
    public static void main(String[] args) {
//        int N = 200; // 随机数组最大长度
//        int V = 1000; // 随机数组每个值，在1~V之间等概率随机
//        int testTimes = 50000; // 测试次数
//        for (int i = 0; i < testTimes; i++) {
//            // 随机得到一个长度，长度在[0~N-1]
//            int n = (int) (Math.random() * N);
//            // 得到随机数组
//            int[] arr = randomArray(n, V);
//            int[] arr1 = copyArray(arr);
//            int[] arr2 = copyArray(arr);
//            int[] arr3 = copyArray(arr);
//
//            SelectBubbleInsert.insertionSort(arr1);
//            SelectBubbleInsert.bubbleSort(arr2);
//            SelectBubbleInsert.insertionSort(arr3);
//
//            if (!sameArray(arr1, arr2) || !sameArray(arr1, arr3)) {
//                System.out.println("出错了!");
//            }
//        }
        int n = (int) (Math.random() * 20);
        int[] arr = randomArray(n, 1000);
       /* int[] arr4 = copyArray(arr);
        Merge.process(arr4, 0, arr4.length - 1);
        for (int a : arr4) {
            System.out.println(a);
        }*/
        int[] arr5 = copyArray(arr);
//        Code01_SmallSum.smallSum(arr5);
        for (int a : arr5) {
            System.out.println(a);
        }
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] copyArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // Math.random() -> double -> [0,1)范围山的一个小数，0.37463473126、0.001231231，等概率！
            // Math.random() * v -> double -> [0,v)一个小数，依然等概率
            // (int)(Math.random() * v) -> int -> 0 1 2 3 ... v-1，等概率的！
            // (int) (Math.random() * v) + 1 -> int -> 1 2 3 .... v，等概率的！
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

    public static boolean sameArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}