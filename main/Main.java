package registropersonas.main; 

import java.util.List;
import registropersonas.dao.PersonaDAO;
import registropersonas.entity.Persona;

public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   REGISTRO DE PERSONAS (CONSULTA JPA - MYSQL)   ");
        System.out.println("==================================================\n");

        PersonaDAO dao = new PersonaDAO();

        try {
            List<Persona> personas = dao.listarPersonas();

            if (personas == null || personas.isEmpty()) {
                System.out.println("No se encontraron registros en la base de datos.");
            } else {
                for (Persona p : personas) {
                    System.out.printf("ID: %-3d | Nombre: %-10s %-10s | Edad: %-2d | Género: %-10s | Fecha Nac: %s%n",
                            p.getId(),
                            p.getNombre(),
                            p.getApellido(),
                            p.getEdad(),
                            p.getGenero(),
                            p.getFechaNacimiento()
                    );
                }
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error al realizar la consulta con JPA:");
            e.printStackTrace();
        } finally {
            dao.cerrar();
        }
    }
}