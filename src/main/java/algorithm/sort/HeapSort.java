package algorithm.sort;

public class HeapSort {

    public static void main(String[] args) {
        int n = (int) (Math.random() * 20);
        int[] arr = randomArray(n, 1000);
        heapSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        /*for (int i = 0; i < arr.length; i++) { // O(N)
            heapInsert(arr, i);  // O(logN)
        }*/

        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize); // 0位置上的数和堆上最后位置的数交换，交换完之后堆减减
        while (heapSize > 0) { //O(N)
            heapify(arr, 0, heapSize); //O（logN）堆的大小只要没减成0，周而复始，0位置的数往下heapify
            swap(arr, 0, --heapSize); //O(1) 然后又把0位置上的数跟堆最后位置的数做交换
        }
    }


    // 把数组变成大根堆，往上
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) { // 某个数不比父亲大了，就停了
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 往下heapify
    static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; // 左孩子下标
        while (left < heapSize) { // 下方还有孩子的时候
            // 两个孩子中，谁的值大，把下表给largest，left + 1就是右孩子的下标，left+1 -> index * 2 + 2
            // 右孩子如果有，并且右孩子的值大于左孩子的值，就返回右孩子下标，否则返回左孩子下标，就是谁的值更大，谁就返回给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父和孩子之间，谁的值大，把下标给largest，注意现在index是父节点
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) { // 说明父节点连同孩子在内是最大值，所以不用走了
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
}
