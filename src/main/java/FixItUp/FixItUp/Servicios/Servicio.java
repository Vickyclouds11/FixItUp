package FixItUp.FixItUp.Servicios;

import Entidad.Administrador;
import Repositorios.repositorio;
import java.util.List;

public class Servicio {
    private repositorio Repositorio = new repositorio();

    public boolean login(String usuario, String contraseña) {
        for (Administrador admin : Repositorio.findAll()) {
            if (admin.getUsuario().equals(usuario) && admin.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public List<Administrador> listarUsuarios() {
        return repositorio.findAll();
    }

    public void agregarUsuario(Administrador administrador) {
        repositorio.save(administrador);
    }

    public boolean actualizarUsuario(Long id, String nuevoUsuario, String nuevaContraseña) {
        Administrador admin = repositorio.findById(id);
        if (admin != null) {
            admin.setUsuario(nuevoUsuario);
            admin.setContraseña(nuevaContraseña);
            return true;
        }
        return false;
    }

    public boolean eliminarUsuario(Long id) {
        return repositorio.deleteById(id);
    }
}
