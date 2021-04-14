package br.edu.unoesc.controller;

import br.edu.unoesc.model.Fazenda;
import br.edu.unoesc.service.FazendaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FazendaController extends HttpServlet {

    FazendaService fazendaService = new FazendaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Fazenda fazenda = new Fazenda();
        if(req.getParameter("codigo") != null){
            fazenda = fazendaService.buscarFazendaPeloCodigo(Integer.valueOf(req.getParameter("codigo"))).orElse(new Fazenda());
        }

        req.setAttribute("fazenda", fazenda);
        RequestDispatcher view = req.getRequestDispatcher("/view/fazenda/cadastro.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Fazenda fazenda = new Fazenda();
        fazenda.setCodigo(converteCodigoParaInteger(req.getParameter("codigo")));
        fazenda.setDescricao(req.getParameter("descricao"));
        fazendaService.inserirAlterarFazenda(fazenda);
        resp.sendRedirect("/listarfazendas");
    }

    private Integer converteCodigoParaInteger(String codigo){
        try {
            return Integer.parseInt(codigo);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
