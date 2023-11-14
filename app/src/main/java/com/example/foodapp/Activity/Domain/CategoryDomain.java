package com.example.foodapp.Activity.Domain;

public class CategoryDomain {
    private String title;
    private String pic;

    /**
     * Constructor
     */
    public CategoryDomain(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }
    /**
     * Setters and Getters
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
