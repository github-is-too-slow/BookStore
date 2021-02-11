package com.billion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车模型
 * @author Billion
 * @create 2021/02/08 19:38
 */
public class Cart implements Serializable{
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public Cart() {
    }

    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());
        if(null == item){
            items.put(cartItem.getId(), cartItem);
        }else {
            item.setCount(item.getCount() + cartItem.getCount());
        }
    }

    public void deleteItem(Integer id){
        items.remove(id);
    }

    public void clear(){
        items.clear();
    }

    public void updateCount(Integer id, Integer count){
        CartItem item = items.get(id);
        if(null != item){
            item.setCount(count);
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem item : items.values()) {
            totalCount += item.getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem item : items.values()) {
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
