package backtracking;

class Solution {
    static int arrow;
    static int max = 0;
    static int[] temp;
    static int[] answer;
    public int[] solution(int n, int[] info) {
        temp = new int[info.length];
        int[] lose = {-1};
        int apeach = 0;
        arrow = n;

        for(int i = 0; i < 10; ++i) {
            if(info[i] > 0)
                apeach += 10 - i;
        }

        back(n, 0, apeach, 0, info);

        return max == 0? lose : answer;
    }

    static void back(int remain, int sum, int e_sum, int d, int[] info) {
        int temp_sum = sum;
        int temp_e_sum = e_sum;
        if(remain == 0) {
            if(sum - e_sum > max) {
                max = sum - e_sum;
                answer = new int[11];
                for(int i = 0; i < d; ++i)
                    answer[10 - i] = temp[10 - i];
            }
            return;
        }
        if(d == 11) {
            if(sum - e_sum > max) {
                max = sum - e_sum;
                answer = new int[11];
                for(int i = 0; i < d; ++i)
                    answer[i] = temp[i];
            }
            return;
        }
        for(int i = remain; i >= 0; --i) {
            temp[10 - d] = i;
            if(i > info[10 - d]) {
                temp_sum += d;
                if(info[10 - d] > 0) {
                    temp_e_sum -= d;
                    back(remain - i, temp_sum, temp_e_sum, d + 1, info);
                    temp_e_sum += d;
                }
                else {
                    back(remain - i, temp_sum, temp_e_sum, d + 1, info);
                }
                temp_sum -= d;
            }
            else {
                back(remain - i, temp_sum, temp_e_sum, d + 1, info);
            }
            temp[10 - d] = 0;
        }
    }
}
