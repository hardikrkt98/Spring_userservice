package dev.hardik.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProblemRepository extends CrudRepository<ProblemRepository,Long> {

    @Override
    <S extends ProblemRepository> S save(S s);

    @Override
    <S extends ProblemRepository> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<ProblemRepository> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);




}
