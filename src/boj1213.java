import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1213 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alpha = new int[26];

        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'A';
            alpha[idx]++;
        }

        int one = 0;
        for(int i = 0; i < alpha.length; i++){
            if(alpha[i] % 2 != 0){
                one++;
            }
        }
        String answer = "";
        StringBuilder sb = new StringBuilder();

        if(one > 1){
            System.out.println("I'm Sorry Hansoo");
            return;
        } else {
            for(int i = 0; i < alpha.length; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    sb.append((char) (i+ 65));
                    }
                }
                answer += sb.toString();
                String end = sb.reverse().toString();

                sb = new StringBuilder();
                for(int i = 0; i < alpha.length; i++){
                    if(alpha[i] % 2 == 1){
                        sb.append((char)(i + 65));
                    }
                }
                answer += sb.toString() + end;
        }
        System.out.println(answer);
    }
}
