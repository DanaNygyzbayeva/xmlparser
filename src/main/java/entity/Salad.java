package entity;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private long id;
    private String name;
    private double price;
    private Content content = new Content();

    public Salad() {
    }

    ;

    public Salad(long id, String name, double price, Content content) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Salad{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", content=" + content +
                '}';
    }

    public static class Content {
        private String vegetable;
        private String dressing;
        private String seasoning;

        public String getVegetable() {
            return vegetable;
        }

        public void setVegetable(String vegetable) {
            this.vegetable = vegetable;
        }

        public String getDressing() {
            return dressing;
        }

        public void setDressing(String dressing) {
            this.dressing = dressing;
        }

        public String getSeasoning() {
            return seasoning;
        }

        public void setSeasoning(String seasoning) {
            this.seasoning = seasoning;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "vegetable='" + vegetable + '\'' +
                    ", dressing='" + dressing + '\'' +
                    ", seasoning='" + seasoning + '\'' +
                    '}';
        }
    }
}
