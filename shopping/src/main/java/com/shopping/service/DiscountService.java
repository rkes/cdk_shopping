package com.shopping.service;

import com.shopping.model.CustomerSlab;


public class DiscountService implements DiscountInterface {

    @Override
    public Float getDiscountPercent(float price, CustomerSlab customerSlab ) {
        final Float []amount ={0.0f};
        customerSlab.getSlabModels().stream().forEach(s->{
            if(price>=s.getMax()){
                amount[0] += s.getDiscount(s.getMax());
            }else{
                if(price>s.getMin() && price<s.getMax() ){
                    amount[0] += s.getDiscount(price);
                }
            }
        });
        return amount[0];
    }

}
