package org.gokapp.trader.common.jpa.repositories;

import org.gokapp.trader.common.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gokulr
 *
 */
@Repository
public interface GroupRepository extends CrudRepository<Group, String> {

}
