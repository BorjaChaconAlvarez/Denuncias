package com.denuncias.Canal.Denuncias.repositories;

import com.denuncias.Canal.Denuncias.clases.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio que extiende JpaRepository

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    // Métodos CRUD básicos proporcionados automáticamente por JpaRepository

}
