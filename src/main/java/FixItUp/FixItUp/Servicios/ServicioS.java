package FixItUp.FixItUp.Servicios;
import FixItUp.FixItUp.Entidad.Estado;
import FixItUp.FixItUp.Entidad.Servicio;
import FixItUp.FixItUp.Repositorios.RepositoryS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioS {

    @Autowired
    private RepositoryS repositorio;

    public boolean login(String usuario, String contraseña) {
        for (Servicio serv : repositorio.findAll()) {
        }
        return false;
    }

    public List<Servicio> listarUsuarios() {
        return repositorio.findAll();
    }

    public Servicio agregarUsuario(Servicio serv) {
        return repositorio.save(serv);
    }

    public boolean actualizarUsuario(String idS, String nombreS, String nuevaDescS, String fechaCreacionS, Estado nuevoEstadoS) {
        Servicio serv = repositorio.findById(idS).orElse(null);
        if (serv != null) {
            serv.setDescS(nuevaDescS);
            serv.setEstado(nuevoEstadoS);
            repositorio.save(serv);
            return true;
        }
        return false;
    }

    public boolean eliminarUsuario(String id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }
}

