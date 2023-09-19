import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1987 {
    public static int R, C;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};

    public static char[][] arr;
    public static ArrayList<Character> list = new ArrayList<>();

    public static int max;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        max = 0;
        dfs(0, 0 , 0);
        System.out.print(max);

    }

    public static void dfs(int x, int y, int count){
        if(list.contains(arr[x][y])){
            max = Math.max(max, count);
            return;
        }

        list.add(arr[x][y]);

        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                dfs(nx, ny, count+1);
            }
        }
        list.remove(Character.valueOf(arr[x][y]));
    }
}
