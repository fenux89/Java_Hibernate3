package homework6.dao;

import homework6.entities.Animal;

import java.util.List;

public interface IAnimalDAO {

    void add(Animal animal);

    List<Animal> getAll();

    Animal getById(long id);

    void updateById(long id, Animal animal);

    void removeById(long id);
}