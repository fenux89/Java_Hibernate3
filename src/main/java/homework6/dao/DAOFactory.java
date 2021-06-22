package homework6.dao;

public class DAOFactory implements IDAOFactory {

    @Override
    public IAnimalDAO getAnimalDAO() {
        return new AnimalDAO();

    }

    @Override
    public IAviaryDAO getAviaryDAO() {
        return new AviaryDAO();
    }

    @Override
    public IVetDAO getVetDAO() {
        return new VetDAO();
    }
}