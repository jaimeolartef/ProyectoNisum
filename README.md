# Tecnologias Utilizadas

* Java jdk 1.8 
* FrameWork SprintBoot
* Motor de Base de datos H2
* IDE Intellig

# Para subir el proyecto

* Se debe ejecutar el archivo llamado ProjectCustomerApplication.java que se encuentra en la ruta 'com.example.ProjectCustomer' del proyecto.
* Se debe apuntar el postman a la ruta http://localhost:8080/proyecto/guardar-cliente para guardar un cliente con la siguiente estructa Json

{
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.org",
  "password": "hunter2",
  "phones": [
    {
      "number": "1234567",
      "cityCode": "1",
      "countryCode": "57"
    }
  ]
}
