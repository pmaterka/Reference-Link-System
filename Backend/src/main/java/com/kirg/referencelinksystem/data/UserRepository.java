package com.kirg.referencelinksystem.data;


import com.kirg.referencelinksystem.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUserName(String userName);

}