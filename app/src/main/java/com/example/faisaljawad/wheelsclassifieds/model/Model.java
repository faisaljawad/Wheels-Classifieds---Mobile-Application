package com.example.faisaljawad.wheelsclassifieds.model;

public class Model {

    private int Ad_Image;
    private String Ad_Title;
    private String Ad_Description;

    public int getAd_Image() {
        return Ad_Image;
    }

    public void setAd_Image(int ad_Image) {
        Ad_Image = ad_Image;
    }

    public String getAd_Title() {
        return Ad_Title;
    }

    public void setAd_Title(String ad_Title) {
        Ad_Title = ad_Title;
    }

    public String getAd_Description() {
        return Ad_Description;
    }

    public void setAd_Description(String ad_Description) {
        Ad_Description = ad_Description;
    }

    public Model(int ad_Image, String ad_Title, String ad_Description) {
        Ad_Image = ad_Image;
        Ad_Title = ad_Title;
        Ad_Description = ad_Description;
    }
}
