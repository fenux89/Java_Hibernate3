package homework4.dao;


import homework4.entity.Client;

import java.util.List;

public interface ClientDAO {

    void addClient(Client client);

    Client getClient(long id);

    List<Client> getAllClients();

    void updateClient(long id, Client client);

    void removeClient(long id);


}
