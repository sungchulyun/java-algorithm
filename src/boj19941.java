import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj19941 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] hamburgers = new boolean[N];

        String str = br.readLine();

        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            for(int j = -K; j <= K; j++){
                if(i + j >= N)
                    break;
                if(i + j < 0)
                    continue;

                if(str.charAt(i) == 'P'){
                    if(str.charAt(i + j) == 'H' && !(hamburgers[i + j])) {
                        hamburgers[i + j] = true;
                        cnt++;
                        break;
                        }
                    }
                }
            }
        System.out.println(cnt);
        br.close();
    }
}
