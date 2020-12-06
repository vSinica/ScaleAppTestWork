package ru.vados.ScaleAppTestWork.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vados.ScaleAppTestWork.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

}
