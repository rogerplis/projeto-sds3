package com.roger.backend.dto;

import com.roger.backend.entitie.Seller;

import java.io.Serializable;

public class SalerSumDTO implements Serializable {
    public static final long serialVersionUID = 1L;
    private String seller;
    private Double sum;

    public SalerSumDTO() {
    }

    public SalerSumDTO(Seller seller, Double sum) {
        this.seller = seller.getName();
        this.sum = sum;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
