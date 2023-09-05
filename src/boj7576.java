import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Spot{
    int x;
    int y;
    Spot(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class boj7576 {
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};

    static int[][] arr;

    static Queue<Spot> q;

    static int N, M;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        q = new LinkedList<Spot>();

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
                int nx = s.x + mx[i];
                int ny = s.y + my[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if(arr[nx][ny] == 0){
                    q.add(new Spot(nx, ny));
                    arr[nx][ny] = arr[s.x][s.y] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0)
                    return -1;
                if(result < arr[i][j]){
                    result = arr[i][j];
                }
            }
        }
        if(result == 1){
            return 0;
        }
        else
            return result - 1;
    }
}
