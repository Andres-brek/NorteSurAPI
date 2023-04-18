package com.nortesur.nortesur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nortesur.nortesur.entidades.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
