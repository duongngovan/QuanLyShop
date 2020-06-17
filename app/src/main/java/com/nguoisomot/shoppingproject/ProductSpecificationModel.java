package com.nguoisomot.shoppingproject;

public class ProductSpecificationModel {

    public static final int SPECIFICATION_TITLE = 0;
    public static final int SPECIFICATION_BODY = 1;

    private int type;

    /////// specification title
    private String title;
    /////// specification title

    /////// specification body
    private String featrurName;
    private String featureValue;
    /////// specification body

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFeatrurName() {
        return featrurName;
    }

    public void setFeatrurName(String featrurName) {
        this.featrurName = featrurName;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }

    public ProductSpecificationModel(int type, String featrurName, String featureValue) {
        this.type = type;
        this.featrurName = featrurName;
        this.featureValue = featureValue;
    }

    public ProductSpecificationModel(int type, String title) {
        this.type = type;
        this.title = title;
    }
}
