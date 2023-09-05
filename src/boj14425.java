import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14425 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] s = new String[N];
        int count = 0;

        for(int i = 0; i < N; i++){
            s[i] = br.readLine();
        }
        for(int j = 0; j < M; j++){
            String str = br.readLine();

            for(int i = 0; i < N; i++){
                if(s[i].equals(str)){
                    System.out.println(str);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
