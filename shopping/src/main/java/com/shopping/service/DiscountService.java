package com.shopping.service;

import com.shopping.model.CustomerSlab;

import java.util.List;

public class DiscountService implements DiscountInterface {

    @Override
    public Float getDiscountPercent(float price, CustomerSlab customerSlab ) {
        final Float []amount ={0.0f};
        customerSlab.getSlabModels().stream().filter(s-> price >= (s.getMax()) ||
                                                     (price>=s.getMin() && s.getMax()==Float.MAX_VALUE)).
                                                    forEach(slabModel -> {
                if (!slabModel.getMax().equals(Float.MAX_VALUE))
                    amount[0] += slabModel.getDiscount(slabModel.getMax());
                else
                    amount[0] += slabModel.getDiscount(price);
        });
        return amount[0];
    }

}
