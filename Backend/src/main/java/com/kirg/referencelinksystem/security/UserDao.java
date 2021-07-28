package com.kirg.referencelinksystem.security;

import java.util.Optional;

public interface UserDao {

    Optional<User> selectUserByName(String username);

}