package com.mygaienko.common.algorithms.leetcode.minimum_window_substring;

import java.util.HashMap;

class SolutionV2 {

    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }

        HashMap<Character, Integer> map = initCharCounters(t);

        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;

        for(int right = 0; right < s.length(); right++){
            char currentRightChar = s.charAt(right);

            if(map.containsKey(currentRightChar)){
                map.compute(currentRightChar, (k, v) -> --v);
                if(map.get(currentRightChar) >= 0){
                    count ++;
                }

                while(count == t.length()){

                    int currentLen = right - left + 1;
                    if(currentLen < minLen){
                        minLeft = left;
                        minLen = currentLen;
                    }

                    char leftCurrentChar = s.charAt(left);
                    if(map.containsKey(leftCurrentChar)){
                        Integer computed = map.compute(leftCurrentChar, (k, v) -> ++v);
                        if(computed > 0){
                            count --;
                        }
                    }
                    left ++ ;
                }
            }
        }

        if(minLen>s.length())
        {
            return "";
        }

        return s.substring(minLeft,minLeft+minLen);
    }

    private HashMap<Character, Integer> initCharCounters(String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        return map;
    }

}
