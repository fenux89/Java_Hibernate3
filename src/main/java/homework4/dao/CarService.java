package homework4.dao;

import homework4.entity.Car;

import java.util.List;

public class CarService {
    private CarDaoImp carDaoImp = new CarDaoImp();

    public CarService() {
    }

    public void add(Car car) {
        carDaoImp.add(car);
    }

    public List<Car> getAll() {
        return carDaoImp.getAll();
    }

    public Car getById(int id) {
        return carDaoImp.getById(id);
    }

    public void updateCar(long id, Car car) {
        carDaoImp.updateCar(id, car);
    }

    public void removeCar(long id) {
        carDaoImp.removeCar(id);
    }


}
