package com.zx.leetcode._58;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] cArr = s.toCharArray();
        int len = 0;
        boolean inSpace = false;
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == ' ') {
                inSpace = true;
            } else {
                if (inSpace) {
                    inSpace = false;
                    len = 0;
                }
                len++;
            }
        }
        return len;
    }
}
