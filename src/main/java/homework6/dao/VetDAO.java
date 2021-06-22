package homework6.dao;

import homework6.entities.Vet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class VetDAO implements IVetDAO {
    @Override
    public void add(Vet vet) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.save(vet);
        session.flush();

        session.getTransaction().commit();

        session.close();
        factory.close();
    }

    @Override
    public List<Vet> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        List<Vet> list = session.createQuery("from Vet", Vet.class).list();

        session.close();
        factory.close();

        return list;
    }

    @Override
    public Vet getById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Vet vet = factory.openSession().get(Vet.class, id);

        factory.close();

        return vet;
    }

    @Override
    public void updateById(long id, Vet vet) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        if (factory.openSession().get(Vet.class, id) != null) {
            Session session = factory.openSession();

            session.beginTransaction();

            vet.setId(id);

            session.update(vet);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }

    @Override
    public void removeById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Vet vet = factory.openSession().get(Vet.class, id);

        if (vet != null) {
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(vet);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }
}
