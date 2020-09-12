package dev.hardik.userservice.repository;

import dev.hardik.userservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends CrudRepository<SubmissionRepository,Long> {

    List<User> getAllByUser(String id);


    User findBy(String id);





}
