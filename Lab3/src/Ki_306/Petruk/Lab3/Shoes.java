// File: Ki_306/Petruk/Lab3/Shoes.java
package Ki_306.Petruk.Lab3;

/**
 * Абстрактний клас Shoes, що описує основні характеристики та функціональність взуття.
 */
public abstract class Shoes {
    private String brand;
    private double size;
    private String color;
    private boolean laced;
    private boolean worn;
    private double distanceRun;

    /**
     * Конструктор для створення взуття.
     *
     * @param brand Бренд взуття.
     * @param size Розмір взуття.
     * @param color Колір взуття.
     */
    public Shoes(String brand, double size, String color) {
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.laced = false;
        this.worn = false;
        this.distanceRun = 0.0;
    }

    /**
     * Перевіряє, чи потрібно ремонтувати взуття.
     *
     * @return true, якщо взуття пробігло 100 км або більше, і потребує ремонту.
     */
    public boolean needsRepair() {
        return distanceRun >= 100;
    }

    /**
     * Додає дистанцію пробігу до загального пробігу взуття.
     *
     * @param distance Дистанція, що була пробігла.
     */
    protected void addDistance(double distance) {
        this.distanceRun += distance;
    }

    // Геттери та сеттери для атрибутів класу

    public String getBrand() {
        return brand;
    }

    public double getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public boolean isLaced() {
        return laced;
    }

    protected void setLaced(boolean laced) {
        this.laced = laced;
    }

    public boolean isWorn() {
        return worn;
    }

    protected void setWorn(boolean worn) {
        this.worn = worn;
    }

    public double getDistanceRun() {
        return distanceRun;
    }
}
