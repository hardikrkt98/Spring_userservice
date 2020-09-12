package dev.hardik.userservice.repository;

import dev.hardik.userservice.model.User;
import dev.hardik.userservice.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {

    VerificationToken findByToken(String token);

    VerificationToken save(User user);

    void deleteByToken(String token);

}
