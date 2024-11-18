package FixItUp.FixItUp.Repositorios;

import FixItUp.FixItUp.Entidad.Administrador;


import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Administrador, String> {

}
