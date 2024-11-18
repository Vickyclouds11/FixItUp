package FixItUp.FixItUp.Repositorios;
import FixItUp.FixItUp.Entidad.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface RepositoryS extends JpaRepository<Servicio, String> {
}
