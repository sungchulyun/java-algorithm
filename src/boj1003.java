import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1003 {
    static int cnt0, cnt1;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        while(N --> 0){
            cnt0 = 0;
            cnt1 = 0;
            int tc = Integer.parseInt(br.readLine());

            fibonacci(tc);
            sb.append(cnt0).append(" ").append(cnt1);
            sb.append("\n");
        }
        System.out.print(sb);
    }
    public static int fibonacci(int tc){
        if(tc == 0){
            cnt0++;
            return 0;
        }else if(tc == 1){
            cnt1++;
            return 1;
        } else
            return fibonacci(tc-1) + fibonacci(tc-2);
    }
}
