package FixItUp.FixItUp.Controllers;
import FixItUp.FixItUp.DTO.LogIn;
import FixItUp.FixItUp.Servicios.ServicioC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class ControladorLogInC {

    @Autowired
    private ServicioC usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LogIn loginRequest) {
        String result = usuarioService.Iniciosesion(loginRequest);
        if ("Ingreso válido".equals(result)) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(401).body(result);
        }
    }
}