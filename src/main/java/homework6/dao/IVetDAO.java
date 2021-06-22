package homework6.dao;

import homework6.entities.Vet;

import java.util.List;

public interface IVetDAO {
    void add(Vet vet);

    List<Vet> getAll();

    Vet getById(long id);

    void updateById(long id, Vet vet);

    void removeById(long id);
}
