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
    private LinkedList<Vertice> caminho;
    private LinkedList<Aresta> arestasPonte;
    private LinkedList<Aresta> arestasRemovidas;
    private Grafo grafo;

    public Fleury(Grafo g, IdentificadorPontes identificador)
            throws VerticeNaoEncontradoException, VerticeJaAdicionadoComoAdjacente, VerticeJaExisteException {
        this.grafo = g;
        identificador.setGrafo(this.grafo);
        this.arestasPonte = identificador.identificaPontes();
        this.arestasRemovidas = new LinkedList<>();
    }

    /**
     * Utiliza o algoritmo de Fleury para a busca de um caminho euleriano comecando
     * por cada vertice
     * 
     * @return LinkedList<Vertice>
     * @throws VerticeNaoEncontradoException
     */
    public LinkedList<Vertice> buscaCaminhoEuleriano()
            throws VerticeJaExisteException, VerticeJaAdicionadoComoAdjacente, VerticeNaoEncontradoException {
        this.caminho = new LinkedList<>();
        for (Vertice v : this.grafo.getVertices()) {
            this.buscaCaminhoEuleriano(v);
        }
        this.incluiArestasCaminhoRemovidas();
        return this.caminho;
    }

    /**
     * Percorre cada vertice adjacente a partir de um previamente informado criando
     * o caminho euleriano
     * 
     * @throws VerticeNaoEncontradoException
     */
    public void buscaCaminhoEuleriano(Vertice v) throws VerticeNaoEncontradoException {
        for (Vertice w : this.grafo.adjacentes(v)) {
            Aresta a = new Aresta(v, w);
            if (!this.arestasPonte.contains(a)) {
                this.caminho.add(w);
                this.grafo.removerAresta(v, w);
                this.arestasRemovidas.add(a);
                this.buscaCaminhoEuleriano(w);
                break;
            }

        }
    }

    /**
     * Recria as arestas removidas durante o processo de busca pelo caminho
     * euleriano
     */
    private void incluiArestasCaminhoRemovidas()
            throws VerticeJaExisteException, VerticeJaAdicionadoComoAdjacente, VerticeNaoEncontradoException {
        for (Aresta aresta : this.arestasRemovidas) {
            this.grafo.adicionarAresta(aresta.getVertice1(), aresta.getVertice2());
        }
        this.arestasRemovidas = new LinkedList<>();
    }
}
