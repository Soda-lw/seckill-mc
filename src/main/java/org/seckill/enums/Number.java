package org.seckill.enums;

/**
 * @author: liuwei
 * @Date: 15:26 2018/5/4
 */
public enum Number {
    ONE(1,111),
    TWO(2,222);
    int num;
    int sum;
    String type;

    Number(int i, String s) {
        this.num = i;
        this.type = s;
    }

    Number(int sum, int num) {
        this.num = num;
        this.sum = sum;
    }

    public int getNum() {
        return num;
    }

    public int getSum() {
        return sum;
    }

    public String getType() {
        return type;
    }
}
