import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13567 {
    private static final int[] DR = {1 , 0, -1 ,0};
    private static final int[] DC = {0, 1, 0 ,-1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());  //명령어 갯수

        int r = 0, c = 0, dir = 1;
        while(n --> 0){
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().charAt(0) == 'T'){
                dir += st.nextToken().charAt(0) == '0' ? -1 : 1;
                if(dir < 0) dir = 3;
                if(dir > 3) dir = 0;
            } else {
                int dist = Integer.parseInt(st.nextToken());
                r += DR[dir] * dist;
                c += DC[dir] * dist;
                if(r >= M || c > M || r < 0 || c < 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(c + " " + r);
    }
}
