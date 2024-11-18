package FixItUp.FixItUp.Entidad;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String contenido;

    @Column(nullable = false)
    private LocalDate fechaEnvio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipo tipo;


    public Notificacion() {
    }

    public Notificacion(String contenido, LocalDate fechaEnvio, Tipo tipo) {
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.tipo = tipo;
    }

    
