import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1105 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] L = st.nextToken().toCharArray();
        char[] R = st.nextToken().toCharArray();

        int answer = 0;

        if(L.length == R.length){
            for(int i = 0; i < L.length; i++){
                if(L[i] == R[i] && L[i] == '8'){
                    answer++;
                } else if(L[i] != R[i]) {
                    break;
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(0);
        }


    }
}
