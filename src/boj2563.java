import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2563 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[101][101];
        int area = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int t = x; t < x+ 10; t++){
                for(int j = y; j < y + 10; j++){
                    if(!arr[t][j]){
                        area++;
                        arr[t][j] = true;
                    }
                }
            }
        }
        System.out.println(area);
    }
}
