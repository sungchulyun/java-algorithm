import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj1969 {
    public static void main(String args[]) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0, hd = 0;


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];;

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
               arr[i][j] = str.charAt(j);
           }
        }

        for(int j = 0; j < m; j++){
            int a = 0, t = 0, c = 0, g = 0;
            for(int i = 0; i < n; i++){
                switch (arr[i][j]){
                    case 'A' : a++; break;
                    case 'T' : t++; break;
                    case 'G' : g++; break;
                    case 'C' : c++; break;
                }
            }
            max = Math.max(a > c ? a: c, t > g ? t : g);
            hd += (n - max);
            System.out.print(toChar(a, t, g, c, max));
        }
        System.out.print("\n" + hd);
    }
    private static char toChar(int a, int t, int g, int c, int max){
        if(max == a) return 'A';
        else if(max == c) return 'C';
        else if(max == t) return 'T';
        else return 'G';
    }
}
