package ru.vados.ScaleAppTestWork.repository;

import ru.vados.ScaleAppTestWork.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group,Long> {
}
