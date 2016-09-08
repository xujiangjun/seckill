package org.seckill.junit;

import org.junit.Test;

/**
 * User: xujiangjun
 * Date: 16/9/8 13:07
 */
public class NormalTest {

    /**
     * 将抛出空指针异常
     */
    @Test
    public void IntergerParseTest(){
        Integer.parseInt(null);
    }

    /**
     * 公安局破案问题
     */
    @Test
    public void applicationTest(){
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    for (int d = 0; d < 2; d++) {
                        if(a == 0 && b == 0){
                            continue;
                        }
                        if(b == 0 && c == 0){
                            continue;
                        }
                        if(c == 0 && d == 0){
                            continue;
                        }
                        if(a == 1 && c == 1){
                            continue;
                        }
                        if(b == 1 && d == 1){
                            continue;
                        }
                        System.out.println("赵" + (a == 1 ? "是" : "不是") + "作案人");
                        System.out.println("钱" + (b == 1 ? "是" : "不是") + "作案人");
                        System.out.println("孙" + (c == 1 ? "是" : "不是") + "作案人");
                        System.out.println("李" + (d == 1 ? "是" : "不是") + "作案人");
                    }
                }
            }
        }
    }
}
