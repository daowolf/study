package com.iwenwu.day4;

/**
 * @Auther: BigDaddy
 * @Date: 2019/6/3 15:29
 * @Description:
 * 找出一个字符串中空格除外的最长子串
 */
public class agl {
    /**
     * "aa aa aaaaa aaaaa  sdsfsddfd a aa "
     */


    private static int print(String str){
        int maxLenghth =  0 ;
        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            //当前字符为空格
            if (chars[i] == ' '){
                maxLenghth = maxLenghth>count?maxLenghth:count;
                count = 0;
            }else {
                count ++;
            }

        }
        return maxLenghth>count?maxLenghth:count;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int print = print("  adfdf effedfsg  e");
       // System.out.println("       adfdfeffedfsg".trim());
        System.out.println(print+" 花费时间"+(System.currentTimeMillis()-start));
    }

    private static int pring(String str){
        int maxLenghth = 0;
        int count = 0;
        char[] cArr = str.toCharArray();
        int index = cArr.length/2;
        if(cArr[index]!=' '){
            for (int i = 0; i <index ; i++) {
                if (cArr[index-i] !=' '){
                    count ++;
                }else {
                    maxLenghth = maxLenghth>count?maxLenghth:count;
                    break;
                }
            }
            count = 0;
            int temp = 0;
            for (int i = index; i+index<cArr.length ; i++) {
                if (cArr[index+i] !=' '){
                    count ++;
                }else {
                    temp = temp>count?temp:count;
                    break;
                }
            }
            maxLenghth = maxLenghth+temp;
        }else {

        }return 0;
    }
}
