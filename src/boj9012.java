import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9012 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {

                if(s.charAt(j) == '(')
                    stack.push(s.charAt(j));
               else{
                  if(stack.isEmpty()){
                      stack.push(s.charAt(j));
                      break;
                   } else{
                      stack.pop();
                  }
                }

            }
            if (stack.isEmpty())
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.print(sb);
    }

}
