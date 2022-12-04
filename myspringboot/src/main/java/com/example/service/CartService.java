package com.example.service;

import com.example.model.BuyerItem;
import com.example.model.Sku;

import java.util.List;

public interface CartService {

  Sku selectSkuById(Long id);


    List<BuyerItem> selectBuyerCartFromDbByUserName(String userId);
}
