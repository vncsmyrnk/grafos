package Util;

import Exception.VerticeJaAdicionadoComoAdjacente;
import Exception.VerticeNaoEncontradoException;

public interface Grafo {
    public void adicionarAresta(Util.Vertice v1, Util.Vertice v2)
            throws VerticeNaoEncontradoException, VerticeJaAdicionadoComoAdjacente;

    public void removerAresta(Vertice v1, Vertice v2) throws VerticeNaoEncontradoException;

    public boolean verticesSaoAdjacentes(Vertice v1, Vertice v2) throws VerticeNaoEncontradoException;

    public boolean arestasSaoAdjacentes(Vertice vA1, Vertice vA2, Vertice vB1, Vertice vB2)
            throws VerticeNaoEncontradoException;

    public boolean existeAresta(Vertice v1, Vertice v2);

    public int quantidadeVertices();

    public int quantidadeArestas();

    public boolean ehNulo();

    public boolean ehCompleto();
}
