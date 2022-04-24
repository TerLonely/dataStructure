package com.zcd;

/**
 * @Author 张琛栋 QQ：847890638
 * @ClassName ArrayQueue
 * @Date 2022/2/18 5:52 PM
 * @Description  数组型队列实现
 *
 * front变量：front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素，front初始值=0
 * rear变量：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定。rear初始值=0
 *
 * 当队列满时，条件是：(rear + 1) % maxSize == front
 * 当队列为空的条件： rear == front
 * 队列中有效的数据的个数：(rear + maxSize - front) % maxSize
 *
 */
public class ArrayQueue {

    private int maxSize; //表示数组最大长度
    private int front; //表示队列头
    private int rear; //表示队列尾
    private int[] arr; //该数据用于存储数据

    //创建队列带参构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    //判断数组队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断数组队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据～");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，由于是环形数组，必须考虑取模问题
        rear = (rear + 1) % maxSize;
    }

    //取出队列数据
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
           throw new RuntimeException("队列为空，无法获取数据～");
        }
        /**
         * 由于front是指向队列的第一个元素
         * 1.先把front对应的值保存在一个零时变量中
         * 2.将front后移， 考虑取模
         * 3.将零时保存的变量返回s
         *
         */
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue(){
        //判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for(int i=front; i<front + size(); i++){
            System.out.printf("arr[%d] = %d \n", i % maxSize, arr[i % maxSize]);
        }
    }

    //显示队列头数据
    public int headQueue(){
        //判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空");
        }
        return arr[front];
    }

    /**
     * 求出当前队列有效数据的个数
     * 若 rear > front 则数据个数为 rear - front
     * 若 rear < front 则数据个数分为两段 其中一段为：maxSize - front
     *                                 另一段为： 0 + rear
     *                                 合并后的公式为：maxSize - front + rear
     * 合并两种情况给出统一公式：(maxSize - front + rear) % maxSize
     * @return
     */

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
}