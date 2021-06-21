package homework4.dao;


import homework4.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class ClientDaoImp implements ClientDAO {


    @Override
    public void addClient(Client client) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.save(client);
        session.flush();

        session.getTransaction().commit();

        session.close();
        factory.close();

    }


    @Override
    public Client getClient(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Client client = factory.openSession().get(Client.class, id);

        factory.close();

        return client;

    }


    @Override
    public List<Client> getAllClients() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        List<Client> list = session.createQuery("from Client", Client.class).list();

        session.close();
        factory.close();

        return list;

    }

    @Override
    public void updateClient(long id, Client client) {

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        if (factory.openSession().get(Client.class, id) != null) {
            Session session = factory.openSession();

            session.beginTransaction();

            client.setId(id);

            session.update(client);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();

    }

    @Override
    public void removeClient(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Client client = factory.openSession().get(Client.class, id);

        if (client != null) {
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(client);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }

}
