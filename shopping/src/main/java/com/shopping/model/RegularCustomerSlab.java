package com.shopping.model;

import com.shopping.service.SlabModel;

import java.util.ArrayList;
import java.util.List;

public class RegularCustomerSlab implements CustomerSlab{

    private  List<SlabModel> slabModels = new ArrayList<>();
    public RegularCustomerSlab(){
        slabModels.add(new SlabModel(0.0f,5000.0f,0.0f));
        slabModels.add(new SlabModel(5000.0f,10000.0f,10.0f));
        slabModels.add(new SlabModel(10000.0f,Float.MAX_VALUE,20.0f));
    }

    public List<SlabModel> getSlabModels(){
        return this.slabModels;
    }

}
