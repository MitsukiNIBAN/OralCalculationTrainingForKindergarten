package com.mitsuki.calculation;

/**
 * Created by Mitsuki on 2018/6/1.
 */

public class Formula {
    private int number1;
    private Boolean operator2;
    private int number3;
    private Boolean Operator4;
    private int number5;
    private int result;
    private int shadowNumber;
    private int solution;

    private int intput = -1;

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public Boolean getOperator2() {
        return operator2;
    }

    public void setOperator2(Boolean operator2) {
        this.operator2 = operator2;
    }

    public int getNumber3() {
        return number3;
    }

    public void setNumber3(int number3) {
        this.number3 = number3;
    }

    public Boolean getOperator4() {
        return Operator4;
    }

    public void setOperator4(Boolean operator4) {
        Operator4 = operator4;
    }

    public int getNumber5() {
        return number5;
    }

    public void setNumber5(int number5) {
        this.number5 = number5;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getShadowNumber() {
        return shadowNumber;
    }

    public void setShadowNumber(int shadowNumber) {
        this.shadowNumber = shadowNumber;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public int getIntput() {
        return intput;
    }

    public void setIntput(int intput) {
        this.intput = intput;
    }
}
