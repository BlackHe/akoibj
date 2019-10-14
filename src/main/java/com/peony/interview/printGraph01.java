package com.peony.interview;
import static com.peony.utils.PrintUtils.*;

/**
 * 打印如下图形
 * #
 * ##
 * ###
 * ####
 * #####
 * ######
 * #######
 */
public class printGraph01 {

    static final String SIGN = "#";

    public static void main(String[] args) {
        for (int i = 0 ; i < 14 ; ++i){
            for (int j = 0 ; j < 7; ++j){
                if (i >= j && i <= 7){
                    print(SIGN);
                }
            }
            println("");
            for (int j = 7; j >0 ; ++j){
                if (i >= j && i > 7){
                    print(SIGN);
                }
            }
        }
    }

    private static  void printAnyNumber(int num, String sign){
        for (int i = 0 ; i <= num; ++i){
            print(sign);
        }
    }
}
