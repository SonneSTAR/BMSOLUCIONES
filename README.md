Prueba Técnica MBSOLUCIONES
===========================

PATH API
GET /bmsoluciones
POST /bmsoluciones
PUT /bmsoluciones/1
DELETE /bmsoluciones/1

ISACTIVE /bmsoluciones/isActive/1

Clonar repositorio

Ejecutar el archivo package en la ruta `demo/Lifecycle/package` para la compilación y la creación de la carpeta target

Asegurar de que existe el .jar en carpeta target antes de crear la imagen Docker.

Ejecutar archivo Dockerfile con:

`docker build -t bmsoluciones:1.0`

Una vez creada la imagen Docker

Ejecutar comando `docker images` y copiar el ID de la imagen recien creada.

Para ejecutar la imagen docker:

`docker run |idDdeLaImagen|`

El contenedor deberá estar corriendo con la aplicación ejecutada.