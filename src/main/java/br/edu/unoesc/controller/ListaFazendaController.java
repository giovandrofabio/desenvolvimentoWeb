package br.edu.unoesc.controller;

import br.edu.unoesc.model.Fazenda;
import br.edu.unoesc.service.FazendaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaFazendaController extends HttpServlet {
    FazendaService fazendaService = new FazendaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Fazenda> fazendas = fazendaService.listarFazendas();
        req.setAttribute("fazendas", fazendas);
        RequestDispatcher view = req.getRequestDispatcher("/view/fazenda/lista.jsp");
        view.forward(req, resp);
    }
}
