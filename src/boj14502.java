import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14502 {

    public static int N, M;
    public static int[] mx = {-1, 1, 0, 0};
    public static int[] my = {0, 0, -1, 1};

    public static int[][] map;
    public static int[][] virusMap;

    public static int max = Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int wall){
        if(wall == 3){
            bfs();
            return;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        virusMap = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                virusMap[i][j] = map[i][j];
                if(virusMap[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }

        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i= 0 ; i < 4; i++){
                int nx = temp[0] + mx[i];
                int ny = temp[1] + my[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && virusMap[nx][ny] == 0){
                    virusMap[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(virusMap[i][j] == 0){
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }
}
