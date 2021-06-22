package homework6;

import homework6.dao.*;
import homework6.entities.Animal;
import homework6.entities.Aviary;
import homework6.entities.Vet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IAnimalDAO animalDAO = new DAOFactory().getAnimalDAO();
        IAviaryDAO aviaryDAO = new DAOFactory().getAviaryDAO();
        IVetDAO vetDAO = new DAOFactory().getVetDAO();


        for (int i = 0; i < 10; i++) {
            animalDAO.add(new Animal("Cat" + i, 9 + i, true));
            aviaryDAO.add(new Aviary("Fly" + i, 100 * i));
            vetDAO.add(new Vet("Max" + i, "(987)874587" + i, "Dom" + i));
        }

        for (int i = 1; i < 10; i++) {
            Animal animal;
            animal = animalDAO.getById(i);
            animal.setVet(vetDAO.getById(i));
            animal.setAviary(aviaryDAO.getById(i));
            animalDAO.updateById(i, animal);
        }

        for (int i = 11; i < 21; i++) {
            Animal animal1 = new Animal("Cat" + i, 9 + i, true);
            animalDAO.add(animal1);
            animal1 = animalDAO.getById(i);
            animal1.setVet(vetDAO.getById(1));
            animal1.setAviary(aviaryDAO.getById(1));
            animalDAO.updateById(i, animal1);

        }

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        Vet vet = session.get(Vet.class, 1l);
        Aviary aviary = session.get(Aviary.class, 2l);


        session.close();
        factory.close();

        List<Animal> list = vet.getAnimals();
        List<Animal> list2 = aviary.getAnimals();

        System.out.println();
        System.out.println();
        System.out.println(list);
        System.out.println();
        System.out.println(list2);
        System.out.println();
        System.out.println();
    }


}
