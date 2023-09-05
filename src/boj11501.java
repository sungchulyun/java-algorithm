import java.io.*;
import java.util.StringTokenizer;

public class boj11501 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            long answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[N-1];
            for(int i = N-2; i >= 0; i--){
                if(max > arr[i])
                    answer += max - arr[i];
                else
                    max = arr[i];
            }
            bw.write(answer + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
