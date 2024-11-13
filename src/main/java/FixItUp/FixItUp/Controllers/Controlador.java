package FixItUp.FixItUp.Controllers;

public class Controlador {
  Servicio servicio = new Servicio();

  @GetMapping("/Get")
    public List<Administrador> mostrarLista() {
        return servicio.getContraseña();
    }
  
    @PostMapping("/Post")
    public Contraseña agregar(@RequestBody Contraseña contraseña) {
        return servicio.agregarContraseña(contraseña);
    }

    
    @PutMapping("/{nombre}")
    public String actualizar(@PathVariable String nombre, @RequestBody Contraseña contraseñaActualizada) {
        for (Contraseña contraseña: mostrarLista()) {
            if (contraseña.getNombre().equalsIgnoreCase(nombre)) {
                contraseña.setPassword(contraseñaActualizada.getPassword());
                return "Persona con nombre " + nombre + " ha sido actualizada.";
            }
        }
        return "Persona con nombre " + nombre + " no encontrada.";
    }



    @DeleteMapping("/Delete/{nombre}")
    public String Eliminar(@PathVariable String nombre){
        boolean eliminado = servicio.eliminarContraseña(nombre);
        if (eliminado) {
            return "Persona " + nombre + " eliminada con éxito.";
        } else {
            return "No se encontró ninguna persona con el nombre " + nombre + ".";
        }
    }
  
}
  

  

