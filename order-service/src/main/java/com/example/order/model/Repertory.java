package com.example.order.model;

public class Repertory {

    /**
     *  unique id
     */
    private Long repertoryId;

    /**
     *  goods id
     */
    private Long goodsId;

    /**
     * goods count
     */
    private Long cnt;


    public Long getRepertoryId() {
        return repertoryId;
    }

    public void setRepertoryId(Long repertoryId) {
        this.repertoryId = repertoryId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }
}
