/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instituto;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 芒果
 */
public class RegistroAlumnos {

    static Scanner sc = new Scanner(System.in);
    public static File registro;

    public static void start() throws IOException {
        String rutaAbsoluta = System.getProperty("user.dir");
        String separator = File.separator;

        String src = rutaAbsoluta + separator + "src";
        String carpeta = src + separator + "registroAlumno";

        File carpetaNueva = new File(carpeta);

        if (!(carpetaNueva.exists())) {
            carpetaNueva.mkdir();
        }
        registro = new File(carpetaNueva + separator + "registro.txt");
        if (!(registro.exists())) {
            registro.createNewFile();
        }
    }

    public static void main(String[] args) {
        try {
            start();
            int opc;
            do {
                opc = menu();
                switch (opc) {
                    case 1:
                        RegistroAlumno.registrar(registro);
                        break;
                    case 2:
                        RegistroAlumno.mostrar(registro);
                        break;
                    case 3:
                        RegistroAlumno.eliminar(registro);
                        break;
                    case 4:
                        RegistroAlumno.buscarPorDni(registro);
                        break;
                }
            } while (opc != 5);
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public static int menu() {
        int opc;
        System.out.println("---Menu Principal---");
        System.out.println("1. Agregar un nuevo alumno al registro.");
        System.out.println("2. Mostrar la lista de alumnos registrados.");
        System.out.println("3. Eliminar un alumno del registro.");
        System.out.println("4. Buscar un alumno por su DNI.");
        System.out.println("5. Salir");
        System.out.println("--------------------");

        System.out.print("Ingrese una opcion: ");
        opc = sc.nextInt();
        return opc;
    }
}
