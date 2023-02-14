Prueba Técnica MBSOLUCIONES
===========================

### PATH API

GET

`/bmsoluciones`

POST

`/bmsoluciones`

JSON EXAMPLE for all

`{ "name": "Ricardo Poblete", "email": "ricardo.ignacio18@hotmail.com", "password": "hunter2", "modiEd":"05-01-2023", "isactive":false, "phones": [ { "number": "1234567", "citycode": "1", "contrycode": "57" } ] }`

PUT

`/bmsoluciones/1`

DELETE

`/bmsoluciones/1`

ISACTIVE

`/bmsoluciones/isActive/1`

Clonar repositorio

Ejecutar el archivo package en la ruta `demo/Lifecycle/package` para la compilación y la creación de la carpeta target

Asegurar de que existe el .jar en carpeta target antes de crear la imagen Docker.

Ejecutar archivo Dockerfile con:

`docker build -t bmsoluciones:1.0`

Una vez creada la imagen Docker

Ejecutar comando `docker images` y copiar el ID de la imagen recien creada.

Para ejecutar la imagen docker, crear contenedor y que se ejecute la aplicación ejecutar:

`docker run |idDdeLaImagen|`

El contenedor deberá estar corriendo con la aplicación ejecutada.