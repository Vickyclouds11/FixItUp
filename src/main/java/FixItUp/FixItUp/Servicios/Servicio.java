package FixItUp.FixItUp.Servicios;

import FixItUp.FixItUp.Entidad.Administrador;
import FixItUp.FixItUp.Repositorios.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Servicio {

    private final Repository repositorio;

    @Autowired
    public Servicio(Repository repositorio) {
        this.repositorio = repositorio;
    }

    public boolean login(String usuario, String contraseña) {
        return repositorio.findAll().stream()
                .anyMatch(admin -> admin.getUsuario().equals(usuario) && admin.getContraseña().equals(contraseña));
    }

    public List<Administrador> listarUsuarios() {
        return repositorio.findAll();
    }

    public Administrador agregarUsuario(Administrador administrador) {
        return repositorio.save(administrador);
    }

    public boolean actualizarUsuario(String id, String nuevoUsuario, String nuevaContraseña) {
        Optional<Administrador> adminOptional = repositorio.findById(id);
        if (adminOptional.isPresent()) {
            Administrador admin = adminOptional.get();
            admin.setUsuario(nuevoUsuario);
            admin.setContraseña(nuevaContraseña);
            repositorio.save(admin);
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

