<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    Document   : historias
    Created on : 12/07/2022, 21:59:29
    Author     : lean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
        <title>Listado de Historias</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        
        <jsp:include page="/WEB-INF/paginas/comunes/navegacion.jsp"/>

        <jsp:include page="/WEB-INF/paginas/operaciones/listarHistorias.jsp"/>

        <jsp:include page="/WEB-INF/paginas/comunes/pieDePagina.jsp"/>

    </body>
</html>
