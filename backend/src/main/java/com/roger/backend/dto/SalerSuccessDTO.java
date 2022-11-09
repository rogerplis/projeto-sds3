package com.roger.backend.dto;

import com.roger.backend.entitie.Seller;

import java.io.Serializable;

public class SalerSuccessDTO implements Serializable {
    public static final long serialVersionUID = 1L;
    private String sellerName;
    private Long visited;
    private Long deals;

    public SalerSuccessDTO() {
    }

    public SalerSuccessDTO(Seller seller, Long visited, Long deals) {
       sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getVisited() {
        return visited;
    }

    public void setVisited(Long visited) {
        this.visited = visited;
    }

    public Long getDeals() {
        return deals;
    }

    public void setDeals(Long deals) {
        this.deals = deals;
    }
}
