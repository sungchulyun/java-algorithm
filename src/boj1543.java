import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1543 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String key = br.readLine();
        int len = str.length();
        int len2 = key.length();

        str = str.replace(key, "");
        System.out.println((len - str.length()) / len2);
    }
}
