package com.shopping.service;

public class SlabModel {

    private Float min;
    private Float max;
    private Float discount;

    public SlabModel(Float min,Float max,Float discount){
        this.min = min;
        this.max = max;
        this.discount = discount;
    }

    public Float getDiscount(Float amount){
        return ((amount-min)*discount)/100;
    }

    public Float getMax(){
        return max;
    }
    public Float getMin(){
        return min;
    }
}
