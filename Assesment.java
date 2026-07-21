import java.util.*;

public class Assesment{


    public static void main(String[] args) {
        String s1 = "(()";

        String s2 = ")()())";
        
        String s3 = "";

        System.out.println( longestValidParentheses(s1));
        System.out.println( longestValidParentheses(s2));
        System.out.println( longestValidParentheses(s3));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();

                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    int len = i - st.peek();
                    if (len > ans) {
                        ans = len;
                    }
                }
            }
        }

        return ans;
    }

  
}