package FixItUp.FixItUp.Servicios;

import FixItUp.FixItUp.Entidad.Agenda;
import FixItUp.FixItUp.Repositorios.AgendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepositorio agendaRepositorio;

    public List<Agenda> obtenerTodasLasCitas() {
        return agendaRepositorio.findAll();
    }

    public Optional<Agenda> obtenerCitaPorId(Long id) {
        return agendaRepositorio.findById(id);
    }

    public Agenda guardarCita(Agenda agenda) {
        return agendaRepositorio.save(agenda);
    }
}
