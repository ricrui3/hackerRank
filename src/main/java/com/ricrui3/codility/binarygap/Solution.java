package com.ricrui3.codility.binarygap;

public class Solution {
    public int solution(int N) {
        char[] binaryString = Integer.toBinaryString(N).toCharArray();
        int maxGap = 0;
        int currentGap = 0;
        for (char bit : binaryString) {
            if (bit == '1'){
                if(currentGap > maxGap){
                    maxGap = currentGap;
                }
                currentGap = 0;
            } else {
                currentGap++;
            }
        }
        return maxGap;
    }
}
