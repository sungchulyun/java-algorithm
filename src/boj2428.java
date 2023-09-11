import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2428 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int cnt = 0;

        while(start < N){

            while(true){
                if(end >= N-1)
                    break;

                int left = arr[start];
                int right = arr[end+1];

                if(left * 10 < right * 0.9)
                    break;
                else{
                    end++;
                }
            }
            cnt += end - start;
            start++;
        }

        System.out.println(cnt);
    }
}
