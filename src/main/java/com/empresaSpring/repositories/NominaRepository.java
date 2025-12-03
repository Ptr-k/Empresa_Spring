package com.empresaSpring.repositories;

import com.empresaSpring.models.Nomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, Integer> {
    // no hace falta ingresar nada porque
    // se utiliza el JpaRepository, lo que me ofrece
    // todo lo necesario
}
