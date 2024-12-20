package FixItUp.FixItUp.Servicios;

import FixItUp.FixItUp.DTO.LogIn;
import FixItUp.FixItUp.Entidad.Consumidor;
import FixItUp.FixItUp.Repositorios.RepositoryC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioC {

    @Autowired
    private RepositoryC repositorio;

    /*public boolean login(String usuario, String contraseña) {
        for (Consumidor consum : repositorio.findAll()) {
            if (consum.getUsuarioC().equals(usuario) && consum.getContraseñaC().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }*/

    public List<Consumidor> listarUsuarios() {
        return repositorio.findAll();
    }

    public Consumidor agregarUsuario(Consumidor consumidor) {
        return repositorio.save(consumidor);
    }

   /* public boolean actualizarUsuario(String id, String nombreC, String apellidoC, String nuevoUsuarioC, String nuevaContraseñaC, String nuevaDireccionC) {
        Consumidor consum = repositorio.findById(id).orElse(null);
        if (consum != null) {
            consum.setUsuarioC(nuevoUsuarioC);
            consum.setContraseñaC(nuevaContraseñaC);
            consum.setDireccionC(nuevaContraseñaC);

            repositorio.save(consum);
            return true;
        }
        return false;
    }*/

    public boolean eliminarUsuario(String id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }

    public String Iniciosesion(LogIn objeto) {
        Boolean usuarioExiste = false;
        String usuario = objeto.getUsuario();
        String contraseña = objeto.getContraseña();

        for (int i = 0; i < listarUsuarios().size(); i++) {
            if (listarUsuarios().get(i).getUsuarioC().equals(usuario)) {
                usuarioExiste = true;
                if (listarUsuarios().get(i).getContraseñaC().equals(contraseña) == true) {
                    return "Ingreso válido";
                } else {
                    return "Contraseña incorrecta";
                }
            }
        }
        if (usuarioExiste == false) {
            return "Usuario no encontrado";
        }

        return "";
    }

}


