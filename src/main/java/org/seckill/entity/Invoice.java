package org.seckill.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujiangjun
 * @version 1.0
 * @date 2016-11-17 10:32
 */
public class Invoice {
    /**
     * 静态嵌套类
     * Item声明为private，因此只有Invoice方法能访问它
     * 注意：仅举例说明静态嵌套类，真实的价格计算应使用BigDecimal
     */
    @ToString
    private static class Item{
        private String description;
        private int quantity;
        double unitPrice;
        double price(){
            return quantity * unitPrice;
        }
    }

    @Getter
    private List<Item> items = new ArrayList<>();

    public void addItem(String description, int quantity, double unitPrice){
        Item item = new Item();
        item.description = description;
        item.quantity = quantity;
        item.unitPrice = unitPrice;
        items.add(item);
        System.out.println(item.price());
    }

    public static void main(String[] args) {
        Invoice.Item i = new Invoice.Item();
        Invoice invoice = new Invoice();
        invoice.addItem("灯泡", 10, 2.5);
        System.out.println(invoice.getItems());
    }
}
