package org.example;

import java.util.*;

class Solution {
    public int calculate(String s) {
        StringBuilder sb=new StringBuilder();
        int temp;
        Stack<Object> stack=new Stack<>();
        List<Object> queue=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                sb.append(s.charAt(i));
                continue;
            }
            if(sb.length()!=0){
                //System.out.println(sb.toString());

                queue.add(new Integer(sb.toString()));
                sb.delete(0,sb.length());
            }
            if(s.charAt(i)==' ')continue;
            queue.add(s.charAt(i));
        }

        if(sb.length()!=0){
            queue.add(new Integer(sb.toString()));
            sb.delete(0,sb.length());
        }
        for(Object i:queue) System.out.print(i+"_");
        while(!queue.isEmpty()){
            Object obj=queue.remove(0);
            if(obj instanceof Integer){
                if(stack.isEmpty()||(Character)stack.peek()=='('){
                    stack.push(obj);
                    continue;
                }
                Character c= (Character) stack.pop();
                if(stack.isEmpty()){
                    stack.push(-1*(Integer)obj);
                }else{
                    Integer pre=(Integer)stack.pop();
                    if(c=='-'){
                        stack.push(pre-(Integer)obj);
                    }else stack.push(pre+(Integer)obj);
                    System.out.println(stack.peek());
                }
            }else if(obj instanceof Character){
                if((Character)obj=='('||(Character)obj=='+'||(Character)obj=='-'){
                    if((Character)obj=='-'&& (stack.isEmpty()||(stack.peek() instanceof Character&& (Character)stack.peek()=='(')))
                        stack.push(Integer.valueOf(0));
                    stack.push(obj);
                }else if ((Character)obj==')') {

                    Integer pre=(Integer)stack.pop();
                    stack.pop();
                    //stack.push(pre);
                    queue.add(0,pre);
                }
            }
        }
        return (Integer)stack.pop();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.calculate("-2+ 1"));
    }
}