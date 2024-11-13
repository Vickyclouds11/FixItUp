package FixItUp.FixItUp.Servicios;

import Entidad.Administrador;
import Repositorios.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servicio {

    @Autowired
    private Repositorio repositorio;

    
    public boolean login(String usuario, String contraseña) {
        Optional<Administrador> admin = repositorio.findAll().stream()
                .filter(a -> a.getUsuario().equals(usuario) && a.getContraseña().equals(contraseña))
                .findFirst();
        return admin.isPresent();
    }

    
    public List<Administrador> listarUsuarios() {
        return repositorio.findAll();
    }

    
    public Administrador agregarUsuario(Administrador administrador) {
        return repositorio.save(administrador);
    }

    
    public Administrador actualizarUsuario(Long id, Administrador detallesUsuario) {
        Administrador admin = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        admin.setUsuario(detallesUsuario.getUsuario());
        admin.setContraseña(detallesUsuario.getContraseña());
        return repositorio.save(admin);
    }

    
    public void eliminarUsuario(Long id) {
        repositorio.deleteById(id);
    }
}

