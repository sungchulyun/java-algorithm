import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj4673 {
    static String[] arr = {"c=" , "c-", "dz=" , "d-" , "lj" , "nj" , "s=" , "z="};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        for(int i = 0; i < arr.length; i++){
            if(st.contains(arr[i])){
                st = st.replaceAll(arr[i], "!");

            }
        }
        System.out.println(st.length());

    }
}
