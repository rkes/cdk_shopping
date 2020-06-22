package com.shopping.service;

import com.shopping.model.CustomerSlab;

public class CustomerService {
    private DiscountService discountService;
    private  CustomerSlab customerSlabs ;
    public CustomerService(DiscountService discountService, CustomerSlab customerSlab ){
        this.customerSlabs = customerSlab;
        this.discountService = discountService;
    }

    private Float getDiscountedAmount(float price){
        return discountService.getDiscountPercent(price,customerSlabs);
    }

    public Float getAmount(float price){
        return price - getDiscountedAmount(price);
    }



}
