import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj1822 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int[] arrA = new int[nA];
        int nB = Integer.parseInt(st.nextToken());
        Set<Integer> setB = new HashSet<>();


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nA; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nB; i++){
            setB.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

       for(int i = 0; i < nA; i++){
           int target = arrA[i];
           if(!setB.contains(target)){
               sb.append(target).append(" ");
               count++;
           }
       }
       System.out.println(count);
       System.out.println(sb.toString().trim());
    }
}
