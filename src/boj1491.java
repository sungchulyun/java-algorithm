import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1491 {
    static int[] moveC = {1, 0, -1, 0};
    static int[] moveR = {0, 1,  0, -1};
    static int[][] arr;
    static boolean[][] visited;
    static int count = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        visited = new boolean[R][C];
        int c = 0, r = 0, dir = 0;

        while(count != C * R){

            arr[r][c] = ++count;
            visited[r][c] = true;
            int nr = r + moveR[dir];
            int nc = c + moveC[dir];

            if(nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc]){
                dir = ++dir % 4;
                nr = r + moveR[dir];
                nc = c + moveC[dir];
            }
            r = nr;
            c = nc;
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(arr[i][j] == count)
                    System.out.println(j + " " + i);
            }
        }

    }
}
