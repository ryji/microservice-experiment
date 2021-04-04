package com.example.order.model;

import java.time.LocalDateTime;

public class Order {

    private Long orderId;

    private Long userId;

    private Long orderCnt;

    private Long goodsId;

    private LocalDateTime createOrderDateTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderCnt() {
        return orderCnt;
    }

    public void setOrderCnt(Long orderCnt) {
        this.orderCnt = orderCnt;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public LocalDateTime getCreateOrderDateTime() {
        return createOrderDateTime;
    }

    public void setCreateOrderDateTime(LocalDateTime createOrderDateTime) {
        this.createOrderDateTime = createOrderDateTime;
    }
}
