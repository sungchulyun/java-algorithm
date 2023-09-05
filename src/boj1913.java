import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1913 {
    static int N;
    static int M;
    static int[] mc = {1, 0, -1, 0};
    static  int[] mr = {0, 1, 0, -1};

    static int[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        arr[0][0] = N * N;

        int c = 0, r = 0;
        int dir = 0;

        while(N --> 1){

            for(int i = 0; i < 4; i++){
                int nc = c + mc[dir];
                int nr = r + mr[dir];

                if(nc >= N || nr >= N || nc < 0 || nr < 0){
                    dir = (dir + 1) % 4;
                }

                arr[nr][nc] = N--;

                c = nc;
                r = nr;
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}