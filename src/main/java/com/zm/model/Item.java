package com.zm.model;

import java.math.BigDecimal;

public class Item {
    private Integer id;

    private String name;

    private BigDecimal price;

    private String pic;

    private Double weight;

    public Item(Integer id, String name, BigDecimal price, String pic, Double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pic = pic;
        this.weight = weight;
    }

    public Item() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", weight=" + weight +
                '}';
    }
}