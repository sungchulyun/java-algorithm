import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16234 {
    static int[][] arr;
    static boolean[][] check;
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};

    static ArrayList<Spot> list;

    static int N, L, R;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }
    static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int move(){
        int result = 0;
        while(true){
            check = new boolean[N][N];
            boolean isMove = false;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!check[i][j]){
                        int sum = bfs(i,j);
                        if(list.size() > 1){
                            isMove = true;
                            changePopulation(sum);
                        }
                    }
                }
            }
            if(!isMove) return result;
            result++;
        }
    }

    public static int bfs(int x, int y){
        Queue<Spot> q = new LinkedList<>();
        list = new ArrayList<>();

        q.add(new Spot(x, y));
        list.add(new Spot(x, y));
        check[x][y] = true;

        int sum = arr[x][y];
        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < N; i++){
                int nx = s.x + mx[i];
                int ny = s.y + my[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !check[nx][ny]){
                    int diff = Math.abs(arr[s.x][s.y] - arr[nx][ny]);
                    if(L <= diff && diff <= R){
                        q.add(new Spot(nx, ny));
                        list.add(new Spot(nx, ny));
                        check[nx][ny] = true;
                        sum += arr[nx][ny];
                    }
                }
            }
        }
        return sum;
    }

    public static void changePopulation(int sum){
        int avg = sum / list.size();
        for(Spot s : list){
            arr[s.x][s.y] = avg;
        }
    }
}