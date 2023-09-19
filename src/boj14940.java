import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14940 {
    static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static boolean[][] visited;
    public static int[][] map;
    public static int[] dx = {0, -1 ,0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int N, M;
    public static Queue<Spot> q = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    q.add(new Spot(i, j));
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N) {

                }
            }
        }
    }
}
