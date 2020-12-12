package org.gokapp.trader.common.jpa.repositories;

import org.gokapp.trader.common.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface UserRepository extends CrudRepository<User, String>{
    
}
