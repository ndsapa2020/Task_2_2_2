package hibernate.dao;

import hibernate.model.Car;

import java.util.List;

public interface DaoCar {
    void add(Car car);
    Car getCar();
    List<Car> listCars();
}
