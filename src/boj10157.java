import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10157 {
    static int C,R;
    static int[][] arr;
    static boolean[][] check;
    static int[] moveC = {0, 1, 0, -1};
    static int[] moveR = {1, 0, -1, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        check = new boolean[R][C];
        int cnt = 0, dir = 0, c = 0, r = 0;

        for(int i = 0; i < 4; i++){
            int nc = c + moveC[i];
            int nr = r + moveR[i];
        }


    }
}
