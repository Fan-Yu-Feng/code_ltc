package com.fyf;

//利用分块查询来查找数据
public class A02_block_search {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 9, 6, 10, 34, 26, 16};
     /*分块
     int[]nums={1,3,2,
                9,6,10,
                34,26,16
                }
       */

        //创建三个块的对象
        Block b1 = new Block(3, 0, 2);
        Block b2 = new Block(10, 3, 6);
        Block b3 = new Block(34, 7, 9);

        //定义数组来储存三个对象(索引表)
        Block[] blockArray = {b1, b2, b3};

        //定义一个数值来作为查找值
        int searchNum = 30;

        //调用方法，传递索引表，数组，查找的元素
        int index = getIndex(blockArray, nums, searchNum);

        //打印
        System.out.println(index);

    }


    //利用分块查找searchNum的索引
    //确定searchNum在数组里的位置
    private static int getIndex(Block[] blockArray, int[] nums, int searchNum) {
        //确认查找的searchNum在那一块当中
        int indexBlock=foundIndexBlock(blockArray,searchNum);

        if(indexBlock==-1){
            return -1;
        }

        //获取searchNum所在的块的起始索引和结束索引的值
        int startIndex1=blockArray[indexBlock].startIndex;
        int endIndex2=blockArray[indexBlock].endIndex;
        //遍历来获取searchNum的索引值
        for(int j=startIndex1;j<=endIndex2;j++){
            if(nums[j]==searchNum){
                return j;
            }
        }
        return -1;
    }


    //定义一个方法，来确定searchNum在那一块当中
    private static int foundIndexBlock(Block[] blockArray, int searchNum) {

        for(int i=0;i<blockArray.length;i++){
            if(searchNum<=blockArray[i].getMax()){
                return i;
            }
        }
        return -1;
    }
}



    class Block {
        public int Max;        //最大值
        public int startIndex; //开始索引
        public int endIndex;   //结束索引

        public Block() {
        }

        public Block(int Max, int startIndex, int endIndex) {
            this.Max = Max;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public int getMax() {
            return Max;
        }

        public void setMax(int Max) {
            this.Max = Max;
        }

    }

