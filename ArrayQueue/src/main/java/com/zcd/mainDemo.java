package com.zcd;

import java.util.Scanner;

/**
 * @Author 张琛栋 QQ：847890638
 * @ClassName mainDemo
 * @Date 2022/4/12 4:03 PM
 * @Description //测试数组队列模型
 */
public class mainDemo {


    public static void main(String[] args) {

        //创建一个队列
        ArrayQueue array = new ArrayQueue(3);
        char key = ' '; //接收用户输入的数据
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出");
            System.out.println("a(add): 添加数据到队列中");
            System.out.println("g(get): 从队列中取出数据");
            System.out.println("h(head): 查看队列头数据");

            //接收一个字符
            key = scanner.next().charAt(0);

            //判断字符
            switch(key){
                case 's':
                    array.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    array.addQueue(value);
                    break;
                case 'g':
                   try {
                       int res = array.getQueue();
                       System.out.printf("取出的数据是%d\n",res);
                   }catch (Exception e){
                       System.out.println(e.getMessage());
                   }
                    break;
                case 'h':
                    try {
                        int res = array.headQueue();
                        System.out.printf("队列头部数据尾%d \n", res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
        System.out.println("数组队列测试退出！");
    }
}
