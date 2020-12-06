package ru.vados.ScaleAppTestWork.repository;

import org.springframework.data.jpa.repository.Query;
import ru.vados.ScaleAppTestWork.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vados.ScaleAppTestWork.model.Student;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group,Long> {

    public Group findByGroupNumber(String groupNumber);

}
