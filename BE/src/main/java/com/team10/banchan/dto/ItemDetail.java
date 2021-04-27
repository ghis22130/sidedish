package com.team10.banchan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ItemDetail {

    private final String topImage;
    private final List<String> thumbImages;

    private final String title;
    private final String productDescription;

    private final String point;
    private final String deliveryInfo;

    private final String deliveryFee;
    private final String nPrice;
    private final String sPrice;

    private final List<String> detailSection;
    private final List<String> badges;

    private final Boolean inStock;

    private ItemDetail(String topImage, List<String> thumbImages, String title, String productDescription, String point, String deliveryInfo, String deliveryFee, String nPrice, String sPrice, List<String> detailSection, List<String> badges, Boolean inStock) {
        this.topImage = topImage;
        this.thumbImages = thumbImages;
        this.title = title;
        this.productDescription = productDescription;
        this.point = point;
        this.deliveryInfo = deliveryInfo;
        this.deliveryFee = deliveryFee;
        this.nPrice = nPrice;
        this.sPrice = sPrice;
        this.detailSection = detailSection;
        this.badges = badges;
        this.inStock = inStock;
    }

    public static ItemDetail of(String topImage, List<String> thumbImages,
                                String title, String productDescription,
                                String point, String deliveryInfo,
                                String deliveryFee, String nPrice, String sPrice,
                                List<String> detailSection, List<String> badges, Boolean inStock) {
        return new ItemDetail(topImage, thumbImages, title, productDescription, point, deliveryInfo, deliveryFee, nPrice, sPrice, detailSection, badges, inStock);
    }

    @JsonProperty("top_image")
    public String getTopImage() {
        return topImage;
    }

    @JsonProperty("thumb_image")
    public List<String> getThumbImages() {
        return thumbImages;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("product_description")
    public String getProductDescription() {
        return productDescription;
    }

    @JsonProperty("point")
    public String getPoint() {
        return point;
    }

    @JsonProperty("delivery_info")
    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    @JsonProperty("delivery_fee")
    public String getDeliveryFee() {
        return deliveryFee;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("n_price")
    public String getnPrice() {
        return nPrice;
    }

    @JsonProperty("s_price")
    public String getsPrice() {
        return sPrice;
    }

    @JsonProperty("detail_section")
    public List<String> getDetailSection() {
        return detailSection;
    }

    @JsonProperty("badges")
    public List<String> getBadges() {
        return badges;
    }

    @JsonProperty("in_stock")
    public Boolean getInStock() {
        return inStock;
    }
}


