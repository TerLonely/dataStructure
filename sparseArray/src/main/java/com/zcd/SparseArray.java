package com.zcd;

/**
 * @Author 张琛栋 QQ：847890638
 * @ClassName SparseArray
 * @Date 2022/2/16 4:48 PM
 * @Description  稀疏数组的代码实现
 */
public class SparseArray {

    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始二维数组");

        for(int[] row: chessArr1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        // 将二维数组转为稀疏数组
        int sum = 0;
        int ary = 1;
        for(int[] row: chessArr1){
            for(int data : row){
                if(data != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum = "+ sum);
        //创建稀疏数组
        int aparseAry[][] = new int[sum+1][3];
        aparseAry[0][0] = 11;
        aparseAry[0][1] = 11;
        aparseAry[0][2] = sum;
        for(int i=0; i< chessArr1.length; i++){
            for(int j=0; j<chessArr1[i].length; j++){
                if( chessArr1[i][j] != 0){
                    aparseAry[ary][0] = i;
                    aparseAry[ary][1] = j;
                    aparseAry[ary][2] = chessArr1[i][j];
                    ary++;
                }
            }
        }
        System.out.println();
        System.out.println("得到的稀疏数组为～～～～～");
        for(int i = 0; i< aparseAry.length; i++){
            System.out.printf("%d\t%d\t%d\t\n", aparseAry[i][0],aparseAry[i][1],aparseAry[i][2]);
        }
        System.out.println();

        //将稀疏数组 恢复成 原始的二维数组
        //1.先读取稀疏数组的第一行、根据第一行的数据创建原始二维数组
        //2.读取稀疏数组后几行数据，并赋值给原始的二维数组

        int aparseArr[][] = new int[aparseAry[0][0]][aparseAry[0][1]];
        for(int i=1; i<aparseAry.length; i++){
            aparseArr[aparseAry[i][0]][aparseAry[i][1]] = aparseAry[i][2];
        }
        System.out.println("还原后的数组为～～～～～");
        for(int[] row: aparseArr){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }





}
