package com.empresaSpring.repositories;

import com.empresaSpring.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    // no hace falta ingresar nada porque
    // se utiliza el JpaRepository, lo que me ofrece
    // todo lo necesario
}
