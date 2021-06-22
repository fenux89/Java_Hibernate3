package homework6.dao;

public interface IDAOFactory {
    IAnimalDAO getAnimalDAO();

    IAviaryDAO getAviaryDAO();

    IVetDAO getVetDAO();
}
