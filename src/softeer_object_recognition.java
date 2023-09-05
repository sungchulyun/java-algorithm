import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class softeer_object_recognition {
    static int N;
    static boolean[][] visited;
    static int[][] arr;
    static int obstacles;

    static int[] moveX = {1, 0, -1 ,0};
    static int[] moveY = {0, -1, 0, 1};
    public static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String st = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = st.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    list.add(bfs(i, j));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
    public static int bfs(int x, int y){
        obstacles = 0;
        Queue<Spot> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Spot(x, y));
        obstacles++;

        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 4; i++){
                int nextX = s.x + moveX[i];
                int nextY = s.y + moveY[i];

                if(nextX < 0 || nextX >= N || nextY <0 || nextY >= N)
                    continue;

                if(arr[nextX][nextY] == 0 || visited[nextX][nextY])
                    continue;

                visited[nextX][nextY] = true;
                q.add(new Spot(nextX, nextY));
                obstacles++;
            }
        }
        return obstacles;
    }
}
