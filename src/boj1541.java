import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1541 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] sub = str.split("-");
        int sum = Integer.MAX_VALUE;

        for(int i = 0; i < sub.length; i++){
            String[] plus = sub[i].split("\\+");
            int temp = 0;

            for(int j = 0; j < plus.length; j++){
                temp += Integer.parseInt(plus[j]);
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
                } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
