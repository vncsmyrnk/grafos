package ListaAdjacencia;

import java.util.LinkedList;

import Exception.VerticeJaExisteException;
import Exception.VerticeNaoEncontradoException;
import Util.*;

/**
 * Representação de grafos utilizando Lista de Adjacência
 */

public class Grafo {
    private LinkedList<Adjacentes> adjacentes;

    public Grafo() {
        this.adjacentes = new LinkedList<>();
    }

    public Grafo(Vertice... vertices) throws VerticeJaExisteException {
        this.adjacentes = new LinkedList<>();
        for (Vertice vertice : vertices) {
            this.criaExcecaoSeVerticeJaExistir(vertice);
            this.adjacentes.add(new Adjacentes(vertice));
        }
    }

    /**
     * Adiciona um vertice ao grafo
     * 
     * @param Vertice v
     * @throws VerticeJaExisteException
     */
    public void adicionarVertice(Vertice v) throws VerticeJaExisteException {
        this.criaExcecaoSeVerticeJaExistir(v);
        Adjacentes novoItem = new Adjacentes(v);
        this.adjacentes.add(novoItem);
    }

    /**
     * Remove um vertice do grafo
     * 
     * @param Vertice v
     * @throws VerticeNaoEncontradoException
     */
    public void removerVertice(Vertice v) throws VerticeNaoEncontradoException {
        this.criaExcecaoSeVerticeNaoExistir(v);
        Adjacentes verticesAdjacentes = this.buscaListaItem(v);
        this.adjacentes.remove(verticesAdjacentes);
    }

    /**
     * Adiciona uma aresta entre um vertice convergente e um divergente considerando
     * que o divergente existe no grafo
     * 
     * @param Vertice divergente
     * @param Vertice covergente
     * @throws VerticeNaoEncontradoException
     */
    public void adicionarAresta(Vertice divergente, Vertice covergente) throws VerticeNaoEncontradoException {
        this.criaExcecaoSeVerticeNaoExistir(divergente);
        this.criaExcecaoSeVerticeNaoExistir(covergente);
        Adjacentes verticesAdjacentes = this.buscaListaItem(divergente);
        verticesAdjacentes.adicionarVertice(covergente);
    }

    /**
     * Remove uma aresta entre um vertice convergente e um divergente considerando
     * que o divergente existe no grafo
     * 
     * @param Vertice divergente
     * @param Vertice covergente
     * @throws VerticeNaoEncontradoException
     */
    public void removerAresta(Vertice divergente, Vertice covergente) throws VerticeNaoEncontradoException {
        this.criaExcecaoSeVerticeNaoExistir(divergente);
        this.criaExcecaoSeVerticeNaoExistir(covergente);
        Adjacentes verticesAdjacentes = this.buscaListaItem(divergente);
        verticesAdjacentes.removerVertice(covergente);
    }

    /**
     * Busca a lista de adjacencia de um vertice do grafo. Caso nao exista nulo e
     * retornado
     * 
     * @param v
     * @return Vertice | null
     */
    public Adjacentes buscaListaItem(Vertice v) {
        return this.adjacentes
                .stream()
                .filter((item) -> item.isItemDoVertice(v))
                .findAny()
                .orElse(null);
    }

    /**
     * Confirma se um determinado vertice existe no grafo
     * 
     * @param v
     * @return
     */
    public boolean verticeExists(Vertice v) {
        return this.buscaListaItem(v) != null;
    }

    /**
     * Levanta uma excecao se o vertice em questao nao existir no grafo
     * 
     * @param v
     * @throws VerticeNaoEncontradoException
     */
    public void criaExcecaoSeVerticeNaoExistir(Vertice v) throws VerticeNaoEncontradoException {
        for (Adjacentes adjacentes : this.adjacentes) {
            if (adjacentes.getVertice().equals(v)) {
                return;
            }
        }
        throw new VerticeNaoEncontradoException();
    }

    /**
     * Levanta uma excecao se o vertice em questao nao existir no grafo
     * 
     * @param v
     * @throws VerticeJaExisteException
     */
    public void criaExcecaoSeVerticeJaExistir(Vertice v) throws VerticeJaExisteException {
        for (Adjacentes adjacentes : this.adjacentes) {
            if (adjacentes.getVertice().equals(v)) {
                throw new VerticeJaExisteException();
            }
        }
    }
}
