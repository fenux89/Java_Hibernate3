package homework4.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Asus on 31.01.2018.
 */
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String model;
    public int price;
    @Transient
    private String mark;
    @Transient
    int markId;

    public Car() {
    }

    public Car(String mark, String model, int price) {
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    public Car(long id, String mark, String model, int price) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && price == car.price && mark.equals(car.mark) && model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, price);
    }
}
