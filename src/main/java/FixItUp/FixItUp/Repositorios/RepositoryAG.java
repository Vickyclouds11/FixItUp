package FixItUp.FixItUp.Repositorios;

import FixItUp.FixItUp.Entidad.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAG extends JpaRepository<Agenda, Long> {
    // Aquí pueden ir consultas personalizadas si es necesario
}
