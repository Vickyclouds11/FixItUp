package FixItUp.FixItUp.Controllers;


import FixItUp.FixItUp.Entidad.Consumidor;
import FixItUp.FixItUp.Servicios.ServicioC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("http://127.0.0.1:5501")
  
@RestController
public class ControladorC {

    private final ServicioC servicio;
    private boolean sesionIniciada;


    @Autowired
    public ControladorC(ServicioC servicio) {
        this.servicio = servicio;
        this.sesionIniciada = false;
    }

    /*@PostMapping("/iniciar-sesion")
    public String iniciarSesion(@RequestParam String usuario, @RequestParam String contraseña) {
        if (servicio.login(usuario, contraseña)) {
            sesionIniciada = true;
            return "Inicio de sesión exitoso.";
        } else {
            return "Error en el inicio de sesión.";
        }
    }*/

    @GetMapping("/Consumidor")
    public List<Consumidor> listarUsuarios() {
        return servicio.listarUsuarios();
    }

    @PostMapping("/Post/Consumidor")
    public Consumidor agregar(@RequestBody Consumidor consumidor) {
        return servicio.agregarUsuario(consumidor);
    }

    /*@PutMapping("/usuarios/{id}")
    public void actualizarUsuario(@PathVariable String id, @RequestParam String usuarioActualizado, @RequestParam String contraseñaActualizada) {
        if (sesionIniciada) {
            boolean actualizado = servicio.actualizarUsuario(id, usuarioActualizado, contraseñaActualizada);
            if (actualizado) {
                System.out.println("Usuario actualizado.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } else {
            System.out.println("Debe iniciar sesión primero.");
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable String id) {
        if (sesionIniciada) {
            boolean eliminado = servicio.eliminarUsuario(id);
            if (eliminado) {
                System.out.println("Usuario eliminado.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } else {
            System.out.println("Debe iniciar sesión primero.");
        }
    }*/
}

