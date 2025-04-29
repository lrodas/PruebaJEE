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
git clone git@github.com:lrodas/PruebaJEE.git
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
   oracle-db:
      image: container-registry.oracle.com/database/free:latest
      container_name: oracle-db
      ports:
         - "1521:1521"
      environment:
         - ORACLE_PASSWORD=MyStrongPass123!
         - ORACLE_PDB=FREEPDB1  # Nombre correcto de la PDB
      volumes:
         - oracle_data:/opt/oracle/oradata
      healthcheck:
         test: ["CMD", "sqlplus", "-L", "system/MyStrongPass123!@localhost:1521/FREEPDB1"]  # Usar FREEPDB1
         interval: 60s
         timeout: 30s
         retries: 10
         start_period: 300s
      restart: unless-stopped
      deploy:
         resources:
            limits:
               memory: 4G
               cpus: '2.0'

volumes:
   oracle_data:
```

### 3. Configuración del Proyecto
Actualizar el archivo `application.properties`:

### 4. Compilar el Proyecto
```bash
mvn clean install
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