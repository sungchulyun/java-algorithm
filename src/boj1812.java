import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1812 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nextSum = new int[N];
        int sum = 0;

        for(int i = 0; i <N; i++){
            nextSum[i] = Integer.parseInt(br.readLine());
            sum += nextSum[i];
        } sum /= 2;

        for(int i = 0; i < N; i++){
            int cnt = i % 2; int val = sum;
            if(i < 2) cnt = i+1;
            while (true){
                if(cnt >= N) break;
                if(cnt == i) {
                    cnt++;
                    continue;
                }
                val -= nextSum[cnt];
                cnt+=2;
            }
            System.out.println(val);
        }
    }
}
