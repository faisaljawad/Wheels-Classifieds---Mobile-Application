package com.example.faisaljawad.wheelsclassifieds;

public class Ads_info_class {
    public Ads_info_class() {

    }

    public Ads_info_class(String location, String price, String registration, String mileage, String body_color, String assembly, String description, String modelno) {
        this.location = location;
        this.price = price;
        this.registration = registration;
        this.mileage = mileage;
        this.body_color = body_color;
        this.assembly = assembly;
        this.description = description;
        this.modelno = modelno;
    }

    String location,price,registration,mileage,body_color,assembly,description, modelno;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getBody_color() {
        return body_color;
    }

    public void setBody_color(String body_color) {
        this.body_color = body_color;
    }

    public String getAssembly() {
        return assembly;
    }

    public void setAssembly(String assembly) {
        this.assembly = assembly;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }
}
