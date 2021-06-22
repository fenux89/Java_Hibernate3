package homework6.dao;

import homework6.entities.Animal;
import homework6.entities.Aviary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AviaryDAO implements IAviaryDAO {
    @Override
    public void add(Aviary aviary) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.save(aviary);
        session.flush();

        session.getTransaction().commit();

        session.close();
        factory.close();
    }

    @Override
    public List<Aviary> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        List<Aviary> list = session.createQuery("from Aviary", Aviary.class).list();

        session.close();
        factory.close();

        return list;
    }

    @Override
    public Aviary getById(long id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Aviary aviary = factory.openSession().get(Aviary.class, id);

        factory.close();

        return aviary;
    }

    @Override
    public void updateById(long id, Aviary aviary) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        if (factory.openSession().get(Aviary.class, id) != null) {
            Session session = factory.openSession();

            session.beginTransaction();

            aviary.setId(id);

            session.update(aviary);
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

        Aviary aviary = factory.openSession().get(Aviary.class, id);

        if (aviary != null) {
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(aviary);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }
}
