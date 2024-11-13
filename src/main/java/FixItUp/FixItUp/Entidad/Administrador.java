package FixItUp.FixItUp.Entidad;


public class Administrador {
    private Long id;
    private String usuario;
    private String contraseña;
    private static Long contadorId = 1L;

    public Administrador(String usuario, String contraseña) {
        this.id = contadorId++;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

   
    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
