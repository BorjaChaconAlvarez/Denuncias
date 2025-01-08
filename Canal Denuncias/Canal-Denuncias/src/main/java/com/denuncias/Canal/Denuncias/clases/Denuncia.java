package com.denuncias.Canal.Denuncias.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // ESTA CLASE SERA UNA TABLA EN LA BASE DE DATOS
public class Denuncia {

    @Id //CLAVE PRIMARIA DE LA TABLA
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GENERACIÓN AUTOMÁTICAMENTE EL ID

    private  Long id; // IDENTIFICADOR UNICO DE CADA DENUNCIA

    private String mensaje; // Campo que almacena el mensaje de la denuncia
    private Boolean revisada;  //Indica si la denuncia ha sido revisada

    public Denuncia() { //Constructor vacio obligado para JPA

    }

    public Denuncia (String mensaje){
        this.mensaje = mensaje; // Asigno el mensaje
        this.revisada = false; // Por defecto la denuncia no esta revisada
    }

    // GETTERS Y SETTERS PARA ACCEDER Y MODIFICAR LOS ATRIBUTOS DE LA CLASE


    public Long getId() {  // Obtener el ID de la denuncia
        return id;
    }

    public String getMensaje() {   // Obtener el mensaje de la denuncia
        return mensaje;
    }

    public void setMensaje(String mensaje) { // Modificar el mensaje de la denuncia
        this.mensaje = mensaje;
    }

    public Boolean getRevisada() {  // Verificar si la denuncia está revisada
        return revisada;
    }

    public void setRevisada(Boolean revisada) {  // Marcar la denuncia como revisada o no
        this.revisada = revisada;
    }
}
