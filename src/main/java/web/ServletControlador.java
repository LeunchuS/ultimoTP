package web;

import data.HistoriasDAO;
import entity.Historias;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String accion = req.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editar":
                    editarHistoria(req, res);
                    break;
                case "eliminar":
                    eliminarHistoria(req, res);
                    break;
                case "agregar":
                    crearHistoria(req,res);
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "agregar":
                    agregarHistoria(req,res);
                    break;
                case "editar":
                    guardarEdicion(req,res);
                    break;

            }
        }
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        List<Historias> historias = new HistoriasDAO().listar();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("historias", historias);
        sesion.setAttribute("totalHistorias", historias.size());
        sesion.setAttribute("totalPalabras", totalPalabras(historias));
        res.sendRedirect("historias.jsp");
    }

    
    private int totalPalabras(List<Historias> lista) {
        int cantidad = 0;
        for (int i = 0; i < lista.size(); i++) {
            String texto = lista.get(i).getTexto();
            cantidad += (texto.split("\\s+")).length;
        }
        return cantidad;
    }

    private void eliminarHistoria(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String titulo = req.getParameter("titulo");
        String texto = req.getParameter("texto");
        Historias historia = new Historias(id, titulo, texto);
        HistoriasDAO hDAO = new HistoriasDAO();
        hDAO.eliminar(historia);
        accionDefault(req, res);
    }

    private void editarHistoria(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        Historias historia = new HistoriasDAO().buscarPorId(id);
        req.setAttribute("historia", historia);
        req.getRequestDispatcher("/WEB-INF/paginas/operaciones/editarHistoria.jsp").forward(req, res);
    }

    private void guardarEdicion(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String titulo = req.getParameter("titulo");
        String texto = req.getParameter("texto");
        Historias historia = new Historias(id, titulo, texto);
        HistoriasDAO hDAO = new HistoriasDAO();
        hDAO.actualizar(historia);
        accionDefault(req, res);
    }

    private void crearHistoria(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.getRequestDispatcher("/WEB-INF/paginas/operaciones/agregarHistoria.jsp").forward(req, res);
    }
    
    private void agregarHistoria(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        String texto = req.getParameter("texto");
        Historias historia = new Historias(0, titulo, texto);
        HistoriasDAO hDAO = new HistoriasDAO();
        hDAO.agregar(historia);
        accionDefault(req, res);
    }

}
