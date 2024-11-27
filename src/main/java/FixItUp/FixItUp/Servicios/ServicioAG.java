package FixItUp.FixItUp.Servicios;

import FixItUp.FixItUp.Entidad.Agenda;
import FixItUp.FixItUp.Repositorios.RepositoryAG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAG {

    @Autowired
    private RepositoryAG repositorio;

    // Listar todas las agendas
    public List<Agenda> listarAgendas() {
        return repositorio.findAll();
    }

    // Agregar una nueva agenda
    public Agenda agregarAgenda(Agenda agenda) {
        return repositorio.save(agenda);
    }

    // Eliminar una agenda (opcional)
    public boolean eliminarAgenda(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }
}
