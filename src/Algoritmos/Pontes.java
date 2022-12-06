package Algoritmos;

import java.util.LinkedList;

import Exception.GrafoNaoPossuiPonteException;
import Exception.VerticeJaAdicionadoComoAdjacente;
import Exception.VerticeJaExisteException;
import Exception.VerticeNaoEncontradoException;
import Util.Grafo;
import Util.Vertice;
import Util.Aresta;

/**
 * Calculos e algoritmos relacionados a pontes em grafos. Em teoria dos grafos,
 * uma ponte (também conhecida como aresta-de-corte ou arco de corte ou um
 * istmo) é uma aresta cuja deleção em um grafo aumenta o número de componentes
 * conectados deste
 */

public class Pontes implements IdentificadorPontes {
    private Grafo grafo;

    public Pontes(Grafo g) {
        this.grafo = g;
    }

    public Pontes() {
    }

    /**
     * Define o grafo para a realizacao dos procedimentos
     */
    public void setGrafo(Grafo g) {
        this.grafo = g;
    }

    /**
     * Identifica a aresta ponte de um determinado grafo
     * 
     * @param g
     * @return Aresta
     * @throws VerticeNaoEncontradoException
     * @throws GrafoNaoPossuiPonteException
     * @throws VerticeJaAdicionadoComoAdjacente
     */
    public LinkedList<Aresta> identificaPontes()
            throws VerticeNaoEncontradoException, VerticeJaAdicionadoComoAdjacente,
            VerticeJaExisteException {
        LinkedList<Aresta> arestasPonte = new LinkedList<>();
        int quantidadeInicialComponentes = Conectividade.quantidadeComponentes(this.grafo);
        LinkedList<Aresta> arestas = this.grafo.getArestas();
        for (Aresta a : arestas) {
            Vertice v1 = a.getVertice1();
            Vertice v2 = a.getVertice2();
            this.grafo.removerAresta(v1, v2);
            if (Conectividade.quantidadeComponentes(this.grafo) > quantidadeInicialComponentes) {
                arestasPonte.add(a);
            }
            this.grafo.adicionarAresta(v1, v2);
        }
        return arestasPonte;
    }
}
