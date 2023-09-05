import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9095 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;

        for(int i = 3; i <= 10; i++){
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
        }
        while(T --> 0){
            int N = Integer.parseInt(br.readLine());

            sb.append(arr[N-1]).append("\n");
        }
        System.out.print(sb);
    }
}
