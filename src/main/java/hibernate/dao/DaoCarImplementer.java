package hibernate.dao;

import hibernate.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DaoCarImplementer implements DaoCar {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        System.out.println("Car " + car + " добавлен в базу данных");
    }

    @Override
    public Car getCar() {
        return null;
    }

    @Override
    public List<Car> listCars() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        TypedQuery<Car> query = session.createQuery("from Car");
        return query.getResultList();
    }
}
