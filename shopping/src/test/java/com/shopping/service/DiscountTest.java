package com.shopping.service;

import com.shopping.model.PremiumCustomerSlab;
import com.shopping.model.RegularCustomerSlab;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscountTest {

   private  DiscountService discountService = new DiscountService();
   private RegularCustomerSlab regularCustomerSlab = new RegularCustomerSlab();
   private PremiumCustomerSlab premiumCustomerSlab = new PremiumCustomerSlab();

   @Test
   public void testForRegularCustomer(){
      CustomerService customerService = new CustomerService(discountService,regularCustomerSlab);
      Float []priceArray = {5000.0f,10000.0f,15000.0f};
      List<Float> expectedDiscountArray = Arrays.asList(5000.0f,9500.0f,13500.0f);
      List<Float> resultArray = new ArrayList<>();
      Arrays.stream(priceArray).forEach( price ->{
         resultArray.add(customerService.getAmount(price));
      });
      assertThat(expectedDiscountArray,is(equalTo(resultArray)));
   }
   @Test
   public void testForPremiumCustomer(){
      CustomerService customerService = new CustomerService(discountService,premiumCustomerSlab);
      Float []priceArray = {4000.0f,8000.0f,12000.0f,20000.0f};
      List<Float> expectedDiscountArray = Arrays.asList(3600.0f,7000.0f,10200.0f,15800.0f);
      List<Float> resultArray = new ArrayList<>();
      Arrays.stream(priceArray).forEach( price ->{
         resultArray.add(customerService.getAmount(price));
      });
      assertThat(expectedDiscountArray,is(equalTo(resultArray)));
   }
   @Test
   public void testForRegularCustomer_Failure(){
      CustomerService customerService = new CustomerService(discountService,regularCustomerSlab);
      Float []priceArray = {5000.0f,10000.0f,15000.0f};
      List<Float> expectedDiscountArray = Arrays.asList(5000.0f,9600.0f,13500.0f);
      List<Float> resultArray = new ArrayList<>();
      Arrays.stream(priceArray).forEach( price ->{
         resultArray.add(customerService.getAmount(price));
      });
      assertThat(expectedDiscountArray,is(not(equalTo(resultArray))));
   }
   @Test
   public void testForPremiumCustomer_Failure(){
      CustomerService customerService = new CustomerService(discountService,premiumCustomerSlab);
      Float []priceArray = {4000.0f,8000.0f,12000.0f,20000.0f};
      List<Float> expectedDiscountArray = Arrays.asList(3600.0f,7100.0f,10200.0f,15800.0f);
      List<Float> resultArray = new ArrayList<>();
      Arrays.stream(priceArray).forEach( price ->{
         resultArray.add(customerService.getAmount(price));
      });
      assertThat(expectedDiscountArray,is(not(equalTo(resultArray))));
   }

}
