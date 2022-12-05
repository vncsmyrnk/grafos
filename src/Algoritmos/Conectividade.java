package Algoritmos;

import java.util.LinkedList;

import Exception.VerticeNaoEncontradoException;
import Util.Grafo;
import Util.Vertice;

/**
 * Responsavel por analisar a conectividade de determinados grafos
 */

public class Conectividade {

    /**
     * Checa se um grafo eh conexo. Um grafo é dito conexo se existir pelo menos um
     * caminho entre cada par de vértices do grafo
     * 
     * @param g
     * @return boolean
     * @throws VerticeNaoEncontradoException
     */
    public static boolean ehGrafoConexo(Grafo g) throws VerticeNaoEncontradoException {
        return quantidadeComponentes(g) == 1;
    }

    /**
     * Calcula a quantidade de componentes conexos que existem no grafo. Um
     * componente conexo de um grafo não-dirigido G é o
     * sub­grafo de G induzido por alguma das classes de equivalência da relação
     * ao‑alcance‑de
     * 
     * @param g
     * @return int
     * @throws VerticeNaoEncontradoException
     */
    public static int quantidadeComponentes(Grafo g) throws VerticeNaoEncontradoException {
        int quantidadeComponentes = 0;
        LinkedList<Vertice> vertices = g.getVertices();
        g.desfazSinalizacoesVertices();

        // Realiza busca em profundidade para a contabilizacao de componentes
        for (Vertice v : vertices) {
            if (v.naoFoiDescoberto()) {
                buscaVerticeAdjacente(g, v);
                quantidadeComponentes++;
            }
        }
        return quantidadeComponentes;
    }

    /**
     * Percorre os vertices adjacentes a um vertice de um determinado grafo
     * sinalizado-os
     * 
     * @param g
     * @param v
     * @throws VerticeNaoEncontradoException
     */
    public static void buscaVerticeAdjacente(Grafo g, Vertice v) throws VerticeNaoEncontradoException {
        v.descobre();
        for (Vertice adjacente : g.adjacentes(v)) {
            if (adjacente.naoFoiDescoberto()) {
                buscaVerticeAdjacente(g, adjacente);
            }
        }
    }
}
