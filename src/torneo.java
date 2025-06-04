import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;
        /*
         *  Programa para gestionar programa torneo de futbol CPR
         */

        public class torneo {

            static String[] equipos = new String[8];

            public static void main(String[] args) {
                anadirEquipo();
                visualizarEquipos();
                randomizarPartidos();
                eliminarEquipo();
                visualizarEquipos();
            }

            public static void anadirEquipo() {
                System.out.println("Por favor introduza el nombre del equipo a añadir:");
                for (int i = 0; i < equipos.length; i++) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Introduzca el equipo " + (i + 1));
                    equipos[i] = scanner.next();
                }
            }

            public static void eliminarEquipo() {
                System.out.println("seleccione o numero de equipo que quere eliminar: ");
                Scanner scanner = new Scanner(System.in);
                int equipoAEliminar = scanner.nextInt() - 1;
                if (equipoAEliminar >= 0 && equipoAEliminar < equipos.length && equipos[equipoAEliminar] != null) {
                    // Eliminar el equipo
                    System.out.println("Se ha eliminado el equipo: " + equipos[equipoAEliminar]);
                    equipos[equipoAEliminar] = null;
                } else {
                    System.out.println("Selección inválida.");
                }
            }
            public static void visualizarEquipos (){
                Scanner scanner = new Scanner(System.in);
                for (int i = 0; i < equipos.length; i++) {
                    System.out.println((i + 1) + ". " + equipos[i]);
                }
            }

            public static void randomizarPartidos (){
                Random enfrentamiento = new Random();
                for (int i = equipos.length - 1; i > 0; i--) {
                    int j = enfrentamiento.nextInt(i + 1);
                    String temp = equipos[i];
                    equipos[i] = equipos[j];
                    equipos[j] = temp;
                }
                // Mostramos los enfrentamientos (equipos emparejados)
                System.out.println("Enfrentamientos aleatorios:");
                for (int i = 0; i < equipos.length; i += 2) {
                    if (equipos[i] != null && equipos[i + 1] != null) {
                        System.out.println(equipos[i] + " VS " + equipos[i + 1]);
                    }
                }

            }

        }

