package org.umg;

import javax.servlet.annotation.WebServlet;
import javax.xml.soap.Text;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Registration;
import com.vaadin.ui.*;
import javafx.scene.control.SingleSelectionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final HorizontalLayout hlayout = new HorizontalLayout();
        final HorizontalLayout profesoresHLayout= new HorizontalLayout();

        //AREA PROFESORES
        //titulo profesores
        final Label tituloProfesores = new Label();
        tituloProfesores.setValue("Area de Profesores\n");
        //Textfields de profesores
        final Label lblNombreProfesor = new Label();
        final Label lblEspecialidadProfesor= new Label();
        final TextField nombreProfesor = new TextField();
        final TextField especialidadProfesor = new TextField();
        final Button btnAnadirProfesor = new Button();
        Grid<Profesor> gridProfesor = new Grid<>();
        List<Profesor> listadoProfesores = new ArrayList<>();

        gridProfesor.setWidth("100%");
        gridProfesor.setItems(listadoProfesores);
        gridProfesor.addColumn(Profesor::getNombre).setCaption("Nombre Pro.");
        gridProfesor.addColumn(Profesor::getEspecialidad).setCaption("Especialidad");

        lblNombreProfesor.setValue("Nombre del profesor:");
        lblEspecialidadProfesor.setValue("Especialidad");
        btnAnadirProfesor.setCaption("Anadir");

        btnAnadirProfesor.addClickListener(e ->{

            listadoProfesores.add( new Profesor(nombreProfesor.getValue(), especialidadProfesor.getValue()));
            gridProfesor.setItems(listadoProfesores);
            nombreProfesor.clear();
            especialidadProfesor.clear();

        });




        //NUEVA AREA ESTUDIANTES


        //AREA ESTUDIANTES
        final Label lblTituloEstudiantes = new Label();
        lblTituloEstudiantes.setValue("Area Estudiantes");

        final TextField name = new TextField();
        name.setCaption("Nombre:");

        final TextField age = new TextField();
        age.setCaption("Edad:");

        //-------------------------------------------------------------------------------------------------------------

        List<Estudiante> listadoEstudiantes= new ArrayList<>();
        listadoEstudiantes.add(new Estudiante("Alberto", 18));

        Grid<Estudiante> grid = new Grid<>();
        grid.setWidth("100%");
        grid.setItems(listadoEstudiantes);
        grid.addColumn(Estudiante::getNombre).setCaption("Nombre");
        grid.addColumn(Estudiante::getEdad).setCaption("Edad");


        Button button = new Button("Añadir");

        button.addClickListener(e -> {
            listadoEstudiantes.add(new Estudiante(name.getValue(), Integer.parseInt(age.getValue())));
            grid.setItems(listadoEstudiantes);
            name.clear();
            age.clear();
            Notification.show("Estudiante adicionado");



            //Aqui voy
            //int casillaProfesor = gridProfesor.getro
            //Notification.show(String.valueOf(listadoProfesores.contains(gridProfesor.getColumn("Nombre Pro."))));

        });

        profesoresHLayout.addComponents(nombreProfesor, especialidadProfesor, btnAnadirProfesor);
        //hlayout.addComponents();
        hlayout.addComponents(name, age, button);
        hlayout.setComponentAlignment(button, Alignment.BOTTOM_RIGHT);
        layout.addComponents(tituloProfesores, profesoresHLayout, gridProfesor, lblTituloEstudiantes, hlayout, grid);



        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
