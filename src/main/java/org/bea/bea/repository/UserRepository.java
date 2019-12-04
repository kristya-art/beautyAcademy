package org.bea.bea.repository;

import org.bea.bea.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    User findByActivationCode(String code);
  //  User findByUsername(String username);
//     void saveUser(User user);
}
