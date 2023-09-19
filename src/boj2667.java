import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2667 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int[][] arr;
    public static boolean[][] visited;
    public static int N;
    public static int apartNum = 0;
    public static int[] apartment = new int [25 * 25];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    apartNum++;
                    dfs(i, j);
                }
            }
        }
        Arrays.sort(apartment);
        System.out.println(apartNum);

        for(int i = 0; i < apartment.length; i++){
            if(apartment[i] == 0){
            } else {
                System.out.println(apartment[i]);
            }
        }
    }
    public static void dfs(int x, int y){
        apartment[apartNum]++;
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }
    }
}
