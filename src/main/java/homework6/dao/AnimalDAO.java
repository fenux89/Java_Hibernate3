package homework6.dao;


import homework6.entities.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AnimalDAO implements IAnimalDAO {
    @Override
    public void add(Animal animal) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.save(animal);
        session.flush();

        session.getTransaction().commit();

        session.close();
        factory.close();
    }

    @Override
    public List<Animal> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        List<Animal> list = session.createQuery("from Animal", Animal.class).list();

        session.close();
        factory.close();

        return list;
    }

    @Override
    public Animal getById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Animal animal = factory.openSession().get(Animal.class, id);

        factory.close();

        return animal;
    }

    @Override
    public void updateById(long id, Animal animal) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        if (factory.openSession().get(Animal.class, id) != null) {
            Session session = factory.openSession();

            session.beginTransaction();

            animal.setId(id);

            session.update(animal);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }

    @Override
    public void removeById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Animal animal = factory.openSession().get(Animal.class, id);

        if (animal != null) {
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(animal);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }
}
