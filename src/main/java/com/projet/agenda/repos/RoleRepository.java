package com.projet.agenda.repos;

import com.projet.agenda.model.Authorities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Authorities, Integer> {
}
