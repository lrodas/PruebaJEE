# Sistema de Gestión de Empleados

## Descripción
Sistema de gestión de empleados desarrollado con Spring MVC y Struts 2, que permite el registro y listado de empleados.

## Requisitos Previos
- Java 21
- Maven
- Docker y Docker Compose
- IDE (IntelliJ IDEA recomendado)

## Tecnologías Utilizadas
- Spring MVC
- Struts 2
- MySQL
- Bootstrap 4.5
- Docker

## Configuración del Proyecto

### 1. Clonar el Repositorio
```bash
git clone [URL_DEL_REPOSITORIO]
cd gestion-empleados
```

### 2. Configuración de Base de Datos
Iniciar los servicios con Docker Compose:

```bash
docker-compose up -d
```

El archivo `docker-compose.yml` incluye:
```yaml
version: '3.8'
services:
  mysql:
    image: mysql:8.0
    container_name: empleados_db
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: empleados
      MYSQL_USER: user
      MYSQL_PASSWORD: password
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

### 3. Configuración del Proyecto
Actualizar el archivo `application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/empleados
spring.datasource.username=user
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Compilar el Proyecto
```bash
mvn clean install
```

### 5. Ejecutar la Aplicación
```bash
mvn spring-boot:run
```

## Estructura del Proyecto

src 
├── main 
│ ├── java 
│ │ └── com.example.employees 
│ │ ├── config 
│ │ │ └── ApplicationConfig.java 
│ │ ├── controller 
│ │ │ └── EmployeeController.java 
│ │ ├── model 
│ │ │ └── Employee.java 
│ │ ├── repository 
│ │ │ └── EmployeeRepository.java 
│ │ ├── service 
│ │ │ ├── EmployeeService.java 
│ │ │ └── EmployeeServiceImpl.java
│ │ └── struts 
│ │ │  └── actions 
│ │ │  │  ├── RegisterEmployeeAction.java 
│ │ │  │  └── ListEmployeesAction.java 
│ ├── resources 
│ │ ├── application.properties 
│ │ └── struts.xml 
│ └── webapp 
│ └── WEB-INF 
│ └── views 
│ ├── register.jsp 
│ └── list.jsp 
└── test
│ ├── java
│ │ ├── com.example.employees
│ │ │ ├── service 
│ │ │ │ └── EmployeeServiceTest.java
├── controller
└── EmployeeControllerTest.java

## Funcionalidades
1. **Registro de Empleados**
    - Acceso: `http://localhost:8080/showRegister.action`
    - Campos: Nombre, Email, Departamento

2. **Listado de Empleados**
    - Acceso: `http://localhost:8080/listEmployees.action`
    - Muestra todos los empleados registrados

### 1. Configuración en IntelliJ IDEA
1. Abrir el proyecto en IntelliJ IDEA
2. Ir a **File → Project Structure → Artifacts**
3. Hacer click en **+ → Web Application: Archive → Web Application: Exploded**
4. Configurar el nombre del artefacto

### 2. Configuración de Tomcat
1. Ir a **Run → Edit Configurations**
2. Hacer click en **+ → Tomcat Server → Local**
3. Configurar en la pestaña "Deployment":
    - Hacer click en **+**
    - Seleccionar el artefacto creado
    - Establecer Application Context: `/empleados`
4. En la pestaña "Server":
    - URL: `http://localhost:8080/empleados`
    - Puerto: 8080
   
### 3. Ejecución del Proyecto
1. En IntelliJ IDEA, seleccionar la configuración de Tomcat creada
2. Hacer click en el botón de Run (▶️)
3. La aplicación estará disponible en: `http://localhost:8080/empleados`

### 4. Acceso a Base de Datos Oracle
Para acceder a la base de datos usando SQL Developer o similar:
- Host: localhost
- Puerto: 1521
- SID: XE
- Usuario: SYSTEM
- Contraseña: MyStrongPass123!


## Solución de Problemas

### Base de Datos
Si hay problemas con la conexión a la base de datos:
1. Verificar que el contenedor esté ejecutándose:
```bash
docker ps
```

2. Revisar logs del contenedor:
```bash
docker logs empleados_db
```

### Aplicación
1. Verificar logs de la aplicación:
```bash
tail -f logs/application.log
```

2. Limpiar y reconstruir el proyecto:
```bash
mvn clean install -DskipTests
```

## Contribuir
1. Fork del repositorio
2. Crear rama feature (`git checkout -b feature/AmazingFeature`)
3. Commit cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir Pull Request

## Licencia
[MIT](https://choosealicense.com/licenses/mit/)