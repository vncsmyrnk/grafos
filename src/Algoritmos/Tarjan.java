package Algoritmos;

import java.util.LinkedList;

import Exception.VerticeNaoEncontradoException;
import Util.Aresta;
import Util.Grafo;
import Util.Vertice;

/**
 * Classe que implementa o algoritmo de Tarjan para a busca de pontos em grafos.
 * https://en.wikipedia.org/wiki/Bridge_(graph_theory)#Tarjan's_bridge-finding_algorithm
 */

public class Tarjan implements IdentificadorPontes {
    private LinkedList<Aresta> arestas;
    private Grafo grafo;
    private int tempo;

    public Tarjan(Grafo g) {
        this.grafo = g;
    }

    public Tarjan() {
    }

    /**
     * Define o grafo para a realizacao dos procedimentos
     */
    public void setGrafo(Grafo g) {
        this.grafo = g;
    }

    /**
     * Percorre os vertices do grafo seguindo o algoritmo de Tarjan procurando por
     * pontes
     * 
     * @return
     * @throws VerticeNaoEncontradoException
     */
    public LinkedList<Aresta> identificaPontes() throws VerticeNaoEncontradoException {
        this.arestas = new LinkedList<>();
        this.tempo = 0;
        for (Vertice v : this.grafo.getVertices()) {
            if (v.getTempoDescoberta() == 0) {
                this.buscaPontes(v, v);
            }
        }
        return this.arestas;
    }

    /**
     * Analisa se um vertice e seus adjacentes sao pontes do grafo
     * 
     * @param v
     * @param pai
     * @throws VerticeNaoEncontradoException
     */
    public void buscaPontes(Vertice v, Vertice pai) throws VerticeNaoEncontradoException {
        v.setLow(++tempo);
        v.setTempoDescoberta(tempo);
        for (Vertice w : this.grafo.adjacentes(v)) {
            if (w.equals(pai)) {
                continue;
            }
            if (w.getTempoDescoberta() == 0) {
                this.buscaPontes(w, v);
                if (v.getTempoDescoberta() < w.getLow()) {
                    this.arestas.add(new Aresta(v, w));
                }
                v.setLow(Math.min(v.getLow(), w.getLow()));
            } else {
                v.setLow(Math.min(v.getLow(), w.getTempoDescoberta()));
            }
        }
    }
}
