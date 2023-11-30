package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697 {
    static int N, K;
    static int ans = 0;
    static int[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[1000001];

        int ans = bfs(N);
        System.out.println(ans);

    }
    public static int bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        int index = node;
        q.add(index);
        visited[index] = 1;

        while(!q.isEmpty()){
            int n = q.poll();
            if(n == K){
                return visited[n] -1;
            }

            if(n-1 >= 0 && visited[n-1] == 0){
                q.add(n-1);
                visited[n-1] = visited[n] + 1;
            }
            if(n+1 <= 100000 && visited[n+1] == 0){
                q.add(n+1);
                visited[n+1] = visited[n] + 1;
            }
            if(n * 2 <= 100000 && visited[2*n] == 0){
                q.add(2*n);
                visited[2*n] = visited[n] + 1;
            }
        }
        return -1;
    }
}
