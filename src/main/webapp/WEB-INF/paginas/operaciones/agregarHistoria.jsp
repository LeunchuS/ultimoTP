<div class="modal fade" id="agregarLibroModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Historia</h5>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=agregar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="titulo">Titulo</label>
                        <input type="text" class="form-control" name="titulo" required="" size="50">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="texto">Autor</label>
                        <input type="text" class="form-control" name="texto" required="" size="50">
                    </div>
                </div>
                <br>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
