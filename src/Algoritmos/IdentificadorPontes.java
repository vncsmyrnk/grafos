package Algoritmos;

import java.util.LinkedList;

import Exception.VerticeJaAdicionadoComoAdjacente;
import Exception.VerticeJaExisteException;
import Exception.VerticeNaoEncontradoException;
import Util.Aresta;
import Util.Grafo;

public interface IdentificadorPontes {
    public LinkedList<Aresta> identificaPontes()
            throws VerticeNaoEncontradoException, VerticeJaAdicionadoComoAdjacente, VerticeJaExisteException;

    public void setGrafo(Grafo g);
}
