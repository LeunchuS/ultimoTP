<%-- 
    Document   : listarHistorias
    Created on : 12/07/2022, 22:22:57
    Author     : lean
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="libros">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado</h4>
                    </div>
                    <table class="table table-striped table-dark overflow-scroll">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Titulo</th>
                                <th>Texto</th>
                                <th>Palabras</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="historia" items="${historias}" varStatus="contador">
                                <tr>
                                    <td>${contador.count}</td>
                                    <td>${historia.titulo}</td>
                                    <td>${historia.texto}</td>
                                    <td>${historia.cantidadDePalabras()}</td>
                                    <!-- COMPLETAR HREF CUANDO ESTE TERMINADO JSP EDITAR -->
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&id=${historia.id}" 
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=eliminar&id=${historia.id}" 
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Total Historias</h3>
                        <h4 class="display-4">
                            <i class="fa fa-file-text"></i>
                            ${totalHistorias}
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Palabras</h3>
                        <h4 class="display-4">
                            <i class="fa fa-calculator"></i>
                            ${totalPalabras}

                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>