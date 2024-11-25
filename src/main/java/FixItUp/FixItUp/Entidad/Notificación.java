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

    @ManyToOne
    @JoinColumn(name = "consumidor_id")
     private Consumidor consumidor;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
     private Vendedor vendedor;



    public Notificacion() {
    }

    public Notificacion(String contenido, LocalDate fechaEnvio, Tipo tipo) {
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "Notificacion{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", Contenido=" + contenido +
                ", fechaEnvio=" + fechaEnvio +
                '}';
    }
}


    
