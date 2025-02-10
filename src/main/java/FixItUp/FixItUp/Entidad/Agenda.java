package FixItUp.FixItUp.Entidad;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID de la agenda

    @Column(nullable = false)
    private LocalDateTime fechaHora; // Fecha y hora de la cita

    @Column(nullable = false, length = 100)
    private String municipio; // Municipio

    @Column(nullable = false, length = 255)
    private String direccion; // Dirección

    @ManyToOne
    @JoinColumn(name = "idVendedor", nullable = false)
    private Vendedor vendedor; // Relación con Vendedor

    @ManyToOne
    @JoinColumn(name = "idConsumidor", nullable = false)
    private Consumidor consumidor; // Relación con Consumidor

    @ManyToOne
    @JoinColumn(name = "idServicio", nullable = false)
    private Servicio servicio; // Relación con Servicio

    public Agenda() {
    }

    public Agenda(Long id, LocalDateTime fechaHora, String municipio, String direccion, Vendedor vendedor, Consumidor consumidor, Servicio servicio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.municipio = municipio;
        this.direccion = direccion;
        this.vendedor = vendedor;
        this.consumidor = consumidor;
        this.servicio = servicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }


    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", fechaHora=" + fechaHora +
                ", municipio='" + municipio + '\'' +
                ", direccion='" + direccion + '\'' +
                ", vendedor=" + vendedor +
                ", consumidor=" + consumidor +
                ", servicio=" + servicio +
                '}';
    }
}


