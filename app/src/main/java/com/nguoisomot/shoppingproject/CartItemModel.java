package com.nguoisomot.shoppingproject;

public class CartItemModel {
    public static final int CART_ITEM = 0;
    public static final int TOTAL_AMOUNT = 1;

    private int type;

    ////// cart item
    private String productID;
    private String productImage;
    private String productTitle;
    private Long freeCoupen;
    private String productPrice;
    private String cuttedPrice;
    private Long productQuantity;
    private Long offersAppliesd;
    private Long coupensApplied;

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Long getFreeCoupen() {
        return freeCoupen;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setFreeCoupen(Long freeCoupen) {
        this.freeCoupen = freeCoupen;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public Long getProductQuntity() {
        return productQuantity;
    }

    public void setProductQuntity(Long productQuntity) {
        this.productQuantity = productQuntity;
    }

    public Long getOffersAppliesd() {
        return offersAppliesd;
    }

    public void setOffersAppliesd(Long offersAppliesd) {
        this.offersAppliesd = offersAppliesd;
    }

    public Long getCoupensApplied() {
        return coupensApplied;
    }

    public void setCoupensApplied(Long coupensApplied) {
        this.coupensApplied = coupensApplied;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public CartItemModel(int type, String productID, String productImage, String productTitle, Long freeCoupen, String productPrice, String cuttedPrice, Long productQuntity, Long offersAppliesd, Long coupensApplied) {
        this.type = type;
        this.productID = productID;
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freeCoupen = freeCoupen;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.productQuantity = productQuntity;
        this.offersAppliesd = offersAppliesd;
        this.coupensApplied = coupensApplied;
    }
    ////// cart item

    ////// cart total
    public CartItemModel(int type) {
        this.type = type;
    }


    ////// cart total
}
