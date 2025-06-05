Algoritmo Evidencia
	Dimension doctor[5];
	Dimension paciente[2];
	
	user = "user";
	pw = "password";
	inSession = Falso;
	
	Mientras (inSession == Falso)
		Escribir "Ingresa tu nombre de usuario";
		Leer username;
		Escribir "Ingresa tu contraseña";
		Leer password;
	
		Si (user == username && pw == password)
			Escribir "============================================";
			Escribir "Bienvenido " + username;
			Escribir "============================================";
			inSession = Verdadero;
		SiNo
			Escribir "Datos incorrectos, intenta de nuevo";
		FinSi
	FinMientras
	
	Mientras (inSession == Verdadero)

		Escribir "¿Deseas dar de alta a un doctor? 1) Si 0) No";
		Leer answer;
		
		Si (answer == 1)
			Escribir "Ingresa el nombre del doctor";
			Leer nombre;
			Escribir "Ingresa el apellido del doctor";
			Leer apellido;
			Escribir "Ingresa la especialidad del doctor";
			Leer especialidad;
			Escribir "Ingresa la hora de entrada del doctor (Formato de 24 hrs)";
			Leer horaEntrada;
			Escribir "Ingresa la hora de salida del doctor (Formato de 24 hrs)";
			Leer horaSalida;
			
			doctor[0] = nombre;
			doctor[1] = apellido;
			doctor[2] = especialidad;
			doctor[3] = horaEntrada;
			doctor[4] = horaSalida;
			
			Escribir "El doctor ha sido dado de alta"; 
		FinSi
		
		Escribir "¿Deseas dar de alta a un paciente? 1) Si 0) No";
		Leer answer;
		Si (answer == 1)
			Escribir "Ingresa el nombre del paciente";
			Leer nombre;
			Escribir "Ingresa el apellido del paciente";
			Leer apellido;
			
			paciente[0] = nombre;
			paciente[1] = apellido;
			
			Escribir "El paciente ha sido dado de alta"; 
		FinSi
		
		Escribir "¿Deseas crear una cita? 1) Si 0) No";
		Leer answer;
		Si (answer == 1)
			Escribir "¿Deseas crear para el paciente " + paciente[0] + " " + paciente[1] + "? 1) Si 0) No";
			Leer answer;
			Si (answer == 1)
				Escribir "¿Deseas asignarle al doctor " + doctor[0] + " " + doctor[1] + "? 1) Si 0) No";
				Leer answer;
				Si (answer == 1)
					Escribir "Tu cita fue registrada en el sistema";
				FinSi
			FinSi
		FinSi
		
		Escribir "¿Deseas cerrar sesión? 1) Si 0) No";
		Leer answer;
		Si (answer == 1)
			inSession = Falso;
		FinSi
		
	FinMientras
	
FinAlgoritmo

