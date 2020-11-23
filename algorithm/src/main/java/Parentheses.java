import java.util.Stack;

/**
 * @author zk
 * @date 2019/11/17 21:32
 */
public class Parentheses {

//算法1.3.4解答
    public static void main(String[] args) {


//        String a = "[()]{}{[()()]()}";
        String a = "[(])]{}{[()()]()}";
        System.out.println(judge(a));
    }

    private static boolean judge(String s) {
        char[] chars =s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while (i < chars.length) {
            //如果栈为空时
            if(stack.empty()){
                if (chars[i] == ']' || chars[i] == ')' || chars[i] == '}'){
                    return false;
                }
            }

            if (chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
                stack.push(chars[i]);
            } else if (chars[i] == ']' || chars[i] == ')' || chars[i] == '}') {
                char first = stack.pop();

                if ((chars[i] == '}' && first == '{') || (chars[i] == ']' && first == '[') || (chars[i] == ')' && first == '(')) {
                    i++;
                    continue;
                } else {
                    return false;
                }
            }
            i++;
        }

        return true;
    }
}


