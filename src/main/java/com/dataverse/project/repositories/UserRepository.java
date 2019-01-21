package com.dataverse.project.repositories;

import com.dataverse.project.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByEmail(String email);

    User findUserByEmail(String email);
}
