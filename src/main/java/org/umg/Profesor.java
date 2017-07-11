package org.umg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego ROG on 10/07/2017.
 */
public class Profesor {
    private String nombre;
    private String especialidad;
    private List <Estudiante> Estudiantes;

    public Profesor () {
        Estudiantes = new ArrayList<>();
    }

    public Profesor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    //getter and setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Estudiante> getEstudiantes() {
        return Estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        Estudiantes = estudiantes;
    }

    public void addEstudiante(Estudiante e) {
        Estudiantes.add(e);
    }

    public Estudiante estudianteMasDestacado(){
        float promedio = 0;

        Estudiante estudiante = new Estudiante();

        for (Estudiante e:Estudiantes
                ) {
            if(promedio<e.promedioNotas()){
                promedio=e.promedioNotas();
                estudiante=e;
            }
        }

        return estudiante;
    }

}
