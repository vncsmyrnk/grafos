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

public class Pontes {

    /**
     * Identifica a aresta ponte de um determinado grafo
     * 
     * @TODO Por algum motivo eh necessario chamar essa funcao 2x pra funcionar
     * 
     * @param g
     * @return Aresta
     * @throws VerticeNaoEncontradoException
     * @throws GrafoNaoPossuiPonteException
     * @throws VerticeJaAdicionadoComoAdjacente
     */
    public static LinkedList<Aresta> identificaPontesGrafo(Grafo g)
            throws VerticeNaoEncontradoException, VerticeJaAdicionadoComoAdjacente,
            VerticeJaExisteException {
        LinkedList<Aresta> arestasPonte = new LinkedList<>();
        int quantidadeInicialComponentes = Conectividade.quantidadeComponentes(g);
        LinkedList<Aresta> arestas = g.getArestas();
        for (Aresta a : arestas) {
            Vertice v1 = a.getVertice1();
            Vertice v2 = a.getVertice2();
            g.removerAresta(v1, v2);
            if (Conectividade.quantidadeComponentes(g) > quantidadeInicialComponentes) {
                arestasPonte.add(a);
                // g.adicionarAresta(v1, v2);
                // return a;
            }
            g.adicionarAresta(v1, v2);
        }
        return arestasPonte;
        // throw new GrafoNaoPossuiPonteException();
    }
}
