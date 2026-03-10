/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instituto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import model.Alumno;

/**
 *
 * @author 芒果
 */
public class RegistroAlumno {

    static Scanner sc = new Scanner(System.in);

    static void registrar(File registro) throws IOException {
        try {
            FileWriter fw = new FileWriter(registro, true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Introduce tu nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Introduce tu apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Introduce tu edad: ");
            int edad = sc.nextInt();
            sc.nextLine();
            System.out.print("Introduce tu curso: ");
            String curso = sc.nextLine();
            System.out.print("Introduce tu DNI: ");
            String dni = sc.nextLine();
            boolean verificar = checkDni(dni, registro);

            if (verificar) {
                Alumno alumnos = new Alumno(nombre, apellido, edad, curso, dni);

                String alumno = alumnos.toString();

                bw.write(alumno);
                bw.write(System.getProperty("line.separator"));
                bw.flush();
                bw.close();
                System.out.println("Alumno registrado correctamente");
                System.out.println("");
            } else {
                System.out.println("El DNI ya existe.");
            }

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void mostrar(File registro) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(registro);
        BufferedReader br = new BufferedReader(fr);
        try {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public static void eliminar(File registro) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(registro);
        BufferedReader br = new BufferedReader(fr);

        try {
            System.out.print("Introduce el DNI: ");
            String dni = sc.nextLine();

            String linea;
            String contenido = "";
            while ((linea = br.readLine()) != null) {
                if (!linea.contains(dni)) {
                    contenido += linea + System.lineSeparator();
                }
            }
            br.close();

            FileWriter fw = new FileWriter(registro);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(contenido);
            bw.flush();
            bw.close();
            System.out.println("Alumno eliminado correctamente");
            System.out.println("");
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public static void buscarPorDni(File registro) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(registro);
        BufferedReader br = new BufferedReader(fr);
        String linea;

        try {
            System.out.print("Introduce el DNI: ");
            String dni = sc.nextLine();
            while ((linea = br.readLine()) != null) {
                if (linea.contains(dni)) {
                    System.out.println(linea);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static boolean checkDni(String dni, File registro) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(registro);
        BufferedReader br = new BufferedReader(fr);

        String linea;

        while ((linea = br.readLine()) != null) {
            if (linea.contains(dni)) {
                br.close();
                return false;
            }
        }

        br.close();
        return true;
    }
}
