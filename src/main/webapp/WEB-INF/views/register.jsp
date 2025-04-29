<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Empleado</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Gesti&oacute; de empleados</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/listEmployees.action">Listado de empleados</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-4">
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h3 class="card-title mb-0">Registro de Nuevo Empleado</h3>
        </div>
        <div class="card-body">
            <s:form action="registerEmployee" method="POST" cssClass="form">
                <div class="row g-3">
                    <div class="col-12">
                        <div class="form-group">
                            <s:label for="name" value="Nombre" cssClass="form-label"/>
                            <s:textfield name="name" cssClass="form-control" id="name"/>
                            <s:fielderror fieldName="name" cssClass="text-danger"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <s:label for="email" value="Correo" cssClass="form-label"/>
                            <s:textfield name="email" cssClass="form-control" id="email"/>
                            <s:fielderror fieldName="mail" cssClass="text-danger"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <s:label for="department" value="Departamento" cssClass="form-label"/>
                            <s:textfield name="department" cssClass="form-control" id="deparment"/>
                            <s:fielderror fieldName="department" cssClass="text-danger"/>
                        </div>
                    </div>

                    <div class="col-12 mt-3">
                        <div class="d-grid gap-2">
                            <s:submit value="Registrar" cssClass="btn btn-primary btn-lg"/>
                        </div>
                    </div>
                </div>
            </s:form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>