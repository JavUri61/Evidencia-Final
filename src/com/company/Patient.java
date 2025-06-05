package com.company;

public class Patient {

    private static final int patient = 1;
    String id;
    String nombre;
    String apellido;

    public void Patient(){
        this.id = "";
        this.nombre = "";
        this.apellido = "";
    }

    public void addPatient(String name, String lastName, Database x){
        String[] info = new String[2];

        this.nombre = name;
        this.apellido = lastName;

        this.id = (x.getItemId(patient));

        info[0] = this.nombre;
        info[1] = this.apellido;

        x.addItem(patient, this.id, info);

    }

    public void setPatient(String id, String name, String lastName){
        this.id = id;
        this.nombre = name;
        this.apellido = lastName;
    }
}
