import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7569 {

    static class Spot{
        int z;
        int x;

        int y;
        Spot(int z, int x, int y){
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, H;
    static Queue<Spot> q;
    static int[][][] arr;

    static int[] mx = {-1, 1, 0, 0, 0, 0};
    static int[] my = {0, 0, -1, 1, 0, 0};

    static int[] mz = {0, 0, 0, 0, 1, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        q = new LinkedList<Spot>();

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1){
                        q.add(new Spot(i, j, k));
                    }
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){

        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 6; i++){
                int nx = s.x + mx[i];
                int ny = s.y + my[i];
                int nz = s.z + mz[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || nz < 0 || nz >= H)
                    continue;

                if(arr[nz][nx][ny] == 0){
                    q.add(new Spot(nz, nx, ny));
                    arr[nz][nx][ny] = arr[s.z][s.x][s.y] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){

                    if(arr[i][j][k] == 0){
                        return -1;
                    }
                    if(result < arr[i][j][k]){
                        result = arr[i][j][k];
                    }
                }
            }
        }

        if(result == 1){
            return 0;
        } else
            return result - 1;
    }
}
