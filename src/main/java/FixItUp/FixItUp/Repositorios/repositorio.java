package FixItUp.FixItUp.Repositorios;



import Entidad.Administrador;
import java.util.ArrayList;
import java.util.List;

public class repositorio {
    private List<Administrador> administradores = new ArrayList<>();

    public List<Administrador> findAll() {
        return administradores;
    }

    public void save(Administrador administrador) {
        administradores.add(administrador);
    }

    public Administrador findById(Long id) {
        for (Administrador admin : administradores) {
            if (admin.getId().equals(id)) {
                return admin;
            }
        }
        return null;
    }

    public boolean deleteById(Long id) {
        return administradores.removeIf(admin -> admin.getId().equals(id));
    }
}
