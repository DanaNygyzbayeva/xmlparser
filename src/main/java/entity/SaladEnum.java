package entity;

public enum SaladEnum {

    SALADS("salads"),
    ID("id"),
    SALAD("salad"),
    NAME("name"),
    PRICE("price"),
    CONTENT("content"),
    VEGETABLE("vegetable"),
    DRESSING("dressing"),
    SEASONING("seasoning");

    private String value;
    private SaladEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
