package FixItUp.FixItUp.Servicios;

public class Servicio {

    ArrayList<Administrador> lista = new ArrayList<>();

    public Servicio() {
        lista.add(new Administrador("Gerardo","daSDJSDJ203"));
        lista.add(new Administrador("Alfredo","DASFMsas32"));
        lista.add(new Administrador("Maria","D3DNass34dsd"));
        lista.add(new Administrador("Julian","ODSsdme392"));
    }

    public ArrayList<Administrador> getContraseña(){
        return lista;
    }

    public Administrador agregarContraseña(Administrador p){
        lista.add(p);
        return p;
    }

    public boolean eliminarContraseña(String nombre) {
        return lista.removeIf(contraseña -> contraseña.getNombre().equalsIgnoreCase(nombre));
    }

}

