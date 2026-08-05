# Sistema de Inventarios Full Stack

Aplicación web desarrollada para administrar los productos de un inventario. El sistema permite registrar, consultar, editar y eliminar productos mediante una interfaz creada con Angular y una API REST desarrollada con Spring Boot.

Este proyecto fue realizado como parte de mi aprendizaje en desarrollo web Full Stack, aplicando la conexión entre frontend, backend y una base de datos MySQL.

## Funcionalidades

- Mostrar el listado de productos registrados.
- Registrar nuevos productos.
- Consultar productos por su identificador.
- Editar la información de un producto.
- Eliminar productos del inventario.
- Almacenar permanentemente los datos en MySQL.
- Comunicación entre Angular y Spring Boot mediante HTTP.
- Manejo básico de recursos no encontrados.
- Actualización automática del listado después de eliminar un producto.

## Tecnologías utilizadas

### Frontend

- Angular 19
- TypeScript
- HTML5
- Bootstrap 5.3
- RxJS
- Angular Router
- Angular Forms
- Angular HttpClient

### Backend

- Java 26
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- Lombok
- Maven

### Base de datos

- MySQL
- MySQL Workbench

### Herramientas

- Git
- GitHub
- Visual Studio Code o IntelliJ IDEA
- Postman, opcional para probar la API

## Arquitectura del proyecto

El proyecto está dividido en dos aplicaciones principales:

```text
sistema-inventarios-fullstack/
│
├── inventario-app/                # Frontend desarrollado con Angular
│   ├── public/
│   ├── src/
│   │   ├── app/
│   │   │   ├── agregar-producto/
│   │   │   ├── editar-producto/
│   │   │   ├── producto-lista/
│   │   │   ├── producto.service.ts
│   │   │   ├── producto.ts
│   │   │   └── app.routes.ts
│   │   ├── index.html
│   │   └── main.ts
│   ├── angular.json
│   ├── package.json
│   └── package-lock.json
│
├── inventarios/                   # Backend desarrollado con Spring Boot
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/st/inventarios/
│   │   │   │   ├── controlador/
│   │   │   │   ├── excepcion/
│   │   │   │   ├── modelo/
│   │   │   │   ├── repositorio/
│   │   │   │   ├── servicio/
│   │   │   │   └── InventariosApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── pom.xml
│   ├── mvnw
│   └── mvnw.cmd
│
├── .gitignore
└── README.md
```

## Modelo de producto

Cada producto contiene la siguiente información:

| Campo | Tipo | Descripción |
|---|---|---|
| `idProducto` | Integer | Identificador único generado automáticamente |
| `descripcion` | String | Nombre o descripción del producto |
| `precio` | Double | Precio del producto |
| `existencia` | Integer | Cantidad disponible en el inventario |

## Endpoints de la API

La dirección base de la API es:

```text
http://localhost:8080/inventario-app/productos
```

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/inventario-app/productos` | Obtiene todos los productos |
| GET | `/inventario-app/productos/{id}` | Obtiene un producto por su ID |
| POST | `/inventario-app/productos` | Registra un nuevo producto |
| PUT | `/inventario-app/productos/{id}` | Actualiza un producto |
| DELETE | `/inventario-app/productos/{id}` | Elimina un producto |

### Ejemplo para registrar un producto

```json
{
  "descripcion": "Teclado mecánico",
  "precio": 450.00,
  "existencia": 10
}
```

### Ejemplo de respuesta

```json
{
  "idProducto": 1,
  "descripcion": "Teclado mecánico",
  "precio": 450.0,
  "existencia": 10
}
```

## Requisitos previos

Antes de ejecutar el proyecto debes tener instalado:

- Git
- Java 26
- Node.js
- npm
- MySQL Server
- MySQL Workbench, opcional

Puedes verificar las instalaciones con:

```bash
git --version
java -version
node --version
npm --version
mysql --version
```

El backend incluye Maven Wrapper, por lo que no es obligatorio instalar Maven globalmente.

## Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/TU_USUARIO/sistema-inventarios-fullstack.git
```

