package ListaAdjacencia;

import java.util.LinkedList;

import Exception.VerticeJaExisteException;
import Exception.VerticeNaoEncontradoException;
import Util.*;

/**
 * Representação de grafos utilizando Lista de Adjacência
 */

public class Grafo {
    private LinkedList<Adjacentes> listaAdjacentes;

    public Grafo() {
        this.listaAdjacentes = new LinkedList<>();
    }

    public Grafo(Vertice... vertices) throws VerticeJaExisteException {
        this.listaAdjacentes = new LinkedList<>();
        for (Vertice vertice : vertices) {
            this.criaExcecaoSeVerticeJaExistir(vertice);
            this.listaAdjacentes.add(new Adjacentes(vertice));
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
        this.listaAdjacentes.add(novoItem);
    }

    /**
     * Remove um vertice do grafo
     * 
     * @param Vertice v
     * @throws VerticeNaoEncontradoException
     */
    public void removerVertice(Vertice v) throws VerticeNaoEncontradoException {
        this.criaExcecaoSeVerticeNaoExistir(v);
        Adjacentes verticesAdjacentes = this.buscaAdjacentes(v);
        this.listaAdjacentes.remove(verticesAdjacentes);
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
        Adjacentes verticesAdjacentes = this.buscaAdjacentes(divergente);
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
        Adjacentes verticesAdjacentes = this.buscaAdjacentes(divergente);
        verticesAdjacentes.removerVertice(covergente);
    }

    /**
     * Busca a lista de adjacencia de um vertice do grafo. Caso nao exista nulo e
     * retornado
     * 
     * @param v
     * @return Vertice | null
     */
    public Adjacentes buscaAdjacentes(Vertice v) throws VerticeNaoEncontradoException {
        return this.listaAdjacentes
                .stream()
                .filter((item) -> item.ehDoVertice(v))
                .findAny()
                .orElseThrow(VerticeNaoEncontradoException::new);
    }

    /**
     * Checa se dois vertices sao adjacentes
     * 
     * @param v1
     * @param v2
     * @return boolean
     */
    public boolean verticesSaoAdjacentes(Vertice v1, Vertice v2) {
        try {
            this.criaExcecaoSeVerticeNaoExistir(v1);
            this.criaExcecaoSeVerticeNaoExistir(v2);

            Adjacentes adjacentesAV1 = this.buscaAdjacentes(v1);
            return adjacentesAV1.existeAdjacencia(v2);
        } catch (VerticeNaoEncontradoException e) {
            return false;
        }
    }

    /**
     * Checa se duas arestas sao adjacentes
     * 
     * @param inicioAresta1
     * @param fimAresta1
     * @param inicioAresta2
     * @param fimAresta2
     * @return boolean
     * @throws VerticeNaoEncontradoException
     */
    public boolean arestasSaoAdjacentes(Vertice inicioAresta1, Vertice fimAresta1, Vertice inicioAresta2,
            Vertice fimAresta2) throws VerticeNaoEncontradoException {
        this.criaExcecaoSeVerticeNaoExistir(inicioAresta1);
        this.criaExcecaoSeVerticeNaoExistir(fimAresta1);
        this.criaExcecaoSeVerticeNaoExistir(inicioAresta2);
        this.criaExcecaoSeVerticeNaoExistir(fimAresta2);

        return inicioAresta1.equals(inicioAresta2) || fimAresta1.equals(inicioAresta2)
                || inicioAresta2.equals(fimAresta1) || fimAresta2.equals(inicioAresta1);
    }

    /**
     * Checa se existe uma aresta entre os dois vertices
     * 
     * @param v1
     * @param v2
     * @return
     */
    public boolean existeAresta(Vertice v1, Vertice v2) {
        try {
            this.criaExcecaoSeVerticeNaoExistir(v1);
            this.criaExcecaoSeVerticeNaoExistir(v2);

            Adjacentes adjacentesAV1 = this.buscaAdjacentes(v1);
            if (adjacentesAV1.existeAdjacencia(v2)) {
                return true;
            }

            Adjacentes adjacentesAV2 = this.buscaAdjacentes(v2);
            return adjacentesAV2.existeAdjacencia(v1);
        } catch (VerticeNaoEncontradoException e) {
            return false;
        }
    }

    /**
     * Levanta uma excecao se o vertice em questao nao existir no grafo
     * 
     * @param v
     * @throws VerticeNaoEncontradoException
     */
    public void criaExcecaoSeVerticeNaoExistir(Vertice v) throws VerticeNaoEncontradoException {
        for (Adjacentes adjacentes : this.listaAdjacentes) {
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
        for (Adjacentes adjacentes : this.listaAdjacentes) {
            if (adjacentes.getVertice().equals(v)) {
                throw new VerticeJaExisteException();
            }
        }
    }
}
