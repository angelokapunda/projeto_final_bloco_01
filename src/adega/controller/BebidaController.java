package adega.controller;

import adega.model.Bebida;
import adega.repository.BebidaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BebidaController implements BebidaRepository {

    ArrayList<Bebida> bebidas = new ArrayList<>();
    private int id = 1;

    @Override
    public void adicionar(Bebida bebida) {
        bebidas.add(bebida);
    }

    @Override
    public void listarTodos() {
        for (var bebida : bebidas) {
            bebida.mostrarInformacoes();
        }
    }

    @Override
    public void atualizar(Bebida bebida) {
        Optional<Bebida> buscaBebida = buscarNaCollection(bebida.getId());

        if (buscaBebida.isPresent()) {
            bebidas.set(bebidas.indexOf(buscaBebida.get()), bebida);
            System.out.printf("A Bebida de ID %d foi atualizada com sucesso!", bebida.getId());
        } else {
            System.out.printf("A Bebida de ID %d não foi encontrada ", bebida.getId());
        }

    }

    @Override
    public void procurarPoId(int id) {
        List<Bebida> bebidaId = bebidas.stream().filter(p -> p.getId() == id)
                .toList();
        if (bebidaId.isEmpty()) {
            System.out.println("Não existe Bebida de Id : " + id);
        }
        for (var bebida : bebidaId) {
            bebida.mostrarInformacoes();
        }
    }

    @Override
    public void Remover(int bebidaId) {
        Optional<Bebida> buscaBebida = buscarNaCollection(bebidaId);

        if (bebidas.remove(buscaBebida.get())) {
            System.out.printf("A Bebida de ID %d foi removida com sucesso!", bebidaId);
        } else {
            System.out.printf("A Bebida de ID %d não foi encontrada ", bebidaId);
        }

    }

    public Optional<Bebida> buscarNaCollection(int numero) {
        for (var bebida : bebidas) {
            if (bebida.getId() == numero) {
                return Optional.of(bebida);
            }
        }
        return Optional.empty();
    }

    public int gerarNumero() {
        return id++;
    }
}
