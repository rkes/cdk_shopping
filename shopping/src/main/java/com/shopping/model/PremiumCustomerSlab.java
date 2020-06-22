package com.shopping.model;

import com.shopping.service.SlabModel;

import java.util.ArrayList;
import java.util.List;

public class PremiumCustomerSlab implements CustomerSlab {

    private List<SlabModel> slabModels = new ArrayList<>();

    public PremiumCustomerSlab(){
        slabModels.add(new SlabModel(0.0f,4000.0f,10.0f));
        slabModels.add(new SlabModel(4000.0f,8000.0f,15.0f));
        slabModels.add(new SlabModel(8000.0f,12000.f,20.0f));
        slabModels.add(new SlabModel(12000.0f,Float.MAX_VALUE,30.0f));
    }

    public List<SlabModel> getSlabModels(){
        return this.slabModels;
    }

}
