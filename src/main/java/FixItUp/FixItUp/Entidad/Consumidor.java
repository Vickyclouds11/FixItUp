package FixItUp.FixItUp.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Consumidor {

    @Id
    private String idC;
    

    @Column(nullable = false, length = 50)
    private String nombreC;
    

    @Column(nullable = false, length = 50)
    private String apellidoC;
    

    @Column(nullable = false, length = 50)
    private String usuarioC;
    

    @Column(nullable = false, length = 50)
    private String contraseñaC;
    

    @Column (nullable = false, length = 50)
    private String direccionC;
    

    @OneToMany(mappedBy = "consumidor", cascade = CascadeType.ALL)
     private List<Notificacion> notificaciones;

    public Consumidor() {
    }


    public Consumidor(String idC, String nombreC, String apellidoC, String usuarioC, String contraseñaC, String direccionC) {
        this.idC = idC;
        this.nombreC = nombreC;
        this.apellidoC = apellidoC;
        this.usuarioC = usuarioC;
        this.contraseñaC = contraseñaC;
        this.direccionC = direccionC;
    }



    public String getIdC() {
        return idC;
    }

    public void setIdC(String idC) {
        this.idC = idC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getApellidoC() {
        return apellidoC;
    }

    public void setApellidoC(String apellidoC) {
        this.apellidoC = apellidoC;
    }

    public String getUsuarioC() {
        return usuarioC;
    }

    public void setUsuarioC(String usuarioC) {
        this.usuarioC = usuarioC;
    }

    public String getContraseñaC() {
        return contraseñaC;
    }

    public void setContraseñaC(String contraseñaC) {
        this.contraseñaC = contraseñaC;
    }

    public String getDireccionC() {
        return direccionC;
    }

    public void setDireccionC(String direccionC) {
        this.direccionC = direccionC;
    }

    @Override
    public String toString() {
        return "Consumidor{" +
                "idC='" + idC + '\'' +
                ", nombreC='" + nombreC + '\'' +
                ", apellidoC='" + apellidoC + '\'' +
                ", usuarioC='" + usuarioC + '\'' +
                ", contraseñaC='" + contraseñaC + '\'' +
                ", direccionC='" + direccionC + '\'' +
                '}';
    }
}


