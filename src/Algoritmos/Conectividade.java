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
        int quantidadeComponentes = 0;
        LinkedList<Vertice> vertices = g.getVertices();
        for (Vertice v : vertices) {
            v.cancelaSinalizacao();
        }
        for (Vertice v : vertices) {
            if (v.naoEstaSinalizado()) {
                buscaVerticeAdjacente(g, v);
                quantidadeComponentes++;
                if (quantidadeComponentes == 2) {
                    return false;
                }
            }
        }
        return true;
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
        v.sinaliza();
        for (Vertice adjacente : g.adjacentes(v)) {
            if (adjacente.naoEstaSinalizado()) {
                buscaVerticeAdjacente(g, adjacente);
            }
        }
    }
}
