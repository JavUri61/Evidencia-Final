package com.company;

import java.io.*;
import java.util.HashMap;

public class Login {
    HashMap<String, String> users = new HashMap<>();

    public Login() { }

    public void loadUsers() {
        String filename = "users/users.txt";
        File file = new File(filename);

        // Si no existe, lo crea con un usuario por defecto
        if (!file.exists()) {
            try {
                // Asegura que la carpeta "users" exista
                File folder = new File("users");
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                // Crea el archivo y escribe un usuario por defecto
                FileWriter writer = new FileWriter(file);
                writer.write("admin,1234\n");
                writer.close();

                System.out.println("Archivo de usuarios creado con usuario por defecto: admin / 1234");

            } catch (IOException e) {
                System.out.println("Error al crear el archivo de usuarios: " + e.getMessage());
                return;
            }
        }

        // Ahora sí carga los usuarios desde el archivo
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            String user, username, pass;
            while ((user = bufferedReader.readLine()) != null) {
                username = user.substring(0, user.indexOf(','));
                pass = user.substring(user.indexOf(',') + 1);
                this.users.put(username, pass);
            }
        } catch (IOException e) {
            System.out.println("IOException al leer usuarios: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("IOException al cerrar archivo: " + e.getMessage());
            }
        }
    }

    public User checkUser(String username, String password) {
        User loggedUser = new User();

        users.entrySet().forEach(entry -> {
            if (username.equals(entry.getKey()) && password.equals(entry.getValue())) {
                loggedUser.login(username, password);
            }
        });

        return loggedUser;
    }
}
