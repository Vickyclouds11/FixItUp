package FixItUp.FixItUp.Servicios;

import FixItUp.FixItUp.DTO.LogIn;
import FixItUp.FixItUp.Entidad.Vendedor;
import FixItUp.FixItUp.Repositorios.RepositoryV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioV {

    @Autowired
    private RepositoryV repositorio;

    /*public boolean login(String usuario, String contraseña) {
        for (Consumidor consum : repositorio.findAll()) {
            if (consum.getUsuarioC().equals(usuario) && consum.getContraseñaC().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }*/

    public List<Vendedor> listarUsuarios() {
        return repositorio.findAll();
    }

    public Vendedor agregarUsuario(Vendedor vendedor) {
        return repositorio.save(vendedor);
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
            if (listarUsuarios().get(i).getUsuarioV().equals(usuario)) {
                usuarioExiste = true;
                if (listarUsuarios().get(i).getContraseñaV().equals(contraseña) == true) {
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
