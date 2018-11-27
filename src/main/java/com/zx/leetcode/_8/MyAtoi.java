package com.zx.leetcode._8;

public class MyAtoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean negative = false;
        char[] arr = str.toCharArray();
        int begin = 0;
        while (begin < arr.length && arr[begin] == ' ') {
            begin++;
        }
        if (begin >= arr.length) {
            return 0;
        }
        if (arr[begin] == '-') {
            negative = true;
            begin += 1;
        } else if (arr[begin] == '+') {
            negative = false;
            begin += 1;
        }
        long result = 0;
        while (begin < arr.length && arr[begin] >= '0' && arr[begin] <= '9') {
            int num = arr[begin] - '0';
            result = result * 10 + num;
            if (negative && result * -1 <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (!negative && result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            begin++;
        }
        return (int) (negative ? result * -1 : result);
    }

    public static void main(String[] args) {
//        System.out.println(new MyAtoi().myAtoi("   -42"));
        System.out.println(new MyAtoi().myAtoi("2147483800"));
        //2147483647
        //2147483800

        //-2147483648

        //-538412641
        //-91283472332

        System.out.println(Integer.MIN_VALUE);

    }
}
