import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2606 {

    public static int N, M;
    public static boolean[][] arr;
    public static boolean[] visited;
    private final static int max = 100 + 10;
    public static int count;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new boolean[max][max];
        visited = new boolean[max];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = true;
        }
        count = 0;
        dfs(1);
        System.out.println(count);
    }
    public static void dfs(int v){
        visited[v] = true;
        for(int i = 1; i <= N; i++){
            if(!visited[i] && arr[v][i]){
                count++;
                dfs(i);
            }
        }
    }
}
