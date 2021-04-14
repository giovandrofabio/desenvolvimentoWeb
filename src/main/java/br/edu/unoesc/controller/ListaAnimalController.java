package br.edu.unoesc.controller;

import br.edu.unoesc.model.Animal;
import br.edu.unoesc.service.AnimalService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaAnimalController extends HttpServlet {
    AnimalService animalService = new AnimalService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Animal> animais = animalService.listarAnimais();
        req.setAttribute("animais", animais);
        RequestDispatcher view = req.getRequestDispatcher("/view/animal/lista.jsp");
        view.forward(req, resp);
    }
}
