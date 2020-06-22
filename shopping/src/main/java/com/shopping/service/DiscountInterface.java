package com.shopping.service;

import com.shopping.model.CustomerSlab;

import java.util.List;

public interface DiscountInterface {
    Float getDiscountPercent(float amount, CustomerSlab customerSlab);
}
