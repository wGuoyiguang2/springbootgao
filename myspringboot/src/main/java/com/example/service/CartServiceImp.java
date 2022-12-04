package com.example.service;

import com.example.model.BuyerItem;
import com.example.model.Sku;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartServiceImp implements  CartService{
    @Override
    public Sku selectSkuById(Long id) {
        Sku sku =  new Sku();
        sku.setId(id);
        sku.setPrice(10L);
        return sku;
    }

    @Override
    public List<BuyerItem> selectBuyerCartFromDbByUserName(String userId) {
        List buyerItemList = new ArrayList();
        BuyerItem buyerItem = new  BuyerItem();
        Sku sku =  new Sku();
        sku.setId(1L);
        sku.setPrice(10L);
        buyerItem.setSku(sku);
        buyerItem.setAmount(100);

        buyerItemList.add(buyerItem);

        return buyerItemList;
    }
}
