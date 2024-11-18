package FixItUp.FixItUp.Repositorios;

import FixItUp.FixItUp.Entidad.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface RepositoryC extends JpaRepository<Consumidor, String> {

}


