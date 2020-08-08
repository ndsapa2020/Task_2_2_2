package hibernate.service;

import hibernate.dao.DaoCar;
import hibernate.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CarServiceImplementer implements CarService {

    @Autowired
    private DaoCar daoCar;

    @Transactional
    @Override
    public void add(Car car) {
            daoCar.add(car);
    }

    @Transactional
    @Override
    public Car getCar() {
        return null;
    }

    @Transactional
    @Override
    public List<Car> listCars() {
        return daoCar.listCars();
    }
}
