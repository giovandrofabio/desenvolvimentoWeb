package br.edu.unoesc.controller;

import br.edu.unoesc.service.FazendaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirFazendaController extends HttpServlet {

    FazendaService fazendaService = new FazendaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        fazendaService.removerFazendaPeloCodigo(Integer.parseInt(req.getParameter("codigo")));
        resp.sendRedirect("/listarfazendas");
    }

}
