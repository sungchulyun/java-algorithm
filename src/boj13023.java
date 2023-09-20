import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj13023 {
    public static boolean status;
    public static int N, M;
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for(int i = 0; i < N; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        status = false;
        for(int i = 0;   i < N; i++){
            visited = new boolean[N];
            dfs(i, 1);
            if(status){
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
    public static void dfs(int idx, int depth){
        if(depth == 5){
            status = true;
            return;
        }
        visited[idx] = true;
        for(int next : list[idx]){
            if(!visited[next])
                dfs(next, depth+1);
        }
        visited[idx] = false;
    }
}
