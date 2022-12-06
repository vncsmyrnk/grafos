package Algoritmos;

import java.util.LinkedList;

import Exception.VerticeJaAdicionadoComoAdjacente;
import Exception.VerticeJaExisteException;
import Exception.VerticeNaoEncontradoException;
import Util.Aresta;
import Util.Grafo;
import Util.Vertice;

/**
 * Classe que implementa o algoritmo de Fleury
 * https://pt.wikipedia.org/wiki/Algoritmo_de_Fleury
 */

public class Fleury {
    private LinkedList<Aresta> arestas;
    private LinkedList<Aresta> arestasPonte;
    private Grafo grafo;

    public Fleury(Grafo g, IdentificadorPontes identificador)
            throws VerticeNaoEncontradoException, VerticeJaAdicionadoComoAdjacente, VerticeJaExisteException {
        this.grafo = g;
        identificador.setGrafo(g);
        this.arestasPonte = identificador.identificaPontes();
    }

    public LinkedList<Aresta> buscaCaminhoEuleriano() throws VerticeNaoEncontradoException {
        this.arestas = new LinkedList<>();
        for (Vertice v : this.grafo.getVertices()) {
            this.buscaCaminhoEuleriano(v);
        }
        return this.arestas;
    }

    public void buscaCaminhoEuleriano(Vertice v) throws VerticeNaoEncontradoException {
        for (Vertice w : this.grafo.adjacentes(v)) {
            Aresta a = new Aresta(v, w);
            if (!this.arestasPonte.contains(a)) {
                this.arestas.add(a);
                this.buscaCaminhoEuleriano(w);
                break;
            }

        }
    }
}
