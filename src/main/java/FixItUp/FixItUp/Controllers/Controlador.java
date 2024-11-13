package FixItUp.FixItUp.Controllers;



import Entidad.Administrador;
import Servicios.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/administrador")
public class Controlador {

    @Autowired
    private Servicio servicio;

 
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String usuario = loginData.get("usuario");
        String contraseña = loginData.get("contraseña");
        boolean success = servicio.login(usuario, contraseña);
        return success ? ResponseEntity.ok("Login exitoso") : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login fallido");
    }

 
    @GetMapping("/usuarios")
    public List<Administrador> listarUsuarios() {
        return servicio.listarUsuarios();
    }


    @PostMapping("/usuarios")
    public Administrador agregarUsuario(@RequestBody Administrador administrador) {
        return servicio.agregarUsuario(administrador);
    }

  
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Administrador> actualizarUsuario(@PathVariable Long id, @RequestBody Administrador detallesUsuario) {
        return ResponseEntity.ok(servicio.actualizarUsuario(id, detallesUsuario));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        servicio.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
