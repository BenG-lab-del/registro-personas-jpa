package registropersonas.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import registropersonas.entity.Persona;

public class PersonaDAO {

    private static final String PERSISTENCE_UNIT_NAME = "registro_personasPU";
    private EntityManagerFactory emf;

    public PersonaDAO() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public List<Persona> listarPersonas() {
        EntityManager em = emf.createEntityManager();
        List<Persona> lista = null;
        try {
            lista = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
        } finally {
            em.close();
        }
        return lista;
    }

    public void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}