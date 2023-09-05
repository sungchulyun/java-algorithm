import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj9375 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            int count = 1;


            for(int i =0 ; i < N; i++){
                String str = br.readLine();
                String[] custom = str.split(" ");
                map.put(custom[1], map.getOrDefault(custom[1], 0) + 1);
            }

            for(int val : map.values()){
                count *= (val + 1);
            }
            System.out.println(count-1);
        }
    }
}
