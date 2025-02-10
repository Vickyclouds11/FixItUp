package FixItUp.FixItUp.Repositorios;

import FixItUp.FixItUp.Entidad.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepositorio extends JpaRepository<Agenda, Long> {
}

