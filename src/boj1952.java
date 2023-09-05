import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1952 {

    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1 ,0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[M][N];

        int x = 0, y = 0, dir = 1, cnt = 0;

        while(true){
            if(visited[y][x]) break;
            visited[y][x] = true;

            int newX = x + moveX[dir];
            int newY = y + moveY[dir];

            if(newX < 0 || newY < 0 || newX >= N || newY >= M || visited[newY][newX]){
                if(dir == 3){
                    dir = 0;
                } else
                    dir++;
                cnt++;
            }
            x = x + moveX[dir];
            y = y + moveY[dir];
        }
        System.out.println(cnt-1);

    }
}
