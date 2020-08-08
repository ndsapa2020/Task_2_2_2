package hibernate.service;


import hibernate.model.Car;

import java.util.List;

public interface CarService {
    void add(Car car);
    Car getCar();
    List<Car> listCars();
}
