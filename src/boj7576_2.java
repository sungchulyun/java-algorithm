import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576_2 {

    static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};

    public static int[][] arr;

    public static Queue<Spot> q;

    public static int max = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N  = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    q.add(new Spot(i, j));
                }
            }
        }
       System.out.println(bfs());
    }

    public static int bfs(){

        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(arr[nx][ny] == 0){
                        q.add(new Spot(nx, ny));
                        arr[nx][ny] = arr[s.x][s.y] + 1;
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0){
                    return -1;
                }
                if(max < arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        if(max == 1){
            return 0;
        } else
            return max -1;
    }
}
