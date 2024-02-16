package algorithm;

// 异或例子
public class ExclusiveOr {

    public static void main(String[] args) {

    }

    // 一组数只有一个数出现奇数次，其他数出现偶数次，找出出现奇数次的数
    public static void oddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    // 一组数有2个数出现奇数次，其他数出现偶数次，找出出现奇数次的数
    public static void oddTimesNum2(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        //eor = a^b , eor != 0 , eor必然有一个位置上是1
        int rightOne = eor & (~eor + 1); //提取出最右的1，把某一个不等于0的数，最右侧的1提取出来，常规操作
        int onlyOne = 0; // eor'
        for (int cur : arr) {
            if ((cur & rightOne) == 0) { // 那个位置上等于0的才异或，或者等于1的才异或，两边取一边就行
                onlyOne ^= cur;   // 最后onlyOne是a或者b
            }
        }
        System.out.println(onlyOne + " other: " + (eor ^ onlyOne));  // 最后onlyOne异或上eor就行得出 a或者b
    }
}
