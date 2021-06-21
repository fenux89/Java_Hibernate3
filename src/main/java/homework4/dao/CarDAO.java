package homework4.dao;

import homework4.entity.Car;

import java.util.List;

public interface CarDAO {
    void add(Car car);

    List<Car> getAll();

    Car getById(long id);

    void updateCar(long id, Car car);

    void removeCar(long id);

}
