package implementation;

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean success;
        boolean[] impossible = new boolean[26];
        boolean[] impossible_copy;
        char[] next = new char[26];
        char a;
        String s;

        if(skill.length() >= 2) {
            for(int i = 1; i < skill.length(); ++i) {
                a = skill.charAt(i);
                impossible[a - 'A'] = true;
                next[skill.charAt(i - 1) - 'A'] = a;
            }
        }

        for(int i = 0; i < skill_trees.length; ++i) {
            s = skill_trees[i];

            impossible_copy = impossible.clone();
            success = true;
            for(int j = 0; j < s.length(); ++j) {
                a = s.charAt(j);
                if(impossible_copy[a - 'A']) {
                    success = false;
                    break;
                }
                else {
                    if(next[a - 'A'] - 'A' >= 0 && next[a - 'A'] - 'A' < 26) {
                        impossible_copy[next[a - 'A'] - 'A'] = false;
                    }
                }
            }
            if(success)
                ++answer;
        }

        return answer;
    }
}
