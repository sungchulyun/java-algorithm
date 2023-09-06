import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21921 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visitors = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < X; i++){
            sum += visitors[i];
        }

        int cnt = 1;
        int max = sum;

        for(int i = X; i < N; i++){
            sum += visitors[i] - visitors[i - X];

            if(max < sum){
                max = sum;
                cnt = 1;
            } else if(max == sum){
                cnt++;
            }
        }
        if(max == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max + "\n" + cnt);
    }
}
