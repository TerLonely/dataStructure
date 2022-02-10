package com.zcd.stack;

/**
 * @Author 张琛栋 QQ：847890638
 * @ClassName ArrayStack
 * @Date 2022/2/9 3:08 PM
 * @Description // 通过数组方式实现栈
 */
public class ArrayStack {

    /**
     * 栈的最大值
     */
    private int maxStack;

    /**
     * 通过数组模拟栈
     */
    private int[] stack;

    /**
     * 栈顶位置
     */
    private int top = -1;

    /**
     * 初始化栈的大小
     */
    public ArrayStack(int maxStack){
        this.maxStack = maxStack;
        this.stack = new int[this.maxStack];
    }

    /**
     * 判断是否栈满
     */
    public boolean isFull(){
        return this.top ==  this.maxStack - 1;
    }

    /**
     * 判断是否栈空
     */
    public boolean isEmpty(){
        return this.top == -1;
    }

    /**
     * 压栈
     */
    public void push(int value){
        //判断是否满栈
        if(isFull()){
            throw new RuntimeException("栈已满....");
        }

        this.top ++;
        this.stack[this.top] = value;
    }

    /**
     * 出栈
     */
    public int pop(){
        //判断是否为空栈
        if(isEmpty()){
            throw new RuntimeException("栈内为空....");
        }
        int value = this.stack[this.top];

        this.top-- ;

        return value;
    }

    /**
     * 打印所有栈内元素
     */
    public void list(){
        if(isEmpty()){
            throw new RuntimeException("空栈，栈内没有元素");
        }

        for (int i = 0 ; i < this.stack.length; i++){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    public int length(){
        return this.top+1;
    }



}
