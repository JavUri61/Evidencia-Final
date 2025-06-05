package com.company;

import java.util.Scanner;

public class Main {
    private static final int doctor = 0;
    private static final int patient = 1;

    public static void main(String[] args) {
        Scanner write = new Scanner(System.in);

        login(write);

    }

    public static void login(Scanner write){
        String username, password;
        boolean notLogged = true;

        Login x = new Login();

        while (notLogged){
            System.out.println("======================================");
            System.out.println("Bienvenido al sistema");
            System.out.println("======================================");
            System.out.println("Ingresa tu nombre de usuario");
            username = write.next();
            System.out.println("Ingresa tu contraseña:");
            password = write.next();

            x.loadUsers();
            if(x.checkUser(username, password).inSession){
                System.out.println("======================================");
                System.out.println("Bienvenido al sistema " + username  );
                System.out.println("======================================");
                notLogged = false;
                showMenu(write);
            }else {
                System.out.println("Credenciales incorrectas, vuelve a intentarlo");
            }
        }
    }

    public static void showMenu(Scanner write){
        boolean actMenu = true;
        String x, nombre, apellido, especialidad;
        int choiceDoc = 0, choicePat = 0, lengthDocs, lengthPats;

        Database db = new Database();

        db.load(doctor);
        db.load(patient);

        while (actMenu){


            System.out.println("Ingresa el número de opción que desees realizar");
            System.out.println("a) Agregar a un doctor    b) Dar de alta a un paciente     c) Crear una cita     d) Salir");
            x = write.next();

            switch (x){
                case "a":
                    Doctor doc = new Doctor();

                    System.out.println("Ingresa el nombre del doctor");
                    nombre = write.next();
                    System.out.println("Ingresa el apellido del doctor");
                    apellido = write.next();
                    System.out.println("Ingresa la especialidad del doctor");
                    especialidad = write.next();

                    doc.addDoctor(nombre, apellido, especialidad, db);
                    System.out.println("El doctor " + nombre + " " + apellido + " fue creado exitosamente");
                    break;
                case "b":
                    Patient pat = new Patient();
                    System.out.println("Ingresa el nombre del paciente");
                    nombre = write.next();
                    System.out.println("Ingresa el apellido del paciente");
                    apellido = write.next();

                    pat.addPatient(nombre, apellido, db);
                    System.out.println("El paciente " + nombre + " " + apellido + " fue creado exitosamente");
                    break;
                case "c":
                    System.out.println("Ingresa el número del doctor con el que deseas asistir");
                    lengthDocs = db.list(doctor);

                    boolean isValid = false;
                    String fecha, hora;

                    if(lengthDocs > 0){

                        while (!isValid){
                            choiceDoc = write.nextInt();
                            if(choiceDoc > lengthDocs || choiceDoc < 1) {
                                System.out.println("Ingresa un valor válido");
                            }else{
                                isValid = true;
                            }
                        }
                    }else{
                        System.out.println("No hay suficientes doctores registrados para agendar una cita.");
                        break;
                    }

                    System.out.println("Ingresa el número del paciente que acudirá a la cita");

                    isValid = false;
                    lengthPats = db.list(patient);

                    if(lengthPats > 0){

                        while (!isValid){
                            choicePat = write.nextInt();
                            if(choicePat > lengthDocs || choicePat < 1) {
                                System.out.println("Ingresa un valor válido");
                            }else{
                                isValid = true;
                            }
                        }
                    }else{
                        System.out.println("No hay suficientes pacientes registrados para agendar una cita.");
                        break;
                    }

                    System.out.println("Ingresa la fecha de la cita:");
                    fecha = write.next();

                    System.out.println("Ingresa la hora de la cita:");
                    hora = write.next();

                    Doctor docCita = db.getDoctor(choiceDoc);
                    Patient patCita = db.getPatient(choicePat);

                    Appointment cita = new Appointment();
                    cita.createAppointment(docCita, patCita, fecha, hora);



                    break;

                case "d":
                    System.out.println("Gracias por utilizar el sistema, ¡adiós!");
                    actMenu = false;
                    break;
                default:
                    System.out.println("Ingresa un valor válido por favor");
                    break;
            }
        }

    }
}

