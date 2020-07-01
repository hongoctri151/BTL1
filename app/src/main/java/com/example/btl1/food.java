package com.example.btl1;

public class food {
    private String description;
    private String image;
    private String menuID;
    private String name;
    private String price;
    public food(){}

    public food(String description, String image, String menuID, String name, String price) {
        this.description = description;
        this.image = image;
        this.menuID = menuID;
        this.name = name;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
