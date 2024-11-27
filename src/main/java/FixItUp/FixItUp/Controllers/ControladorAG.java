package FixItUp.FixItUp.Controllers;

import FixItUp.FixItUp.Entidad.Agenda;
import FixItUp.FixItUp.Servicios.ServicioAG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://127.0.0.1:5500")
@RestController
@RequestMapping("/Agenda")
public class ControladorAG {

    private final ServicioAG servicio;

    @Autowired
    public ControladorAG(ServicioAG servicio) {
        this.servicio = servicio;
    }

    // Obtener todas las agendas
    @GetMapping
    public List<Agenda> listarAgendas() {
        return servicio.listarAgendas();
    }

    // Crear una nueva agenda
    @PostMapping("/Post")
    public Agenda agregarAgenda(@RequestBody Agenda agenda) {
        return servicio.agregarAgenda(agenda);
    }
}
