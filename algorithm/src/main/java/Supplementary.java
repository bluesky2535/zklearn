import java.util.Stack;

/**
 * @author zk
 * @date 2019/11/18 23:19
 */
public class Supplementary {

    //补全括号
    //((1 + 2) * ((3 - 4) * (5 - 6)))
    public static void main(String[] args) {
        String s = "1+2)*3-4)*5-6)))";
        trans(s);
    }

    public static String trans(String s) {

        String s2 = "1+2)*3-4)*5-6)))";
        char[] charArray = s.toCharArray();
        //dataStack
        Stack<String> stack1 = new Stack<String>();
        //operateStack
        Stack<String> stack2 = new Stack<String>();
        int i = 0;
        while (i < charArray.length) {
            if ("+-*/".indexOf(String.valueOf(charArray[i])) != -1) {
                stack2.push(String.valueOf(charArray[i]));
            } else if (charArray[i] != ')') {
                stack1.push(String.valueOf(charArray[i]));
            } else if (charArray[i] == ')') {
                String s3 = stack1.pop();
                String s4 = stack1.pop();
                String s5 = "( " + s4 +" "+ stack2.pop() +" "+ s3 + " ) ";
                stack1.push(s5);
            }

            i++;
        }


        for (String s6 : stack1) {
            System.out.println(s6);
        }


        return null;
    }
}
