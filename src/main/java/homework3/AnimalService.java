package homework3;

public class AnimalService {

    private AnimalDAOImpl animalDAO = new AnimalDAOImpl();

    public AnimalService() {
    }

    public Animal getAnimal(int id) {
        return animalDAO.getAnimal(id);
    }

    public void updateAnimal(Animal animal, int id) {
        animalDAO.updateAnimal(animal, id);

    }

    public void deleteAnimal(int id) {
        animalDAO.deleteAnimal(id);

    }


}
