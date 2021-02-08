package com.aindri.demomap;

public class Model {
    String id;
    String name;
    String category;
    String categoryid;
    String address;
    String description;
    String contact;
    String empcode;
    String image;

    public Model() {

    }

    public Model(String id, String name, String category, String categoryid, String address, String description, String contact, String empcode, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.categoryid = categoryid;
        this.address = address;
        this.description = description;
        this.contact = contact;
        this.empcode = empcode;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }

    public String getEmpcode() {
        return empcode;
    }

    public String getImage() {
        return image;
    }
}
