package homework4.dao;

import homework4.entity.Car;
import homework4.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CarDaoImp implements CarDAO {

    @Override
    public void add(Car car) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.save(car);
        session.flush();

        session.getTransaction().commit();

        session.close();
        factory.close();
    }

    @Override
    public List<Car> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        List<Car> list = session.createQuery("from Car", Car.class).list();

        session.close();
        factory.close();

        return list;

    }

    @Override
    public Car getById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Car car = factory.openSession().get(Car.class, id);

        factory.close();

        return car;

    }

    @Override
    public void updateCar(long id, Car car) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        if (factory.openSession().get(Car.class, id) != null) {
            Session session = factory.openSession();

            session.beginTransaction();

            car.setId(id);

            session.update(car);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }

    @Override
    public void removeCar(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Car car = factory.openSession().get(Car.class, id);

        if (car != null) {
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(car);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }
}
