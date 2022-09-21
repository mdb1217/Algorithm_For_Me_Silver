package union_found;

class Solution {

    static int parent[];
    public int solution(int n, int[][] computers) {
        int answer = n;
        int start;
        int end;
        parent = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
        }

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(computers[i][j] == 1) {
                    start = find(i + 1);
                    end = find(j + 1);
                    if (start == end)
                        continue;
                    union(start, end);
                    answer -= 1;
                }
            }
        }

        return answer;
    }

    static int find(int node) {
        if(node == parent[node])
            return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }

    static void union(int start, int end) {
        parent[end] = start;
    }
}
