package homework6.dao;

import homework6.entities.Aviary;

import java.util.List;

public interface IAviaryDAO {
    void add(Aviary aviary);

    List<Aviary> getAll();

    Aviary getById(long id);

    void updateById(long id, Aviary aviary);

    void removeById(long id);
}
