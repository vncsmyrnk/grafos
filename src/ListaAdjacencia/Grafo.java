package ListaAdjacencia;

import java.util.LinkedList;

import Util.*;

/**
 * Representação de grafos utilizando Lista de Adjacência
 */

public class Grafo {
    private LinkedList<Item> itens;

    public Grafo() {
        this.itens = new LinkedList<>();
    }

    public Grafo(Vertice2... vertices) {
        this.itens = new LinkedList<>();
        for (Vertice2 vertice : vertices) {
            this.itens.add(new Item(vertice));
        }
    }

    public void adicionarVertice(Vertice2 v) {
        Item novoItem = new Item(v);
        this.itens.add(novoItem);
    }

    public void removerVertice(Vertice2 v) {
        Item itemVertice = this.buscaListaItem(v);
        this.itens.remove(itemVertice);
    }

    public void adicionarAresta(Vertice2 divergente, Vertice2 covergente) {
        Item itemVertice = this.buscaListaItem(divergente);
        itemVertice.adicionarVertice(covergente);
    }

    public void removerAresta(Vertice2 divergente, Vertice2 covergente) {
        Item itemVertice = this.buscaListaItem(divergente);
        itemVertice.removerVertice(covergente);
    }

    public Item buscaListaItem(Vertice2 v) {
        return this.itens
                .stream()
                .filter((item) -> item.isItemDoVertice(v))
                .findAny()
                .orElse(null);
    }
}
