package dp;

import java.util.*;

class Solution {
    static int a, b;
    static boolean[][] map;
    static int[][] route;
    public int solution(int m, int n, int[][] puddles) {
        a = m;
        b = n;
        map = new boolean[m][n];
        route = new int[m][n];

        for(int i = 0; i < puddles.length; ++i)
            map[puddles[i][0] - 1][puddles[i][1] - 1] = true;

        return sol(m - 1, n - 1);
    }

    static int sol(int x, int y) {
        if(x == 0 && y == 0)
            return 1;
        if(map[x][y])
            return 0;
        if(route[x][y] > 0)
            return route[x][y];
        if(y == 0)
            return route[x][y] = sol(x - 1, y) % 1000000007;
        if(x == 0)
            return route[x][y] = sol(x, y - 1) % 1000000007;
        return route[x][y] = (sol(x - 1, y) + sol(x, y - 1)) % 1000000007;
    }
}
