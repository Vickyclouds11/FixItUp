package FixItUp.FixItUp.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Vendedor {
    @Id
    private String idV;

    @Column(nullable = false, length = 50)
    private String nombreV;

    @Column(nullable = false, length = 50)
    private String apellidoV;

    @Column (nullable = false, length = 50)
    private String direccionV;

    @Column (nullable = false, length = 50)
    private String servicioPrestadoV;

    @Column (nullable = false)
    private int añosExpV;

    @Column (nullable = false, length = 50)
    private String ciudadV;

    @Column(nullable = false, length = 50)
    private String usuarioV;

    @Column(nullable = false, length = 50)
    private String contraseñaV;

    public Vendedor() {
    }

    public Vendedor(String idV, String nombreV, String apellidoV, String direccionV, String servicioPrestadoV, int añosExpV, String ciudadV, String usuarioV, String contraseñaV) {
        this.idV = idV;
        this.nombreV = nombreV;
        this.apellidoV = apellidoV;
        this.direccionV = direccionV;
        this.servicioPrestadoV = servicioPrestadoV;
        this.añosExpV = añosExpV;
        this.ciudadV = ciudadV;
        this.usuarioV = usuarioV;
        this.contraseñaV = contraseñaV;
    }

    public String getIdV() {
        return idV;
    }

    public void setIdV(String idV) {
        this.idV = idV;
    }

    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public String getApellidoV() {
        return apellidoV;
    }

    public void setApellidoV(String apellidoV) {
        this.apellidoV = apellidoV;
    }

    public String getDireccionV() {
        return direccionV;
    }

    public void setDireccionV(String direccionV) {
        this.direccionV = direccionV;
    }

    public String getServicioPrestadoV() {
        return servicioPrestadoV;
    }

    public void setServicioPrestadoV(String servicioPrestadoV) {
        this.servicioPrestadoV = servicioPrestadoV;
    }

    public int getAñosExpV() {
        return añosExpV;
    }

    public void setAñosExpV(int añosExpV) {
        this.añosExpV = añosExpV;
    }

    public String getCiudadV() {
        return ciudadV;
    }

    public void setCiudadV(String ciudadV) {
        this.ciudadV = ciudadV;
    }

    public String getUsuarioV() {
        return usuarioV;
    }

    public void setUsuarioV(String usuarioV) {
        this.usuarioV = usuarioV;
    }

    public String getContraseñaV() {
        return contraseñaV;
    }

    public void setContraseñaV(String contraseñaV) {
        this.contraseñaV = contraseñaV;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "idV='" + idV + '\'' +
                ", nombreV='" + nombreV + '\'' +
                ", apellidoV='" + apellidoV + '\'' +
                ", direccionV='" + direccionV + '\'' +
                ", servicioPrestadoV='" + servicioPrestadoV + '\'' +
                ", añosExpV=" + añosExpV +
                ", ciudadV='" + ciudadV + '\'' +
                ", usuarioV='" + usuarioV + '\'' +
                ", contraseñaV='" + contraseñaV + '\'' +
                '}';
    }
}