Ingresar al proyecto:

```bash
cd sistema-inventarios-fullstack
```

### 2. Preparar MySQL

Asegúrate de que el servidor de MySQL esté activo.

La aplicación utiliza la siguiente base de datos:

```text
inventario_db
```

La base de datos se crea automáticamente si todavía no existe, gracias a la configuración:

```text
createDatabaseIfNotExist=true
```

### 3. Configurar las credenciales

En macOS o Linux, define las credenciales de MySQL con variables de entorno:

```bash
export DB_USERNAME=root
export DB_PASSWORD='TU_PASSWORD_DE_MYSQL'
```

También puedes personalizar la conexión completa:

```bash
export DB_URL='jdbc:mysql://localhost:3306/inventario_db?createDatabaseIfNotExist=true'
```

Las variables son utilizadas desde el archivo:

```text
inventarios/src/main/resources/application.properties
```

### 4. Ejecutar el backend

Ingresa a la carpeta del backend:

```bash
cd inventarios
```

En macOS o Linux, ejecuta:

```bash
./mvnw spring-boot:run
```

En Windows, ejecuta:

```bash
mvnw.cmd spring-boot:run
```

Cuando el servidor se inicie correctamente, la API estará disponible en:

```text
http://localhost:8080/inventario-app/productos
```

### 5. Ejecutar el frontend

Abre una terminal nueva y entra a la carpeta del frontend:

```bash
cd inventario-app
```

Instala las dependencias:

```bash
npm install
```

Inicia Angular:

```bash
npm start
```

También puedes utilizar:

```bash
npx ng serve
```

Abre la aplicación en:

```text
http://localhost:4200
```

## Cómo utilizar la aplicación

1. Inicia el servidor de MySQL.
2. Inicia el backend de Spring Boot.
3. Inicia el frontend de Angular.
4. Abre `http://localhost:4200`.
5. Utiliza la opción **Agregar producto** para registrar información.
6. Usa los botones **Editar** y **Eliminar** para administrar los productos.

El frontend se conecta con la API mediante la siguiente dirección:

```text
http://localhost:8080/inventario-app/productos
```

El backend permite solicitudes provenientes de:

```text
http://localhost:4200
```

## Ejecución de pruebas

### Backend

Desde la carpeta `inventarios`:

```bash
./mvnw test
```

### Frontend

Desde la carpeta `inventario-app`:

```bash
npm test
```

### Compilar el frontend

```bash
npm run build
```

Los archivos compilados se generan dentro de la carpeta `dist`.

## Conceptos aplicados

Durante el desarrollo de este proyecto se aplicaron los siguientes conceptos:

- Desarrollo de aplicaciones Full Stack.
- Creación de componentes en Angular.
- Enrutamiento con Angular Router.
- Formularios mediante `ngModel`.
- Consumo de servicios REST con HttpClient.
- Uso de observables con RxJS.
- Arquitectura por capas en Spring Boot.
- Controladores REST.
- Inyección de dependencias.
- Persistencia de información con JPA.
- Implementación de repositorios con `JpaRepository`.
- Mapeo de entidades con Hibernate.
- Operaciones CRUD.
- Conexión entre Spring Boot y MySQL.
- Control de versiones con Git y GitHub.

## Mejoras futuras

- Agregar validaciones a los formularios.
- Mostrar mensajes de confirmación y error.
- Solicitar confirmación antes de eliminar un producto.
- Agregar un buscador de productos.
- Agregar filtros por precio y existencia.
- Implementar paginación.
- Mostrar productos con pocas existencias.
- Agregar categorías de productos.
- Implementar inicio de sesión.
- Agregar roles de administrador y usuario.
- Implementar pruebas unitarias y de integración.
- Publicar el frontend y backend en servicios en la nube.

## Autor

**Samahel Thomas**


Proyecto desarrollado con fines académicos y de aprendizaje.