package homework3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AnimalDAOImpl implements AnimalDAO {

    @Override
    public Animal getAnimal(int id) {

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Animal animal = factory.openSession().get(Animal.class, id);
        factory.close();
        return animal;

    }

    @Override
    public void updateAnimal(Animal animal, int id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        if (factory.openSession().get(Animal.class, id) != null) {
            Animal animal2 = animal;
            animal2.setId(id);

            Session session = factory.openSession();
            session.beginTransaction();
            session.update(animal2);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }
        factory.close();

    }

    @Override
    public void deleteAnimal(int id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        if (factory.openSession().get(Animal.class, id) != null) {
            Animal animal = factory.openSession().get(Animal.class, id);


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
