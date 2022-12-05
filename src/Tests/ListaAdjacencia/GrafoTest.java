package Tests.ListaAdjacencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Exception.VerticeJaAdicionadoComoAdjacente;
import Exception.VerticeJaExisteException;
import Exception.VerticeNaoEncontradoException;
import ListaAdjacencia.*;
import Util.*;
import ListaAdjacencia.Grafo;

public class GrafoTest {
    Vertice vA;
    Vertice vB;
    Vertice vC;
    Vertice vD;
    Vertice vE;

    Grafo g;

    @Before
    public void initialize() throws VerticeJaExisteException {
        this.vA = new Vertice("A");
        this.vB = new Vertice("B");
        this.vC = new Vertice("C");
        this.vD = new Vertice("D");
        this.vE = new Vertice("E");

        this.g = new Grafo(vA, vB, vC, vD, vE);
    }

    @Test
    public void testGrafoAdicionarAresta() throws Exception {
        g.adicionarAresta(vA, vB);

        Adjacentes listaEsperadaVerticesAdjacentesA = new Adjacentes(vA);
        listaEsperadaVerticesAdjacentesA.adicionarVertice(vB);

        Adjacentes listaVerticesAdjacentesA = g.buscaListaAdjacentes(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));
    }

    @Test
    public void testGrafoAdicionarVariasArestas() throws Exception {
        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        g.adicionarAresta(vB, vD);
        g.adicionarAresta(vB, vE);

        g.adicionarAresta(vC, vB);
        g.adicionarAresta(vC, vD);

        g.adicionarAresta(vD, vE);

        Adjacentes listaEsperadaVerticesAdjacentesA = new Adjacentes(vA);
        listaEsperadaVerticesAdjacentesA.adicionarVertice(vB);
        listaEsperadaVerticesAdjacentesA.adicionarVertice(vC);

        Adjacentes listaVerticesAdjacentesA = g.buscaListaAdjacentes(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));

        Adjacentes listaEsperadaVerticesAdjacentesB = new Adjacentes(vB);
        listaEsperadaVerticesAdjacentesB.adicionarVertice(vA);
        listaEsperadaVerticesAdjacentesB.adicionarVertice(vD);
        listaEsperadaVerticesAdjacentesB.adicionarVertice(vE);
        listaEsperadaVerticesAdjacentesB.adicionarVertice(vC);

        Adjacentes listaVerticesAdjacentesB = g.buscaListaAdjacentes(vB);

        assertTrue(listaEsperadaVerticesAdjacentesB.equals(listaVerticesAdjacentesB));

        Adjacentes listaEsperadaVerticesAdjacentesC = new Adjacentes(vC);
        listaEsperadaVerticesAdjacentesC.adicionarVertice(vA);
        listaEsperadaVerticesAdjacentesC.adicionarVertice(vB);
        listaEsperadaVerticesAdjacentesC.adicionarVertice(vD);

        Adjacentes listaVerticesAdjacentesC = g.buscaListaAdjacentes(vC);

        assertTrue(listaEsperadaVerticesAdjacentesC.equals(listaVerticesAdjacentesC));

        Adjacentes listaEsperadaVerticesAdjacentesD = new Adjacentes(vD);
        listaEsperadaVerticesAdjacentesD.adicionarVertice(vB);
        listaEsperadaVerticesAdjacentesD.adicionarVertice(vC);
        listaEsperadaVerticesAdjacentesD.adicionarVertice(vE);

        Adjacentes listaVerticesAdjacentesD = g.buscaListaAdjacentes(vD);

        assertTrue(listaEsperadaVerticesAdjacentesD.equals(listaVerticesAdjacentesD));

        Adjacentes listaEsperadaVerticesAdjacentesE = new Adjacentes(vE);
        listaEsperadaVerticesAdjacentesE.adicionarVertice(vB);
        listaEsperadaVerticesAdjacentesE.adicionarVertice(vD);

        Adjacentes listaVerticesAdjacentesE = g.buscaListaAdjacentes(vE);

        assertTrue(listaEsperadaVerticesAdjacentesE.equals(listaVerticesAdjacentesE));
    }

    @Test(expected = VerticeJaAdicionadoComoAdjacente.class)
    public void testGrafoAdicionarDuasArestasIguais() throws Exception {
        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vB);
    }

    @Test
    public void testGrafoRemoverAresta() throws Exception {
        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        g.removerAresta(vA, vB);

        Adjacentes listaEsperadaVerticesAdjacentesA = new Adjacentes(vA);
        listaEsperadaVerticesAdjacentesA.adicionarVertice(vC);

        Adjacentes listaVerticesAdjacentesA = g.buscaListaAdjacentes(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));
    }

    // Teste comentado para analise da criacao de ocorrencias, considerando que tem
    // q ser possivel rodar os algoritmos em matriz tb
    // @Test(expected = VerticeNaoEncontradoException.class)
    // public void testGrafoAdicionarArestaEmVerticeNaoExistente() throws Exception
    // {
    // Grafo h = new Grafo(vA, vB);
    // h.adicionarAresta(vA, vC);
    // }

    @Test(expected = VerticeNaoEncontradoException.class)
    public void testCriarGrafoRemoverVerticeInexistente() throws Exception {
        Grafo h = new Grafo(vA);
        h.removerVertice(vB);
    }

    @Test(expected = VerticeJaExisteException.class)
    public void testCriarGrafoComVerticeDuplicado() throws Exception {
        Vertice vA = new Vertice("A");
        new Grafo(vA, vA);
    }

    @Test(expected = VerticeJaExisteException.class)
    public void testGrafoAdicionarVerticeDuplicado() throws Exception {
        g.adicionarVertice(vA);
    }

    @Test
    public void testGrafoVerticesAdjacentes() throws Exception {
        g.adicionarAresta(vA, vB);
        assertTrue(g.verticesSaoAdjacentes(vA, vB));
    }

    @Test
    public void testGrafoVerticesNaoAdjacentes() throws Exception {
        g.adicionarAresta(vA, vB);
        assertFalse(g.verticesSaoAdjacentes(vA, vC));
    }

    @Test
    public void testGrafoArestasAdjacentes() throws Exception {
        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        assertTrue(g.arestasSaoAdjacentes(vA, vB, vA, vC));
    }

    @Test
    public void testGrafoArestasNaoAdjacentes() throws Exception {
        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vC, vD);

        assertFalse(g.arestasSaoAdjacentes(vA, vB, vC, vD));
    }

    @Test
    public void testGrafoExisteAresta() throws Exception {
        g.adicionarAresta(vA, vB);
        assertTrue(g.existeAresta(vA, vB));
    }

    @Test
    public void testGrafoNaoExisteAresta() throws Exception {
        g.adicionarAresta(vA, vB);
        assertFalse(g.existeAresta(vA, vC));
    }

    @Test
    public void testGrafoQuantidadeArestas() throws Exception {
        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vB, vC);

        int quantidadeArestas = 2;

        assertEquals(quantidadeArestas, g.quantidadeArestas());
    }

    @Test
    public void testGrafoQuantidadeVertices() throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Grafo h = new Grafo(vA, vB, vC);

        h.adicionarAresta(vA, vB);
        h.adicionarAresta(vB, vC);

        int quantidadeVertices = 3;

        assertEquals(quantidadeVertices, h.quantidadeVertices());
    }

    @Test
    public void testGrafoNulo() throws Exception {
        Grafo h = new Grafo(vA, vB, vC);
        assertTrue(h.ehNulo());
    }

    @Test
    public void testGrafoNaoNulo() throws Exception {
        g.adicionarAresta(vA, vB);
        assertFalse(g.ehNulo());
    }

    @Test
    public void testGrafoCompleto() throws Exception {
        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vA, vD);
        g.adicionarAresta(vA, vE);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vB, vD);
        g.adicionarAresta(vB, vE);
        g.adicionarAresta(vC, vD);
        g.adicionarAresta(vC, vE);
        g.adicionarAresta(vD, vE);

        assertTrue(g.ehCompleto());
    }

    @Test
    public void testGrafoNaoCompleto() throws Exception {
        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        assertFalse(g.ehCompleto());
    }
}
