package com.lab.variant;

public class fridge {
    private int id; // Додано
    private String name;
    private String imageUrl;
    private String description;
    private double capacity;
    private String material;

    public fridge() {}

    public fridge(int id, String name, String imageUrl, String description, double capacity, String material) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.capacity = capacity;
        this.material = material;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getCapacity() { return capacity; }
    public void setCapacity(double capacity) { this.capacity = capacity; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}
