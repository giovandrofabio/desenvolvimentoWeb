package br.edu.unoesc.service;

import br.edu.unoesc.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalService {
    private static final List<Animal> ANIMAIS  = new ArrayList<>();

    public void inserirAlterarAnimal(Animal animal) {
        if(animal.getCodigo() != null && buscarAnimalPeloCodigo(animal.getCodigo()).isPresent()){
            ANIMAIS.replaceAll(p -> p.getCodigo().equals(animal.getCodigo()) ? animal : p);
        } else {
            animal.setCodigo(gerarCodigoAnimal());
            ANIMAIS.add(animal);
        }
    }

    private Integer gerarCodigoAnimal(){
        return ANIMAIS.stream().mapToInt(Animal::getCodigo).max().orElse(0) + 1;
    }

    public List<Animal> listarAnimais() {
        return ANIMAIS;
    }

    public Optional<Animal> buscarAnimalPeloCodigo(Integer codigo){
        return ANIMAIS.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }

    public void removerAnimalPeloCodigo(Integer codigo) {
        ANIMAIS.removeIf(p -> p.getCodigo().equals(codigo));
    }

}
