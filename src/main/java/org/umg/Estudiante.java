package org.umg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 6/07/2017.
 */
public class Estudiante {

    private String nombre;
    private int edad;
    private List<Asignatura> materias;

    public Estudiante(){
        materias= new ArrayList<>();
    }//Verificar si esto no creara problemas.

    //Getter and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Asignatura> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Asignatura> materias) {
        this.materias = materias;
    }

    public void addMateria(Asignatura a){
        materias.add(a);
    }

    public float promedioNotas(){
        int sumaNotas=0;
        for (Asignatura a : materias
                ) {
            sumaNotas+=a.getNota();
        }
        return sumaNotas/materias.size();
    }

    //Constructor Posiblemente se tendr'a que eliminar.

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
