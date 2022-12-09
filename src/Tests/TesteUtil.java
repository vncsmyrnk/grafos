package Tests;

import Exception.VerticeJaExisteException;

/**
 * Rotinas uteis para os processos de testes
 */

public class TesteUtil {
    public static Util.Grafo getInstanciaGrafoPorRepeticaoAtual(int repeticaoTesteAtual, Util.Vertice... vertices)
            throws VerticeJaExisteException {
        switch (repeticaoTesteAtual) {
            case 1:
                return new ListaAdjacencia.Grafo(vertices);
            case 2:
                return new MatrizAdjacencia.Grafo(vertices);
            default:
                return new ListaAdjacencia.Grafo(vertices);
        }
    }
}
