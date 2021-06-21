package homework4.dao;


import homework4.entity.Client;

import java.util.List;

public class ClientService {

    private ClientDaoImp clientDaoImp = new ClientDaoImp();

    public ClientService() {
    }

    public void addClient(Client client) {
        clientDaoImp.addClient(client);
    }

    public Client getClient(int id) {
        return clientDaoImp.getClient(id);
    }

    public List<Client> getAllClients() {
        return clientDaoImp.getAllClients();
    }

    public void updateClient(long id, Client client) {
        clientDaoImp.updateClient(id, client);
    }

    public void removeClient(long id) {
        clientDaoImp.removeClient(id);
    }

}
