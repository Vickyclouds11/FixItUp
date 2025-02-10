package FixItUp.FixItUp.Controllers;

import FixItUp.FixItUp.Entidad.Agenda;
import FixItUp.FixItUp.Servicios.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.util.Optional;

@RestController
@RequestMapping("/agenda")
@CrossOrigin(origins = "http://localhost:5500") // Ajusta según tu frontend
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public List<Agenda> obtenerTodasLasCitas() {
        return agendaService.obtenerTodasLasCitas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> obtenerCitaPorId(@PathVariable Long id) {
        Optional<Agenda> agenda = agendaService.obtenerCitaPorId(id);
        return agenda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Agenda> crearCita(@RequestBody Agenda agenda) {
        Agenda nuevaCita = agendaService.guardarCita(agenda);
        return ResponseEntity.ok(nuevaCita);
    }
}
