package br.edu.unoesc.service;

import br.edu.unoesc.model.Fazenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FazendaService {

    private static final List<Fazenda> FAZENDAS = new ArrayList<>();

    public void inserirAlterarFazenda(Fazenda fazenda) {
        if(fazenda.getCodigo() != null && buscarFazendaPeloCodigo(fazenda.getCodigo()).isPresent()){
            FAZENDAS.replaceAll(p -> p.getCodigo().equals(fazenda.getCodigo()) ? fazenda : p);
        } else {
            fazenda.setCodigo(gerarCodigoFazenda());
            FAZENDAS.add(fazenda);
        }
    }

    private Integer gerarCodigoFazenda(){
        return FAZENDAS.stream().mapToInt(Fazenda::getCodigo).max().orElse(0) + 1;
    }

    public List<Fazenda> listarFazendas() {
        return FAZENDAS;
    }

    public Optional<Fazenda> buscarFazendaPeloCodigo(Integer codigo){
        return FAZENDAS.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }

    public Fazenda getFazendaByCodigo(Integer codigo){
        for(Fazenda fazenda : FAZENDAS){
            if(fazenda.getCodigo() == codigo){
                return fazenda;
            }
        }

        return new Fazenda();
    }

    public void removerFazendaPeloCodigo(Integer codigo) {
        FAZENDAS.removeIf(p -> p.getCodigo().equals(codigo));
    }
}