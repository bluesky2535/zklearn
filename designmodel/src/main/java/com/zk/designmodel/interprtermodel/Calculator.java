package com.zk.designmodel.interprtermodel;

import java.util.HashMap;
import java.util.Stack;

public class Calculator {

    //定义表达式
    private Expression expression;
    //构造函数传参
    public Calculator(String expStr){
        //定义一个栈
        Stack<Expression> stack=new Stack<>();
        //表达式拆分为字符数组
        char[] charArray=expStr.toCharArray();
        //运算
        Expression left=null;
        Expression right=null;

        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]){
                case '+':
                    left=stack.pop();
                    right=new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left,right));
                    break;
                case '-':
                    left=stack.pop();
                    right=new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left,right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        this.expression=stack.pop();
    }

    //计算
    public int run(HashMap<String,Integer> var){
        return this.expression.interpreter(var);
    };

}
