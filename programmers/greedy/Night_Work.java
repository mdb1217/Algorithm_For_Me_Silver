package greedy;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int temp;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < works.length; ++i) {
            pq.add(works[i]);
        }

        for(int i = 0; i < n; ++i) {
            temp = pq.poll();
            if(temp == 0)
                break;
            pq.add(temp - 1);
        }

        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}
