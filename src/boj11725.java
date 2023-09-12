import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11725 {
    public static int N, M;
    public static ArrayList<Integer>[] list;
    public static int ans = 0;
    public static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list =  new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        for(int i = 0; i < N; i++){
            if(ans == 0)
                dfs(i, 1);
        }

        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int depth){
        //System.out.println(start + " " + depth);
        if(depth == 5){
            ans = 1;
            return;
        }

        visited[start] = true;
        for(int i : list[start]){
            int next = i;
            if(!visited[next]){
                dfs(i, next+1);
            }
        }
        visited[start] = false;
    }
}
