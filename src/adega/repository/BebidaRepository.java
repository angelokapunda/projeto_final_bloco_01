package adega.repository;

import adega.model.Bebida;

public interface BebidaRepository {

    void adicionar(Bebida bebida);

    void listarTodos();

    void atualizar(Bebida bebida);

    void procurarPoId(int id);

    void Remover(int numero);


}
