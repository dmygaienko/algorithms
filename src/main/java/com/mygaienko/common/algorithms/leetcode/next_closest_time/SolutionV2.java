package com.mygaienko.common.algorithms.leetcode.next_closest_time;

class SolutionV2 {
    
    public String nextClosestTime(String time) {
        char[] timeArray = time.toCharArray();

        int rest = 0;
        int intDigit;
        for (int i = timeArray.length - 1; i > 0; i--) {

            if (i > 2) {
                char digit = timeArray[i];
                intDigit = toInt(digit);

                if (i == 4 && intDigit > 4) {
                    intDigit = (intDigit + 5) % 10;
                    rest = 1;
                } else if (i == 3 && intDigit == 5 && rest == 1) {
                    intDigit = 0;
                    rest = 1;
                } else if (i == 4){
                    intDigit = intDigit + 5;
                } else if (i == 3 && rest != 0) {
                    intDigit = intDigit + rest;
                }

                timeArray[i] = toChar(intDigit);

            } else if (i==1 && rest != 0){
                intDigit = toInt(timeArray[0])*10 + toInt(timeArray[1]);
                if (intDigit == 23) {
                    intDigit = 0;
                } else {
                    intDigit += rest;
                }

                timeArray[0] = toChar(intDigit / 10);
                timeArray[1] = toChar(intDigit % 10);
            }
        }

        return String.valueOf(timeArray);
    }

    private char toChar(int intDigit) {
        return (char) (intDigit + '0');
    }

    private int toInt(char digit) {
        return digit - '0';
    }
}
