package implementation;

import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        String answer = "";
        int temp;
        int min, max;

        min = Integer.parseInt(st.nextToken());
        max = min;
        while(st.hasMoreTokens()) {
            temp = Integer.parseInt(st.nextToken());
            if(temp - min < 0) {
                min = temp;
            }
            if(temp - max > 0) {
                max = temp;
            }
        }

        answer = min + " " + max;

        return answer;
    }
}
