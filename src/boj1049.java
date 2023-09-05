import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1049 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] packages = new int[M];
        int[] each = new int[M];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            packages[i] = Integer.parseInt(st.nextToken());
            each[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(packages);
        Arrays.sort(each);

        int answer = 0;

        while(true){
            if(N < 6){
                answer += Math.min(packages[0], each[0] * N);
                break;
            } else {
                answer += Math.min(packages[0] * (N / 6), each[0] * (N / 6) * 6);
                N %= 6;
            }
        }
        System.out.print(answer);
    }
}
