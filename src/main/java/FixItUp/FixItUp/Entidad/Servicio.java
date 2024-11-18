package FixItUp.FixItUp.Entidad;

import jakarta.persistence.*;

@Entity
public class Servicio {
    @Id
    private String idS;

    @Column(nullable = false, length = 100)
    private String nombreS;

    @Column(nullable = false, length = 255)
    private String descS;

    @Column (nullable = false, length = 10)
    private String fechaCreacionS;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Servicio() {
    }

    public Servicio(String idS, String nombreS, String descS, String fechaCreacionS, Estado estado) {
        this.idS = idS;
        this.nombreS = nombreS;
        this.descS = descS;
        this.fechaCreacionS = fechaCreacionS;
        this.estado = estado;
    }

    public String getIdS() {
        return idS;
    }

    public void setIdS(String idS) {
        this.idS = idS;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getDescS() {
        return descS;
    }

    public void setDescS(String descS) {
        this.descS = descS;
    }

    public String getFechaCreacionS() {
        return fechaCreacionS;
    }

    public void setFechaCreacionS(String fechaCreacionS) {
        this.fechaCreacionS = fechaCreacionS;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idS='" + idS + '\'' +
                ", nombreS='" + nombreS + '\'' +
                ", descS='" + descS + '\'' +
                ", fechaCreacionS='" + fechaCreacionS + '\'' +
                ", estado=" + estado +
                '}';
    }
}
