package br.edu.unoesc.controller;

import br.edu.unoesc.service.AnimalService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirAnimalController extends HttpServlet{
    AnimalService animalService = new AnimalService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        animalService.removerAnimalPeloCodigo(Integer.parseInt(req.getParameter("codigo")));
        resp.sendRedirect("/listaranimais");
    }
}
