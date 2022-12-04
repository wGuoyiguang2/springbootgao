package com.example.model;

import java.io.Serializable;

public class BuyerItem implements Serializable {

    private static final long serialVersionUID = 1L;

    //SKu对象(一个商品的 颜色一样，大小不一样就算是不一样的sku)
    private Sku sku;

    //是否有货
    private Boolean isHave = true;


    //是否选中(未登录用户注册后或者登录后需要将 购物车中选中的商品勾选出来)
    private Boolean isChoosen = false;

    //购买的数量
    private Integer amount = 1;

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public Boolean getIsHave() {
        return isHave;
    }

    public void setIsHave(Boolean isHave) {
        this.isHave = isHave;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getHave() {
        return isHave;
    }

    public void setHave(Boolean have) {
        isHave = have;
    }

    public Boolean getChoosen() {
        return isChoosen;
    }

    public void setChoosen(Boolean choosen) {
        isChoosen = choosen;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sku == null) ? 0 : sku.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) //比较地址
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyerItem other = (BuyerItem) obj;
        if (sku == null) {
            if (other.sku != null)
                return false;
        } else if (!sku.getId().equals(other.sku.getId()))
            return false;
        return true;
    }
}
