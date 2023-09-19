import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1260 {
    public static int N, M, V;
    public static boolean[][] arr;
    public static boolean[]visited;
    final static int max = 1000 + 10;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new boolean[max][max];
        visited = new boolean[max];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = true;
        }
        dfs(V);
    }
    public static void dfs(int idx){

        System.out.print(idx + " ");
        visited[idx] = true;
        for(int i = 1; i <= N; i++){
            if(!visited[i] && arr[idx][i]){
                dfs(i);
            }
        }
    }
}
