package com.zklearn.linear;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-07 17:44:20
 * @Description: 括号匹配
 */
public class BracketMatch<T> {


    public static void main(String[] args) {

        String str="hahah(cdhjsbc)cdsbch)cdshb";
        boolean b = judgeMatch(str);
        System.out.println("括号是否匹配"+b);
    }


    public static boolean judgeMatch(String str){
        Stack<Character> stack=new Stack<>();
        for (char c : str.toCharArray()) {
            if(c=='('){
                stack.push(c);
            }
            if(c==')'){
                if(stack.pop()==null) {
                    return false;
                }
            }
        }
        return true;
    }
}
