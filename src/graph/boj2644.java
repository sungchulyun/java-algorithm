package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2644 {
    static int N;
    static ArrayList<Integer>[] list;

    static int x, y;

    static int ans = -1;
    static boolean visited[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        dfs(x, 0);
        System.out.println(ans);

    }
    public static void dfs(int target, int depth){
        if(target == y){
            ans = depth;
            return;
        }

        visited[target] = true;
        for(int next : list[target]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, depth+1);
                visited[next] = false;
            }
        }
    }
}
