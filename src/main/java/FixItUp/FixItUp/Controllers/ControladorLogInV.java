package FixItUp.FixItUp.Controllers;
import FixItUp.FixItUp.DTO.LogIn;
import FixItUp.FixItUp.Servicios.ServicioV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class ControladorLogInV {

    @Autowired
    private ServicioV usuarioService;

    @PostMapping("/loginV")
    public ResponseEntity<String> login(@RequestBody LogIn loginRequest) {
        String result = usuarioService.Iniciosesion(loginRequest);
        if ("Ingreso válido".equals(result)) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(401).body(result);
        }
    }
}

