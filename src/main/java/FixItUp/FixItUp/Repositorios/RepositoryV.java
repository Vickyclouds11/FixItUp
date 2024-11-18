package FixItUp.FixItUp.Repositorios;
import FixItUp.FixItUp.Entidad.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface RepositoryV extends JpaRepository<Vendedor, String> {

}
