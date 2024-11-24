package FixItUp.FixItUp.Controllers;

import FixItUp.FixItUp.Entidad.Administrador;
import FixItUp.FixItUp.Servicios.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://127.0.0.1:5501")
@RestController
@RequestMapping("/api") 
public class Controlador {

    private final Servicio servicio;
    private boolean sesionIniciada;

    @Autowired
    public Controlador(Servicio servicio) {
        this.servicio = servicio;
        this.sesionIniciada = false;
    }

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<String> iniciarSesion(@RequestParam String usuario, @RequestParam String contraseña) {
        if (servicio.login(usuario, contraseña)) {
            sesionIniciada = true;
            return ResponseEntity.ok("Inicio de sesión exitoso.");
        } else {
            return ResponseEntity.status(401).body("Error en el inicio de sesión.");
        }
    }

    @GetMapping("/admin")
    public ResponseEntity<List<Administrador>> listarUsuarios() {
        if (sesionIniciada) {
            return ResponseEntity.ok(servicio.listarUsuarios());
        } else {
            return ResponseEntity.status(403).build(); // Retornar error 403 si no está autenticado
        }
    }

    @PostMapping("/admin")
    public ResponseEntity<Administrador> agregar(@RequestBody Administrador administrador) {
        if (sesionIniciada) {
            Administrador nuevoAdministrador = servicio.agregarUsuario(administrador);
            return ResponseEntity.ok(nuevoAdministrador);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable String id, @RequestParam String usuarioActualizado, @RequestParam String contraseñaActualizada) {
        if (sesionIniciada) {
            boolean actualizado = servicio.actualizarUsuario(id, usuarioActualizado, contraseñaActualizada);
            if (actualizado) {
                return ResponseEntity.ok("Usuario actualizado.");
            } else {
                return ResponseEntity.status(404).body("Usuario no encontrado.");
            }
        } else {
            return ResponseEntity.status(403).body("Debe iniciar sesión primero.");
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String id) {
        if (sesionIniciada) {
            boolean eliminado = servicio.eliminarUsuario(id);
            if (eliminado) {
                return ResponseEntity.ok("Usuario eliminado.");
            } else {
                return ResponseEntity.status(404).body("Usuario no encontrado.");
            }
        } else {
            return ResponseEntity.status(403).body("Debe iniciar sesión primero.");
        }
    }
}
