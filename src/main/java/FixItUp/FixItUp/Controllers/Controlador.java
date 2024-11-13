package FixItUp.FixItUp.Controllers;

import Entidad.Administrador;
import Servicios.Servicio;
import java.util.List;

public class Controlador {
    private Servicio servicio;
    private boolean sesionIniciada;

    public Controlador() {
        this.servicio = new Servicio();
        this.sesionIniciada = false;
    }

    
    public void iniciarSesion(String usuario, String contraseña) {
        if (servicio.login(usuario, contraseña)) {
            sesionIniciada = true;
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Error en el inicio de sesión.");
        }
    }

    
    @GetMapping("/usuarios")
    public void listarUsuarios() {
        if (sesionIniciada) {
            List<Administrador> usuarios = servicio.listarUsuarios();
            System.out.println("Usuarios:");
            for (Administrador admin : usuarios) {
                System.out.println("ID: " + admin.getId() + ", Usuario: " + admin.getUsuario());
            }
        } else {
            System.out.println("Debe iniciar sesión primero.");
        }
    }

    
    @PostMapping("/usuarios")
    public void crearUsuario(String nuevoUsuario, String nuevaContraseña) {
        if (sesionIniciada) {
            Administrador nuevoAdmin = new Administrador(nuevoUsuario, nuevaContraseña);
            servicio.agregarUsuario(nuevoAdmin);
            System.out.println("Usuario creado exitosamente.");
        } else {
            System.out.println("Debe iniciar sesión primero.");
        }
    }

    
    @PutMapping("/usuarios/{id}")
    public void actualizarUsuario(Long id, String usuarioActualizado, String contraseñaActualizada) {
        if (sesionIniciada) {
            boolean actualizado = servicio.actualizarUsuario(id, usuarioActualizado, contraseñaActualizada);
            if (actualizado) {
                System.out.println("Usuario actualizado.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } else {
            System.out.println("Debe iniciar sesión primero.");
        }
    }

    
    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(Long id) {
        if (sesionIniciada) {
            boolean eliminado = servicio.eliminarUsuario(id);
            if (eliminado) {
                System.out.println("Usuario eliminado.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } else {
            System.out.println("Debe iniciar sesión primero.");
        }
    }
}
