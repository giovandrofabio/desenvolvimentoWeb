package br.edu.unoesc.controller;

import br.edu.unoesc.model.Animal;
import br.edu.unoesc.model.Fazenda;
import br.edu.unoesc.service.AnimalService;
import br.edu.unoesc.service.FazendaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AnimalController extends HttpServlet {
    AnimalService animalService = new AnimalService();
    FazendaService fazendaService = new FazendaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Animal animal = new Animal();
        if(req.getParameter("codigo") != null){
            animal = animalService.buscarAnimalPeloCodigo(Integer.valueOf(req.getParameter("codigo"))).orElse(new Animal());
        }

        List<Fazenda> fazendas = fazendaService.listarFazendas();
        req.setAttribute("fazendas", fazendas);

        req.setAttribute("animal", animal);
        RequestDispatcher view = req.getRequestDispatcher("/view/animal/cadastro.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Animal animal = new Animal();
        animal.setCodigo(converteCodigoParaInteger(req.getParameter("codigo")));
        animal.setDescricao(req.getParameter("descricao"));

        FazendaService fazenda = new FazendaService();
        animal.setFazenda(fazenda.getFazendaByCodigo(  Integer.parseInt(req.getParameter("fazenda"))  ));

        animalService.inserirAlterarAnimal(animal);
        resp.sendRedirect("/listaranimais");
    }

    private Integer converteCodigoParaInteger(String codigo){
        try {
            return Integer.parseInt(codigo);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
