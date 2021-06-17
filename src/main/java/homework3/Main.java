package homework3;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Animal animal = new Animal("Tvarina", 11, true);
//
//        SessionFactory factory = new Configuration()
//                .configure()
//                .buildSessionFactory();
//
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.save(animal);
//        session.flush();
//        session.getTransaction().commit();
//
//        //       List<Animal> list = session.createQuery("from Animal", Animal.class).list();
//
//        session.close();
//        factory.close();

//        for(Animal animal: list) {
//            System.out.println(animal);
//        }

        AnimalService animalService = new AnimalService();
        Animal animal = new Animal("Maxx", 9, false);
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(animal);
        session.flush();
        session.getTransaction().commit();

        session.close();
        factory.close();

        System.out.println(animalService.getAnimal(2));

        animalService.updateAnimal(animal, 3);

        animalService.deleteAnimal(3);

    }
}
