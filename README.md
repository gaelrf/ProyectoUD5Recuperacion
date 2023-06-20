# Trabajo de Recuperación UD5

### Introducción del supuesto

Es una Aplicación para gestionar el personal de un hospital por lo que está **MUY** centrada en el personal.

### Manual de Desarrollador

El proyecto está hecho con Springboot por lo que sigue un MVC.

El Modelo es la base de datos MongoDB hospital, que usa la interfaz MongoRepository para guardar las entidades [Clinica](src/main/java/com/example/proyectoud5recuperacion/entities/Clinica.java), [Paciente](src/main/java/com/example/proyectoud5recuperacion/entities/Paciente.java) y [Personal](src/main/java/com/example/proyectoud5recuperacion/entities/Personal.java).

La Vista son las diferentes templates de Spring que se muestran por pantalla, para recoger los datos usamos [ClinicaData](src/main/java/com/example/proyectoud5recuperacion/data/ClinicaData.java), [PacienteData](src/main/java/com/example/proyectoud5recuperacion/data/PacienteData.java) y [PersonalData](src/main/java/com/example/proyectoud5recuperacion/data/PersonalData.java).

El Controlador se encarga de procesar los Datos para que puedan ser mostrados o guardados.

### Manual de Usuario

La aplicación empieza con una lista de empleados que podemos añadir, ver sus detalles, modificar o borrar.

Al añadir of modificar podemos ver el formulario para meter los datos que es muy simple.

Al ver detalles vemos todos los datos del empleado, que clínica tenemos asignada y la lista de pacientes.

Aquí también podemos gestionar la clínica del empleado, añadir si no tiene, o ver sus detalles, modificarla y borrarla si tiene.

Para gestionar los pacientes desde aquí podemos crear y añadir un paciente, añadir un paciente ya existente, modificar un paciente de ese médico, quitar un paciente de la lista de pacientes del empleado, quitar un paciente y borrarlo o modificarlo.

Al añadir un paciente vemos la lista de pacientes que no están asociados al empleado que estamos gestionar y podemos añadirlos al empleado, borrarlos, o modificarlos.

### Propuestas de Mejora

- Que el ObjectID no vaya en la URL.
- Tener un Log In que funcione de verdad.

### Conclusión

FUe un proyecto diferente que me permitió ver un poco más como va spring y como se puede adaptar a diferentes tecnologías.