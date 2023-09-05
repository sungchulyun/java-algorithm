import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1316 {
    public static boolean[] check;
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i++) {
            String s = br.readLine();// happy, new, year, aba, abab
            if(check(s)) {
                count++;
            }
        }
        System.out.print(count);
    }

    private static boolean check(String s) {
        int prev = 0;
        check = new boolean[26];

        for(int i = 0; i < s.length(); i++){
            int now = s.charAt(i);

            if(prev != now){

                if(check[now - 'a'] == false) {
                    check[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            } else {
                continue;
            }
        }

        return true;

    }
}
