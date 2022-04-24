package com.zcd.stack;

/**
 * @Author 张琛栋 QQ：847890638
 * @ClassName Palindrome
 * @Date 2022/2/9 10:13 PM
 * @Description 判断字符串是否符合回文格式
 */
public class Palindrome {

    public static void main(String[] args) {

        String str = "level";

        System.out.println(detection(str));

    }

//    public static boolean detection(String str){
//
//
//        ArrayStack stark = new ArrayStack(10);
//
//        int length = str.length();
//
//        for(int i = 0; i < length; i++){
//            stark.push(str.charAt(i));
//        }
//
//        String starkStr = "";
//
//        for(int j =0; j< length; j++){
//            if(!stark.isEmpty()){
//                Object value = stark.pop();
//                starkStr += value;
////                starkStr += (char) stark.pop();
//            }
//        }
//
//        if(str.equals(starkStr)){
//            return true;
//        }else{
//            return false;
//        }
//
//    }

    public static boolean detection(String words) {
        ArrayStack arrayStack = new ArrayStack(10);
        int length = words.length();
        for (int i = 0; i < length; i++) {
            arrayStack.push(words.charAt(i));
        }
        String newValue = "";
        for (int i = 0; i < arrayStack.length(); i++) {
            if (!arrayStack.isEmpty()) {
                Object value = arrayStack.pop();
                newValue = newValue + value;
            }
        }
        if (words.equals(newValue)) {
            return true;
        }
        return  false;
    }

}
