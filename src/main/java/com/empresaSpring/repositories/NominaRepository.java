package com.empresaSpring.repositories;

import com.empresaSpring.models.Nomina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominaRepository extends CrudRepository<Nomina, Integer> {
}
