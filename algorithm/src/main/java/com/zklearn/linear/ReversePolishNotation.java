package com.zklearn.linear;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-08 09:19:01
 * @Description: 逆波兰表达式运算
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        //中缀表达式：3 * (17-15) + 18/6
        String[] notation ={"3", "17", "15","-","*","18", "6", "/", "+"};
        int result=caculate(notation);
        System.out.println("逆波兰表达式的结果"+result);
    }

    private static int caculate(String[] notation) {
        Stack<Integer> stack=new Stack<>();
        Integer result;
        for (String s : notation) {
            if(s!="-" && s!="+" && s!="*" && s!="/"){
                stack.push(Integer.parseInt(s));
            }else{
                Integer num1 = stack.pop();
                Integer num2=stack.pop();
                switch (s) {
                    case "+":
                        result=num2+num1;
                        break;
                    case "-":
                        result=num2-num1;
                        break;
                    case "*":
                        result=num2*num1;
                        break;
                    case "/":
                        result=num2/num1;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + s);
                }
                stack.push(result);
            }
        }

        return stack.pop();

    }


}
