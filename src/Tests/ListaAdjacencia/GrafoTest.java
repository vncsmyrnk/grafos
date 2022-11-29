package Tests.ListaAdjacencia;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.VerticeJaExisteException;
import Exception.VerticeNaoEncontradoException;
import ListaAdjacencia.*;
import Util.*;

public class GrafoTest {
    @Test
    public void testGrafoAdicionarAresta() throws Exception {
        Vertice vA = new Vertice('A');
        Vertice vB = new Vertice('B');
        Grafo g = new Grafo(vA, vB);

        g.adicionarAresta(vA, vB);

        Adjacentes listaEsperadaVerticesAdjacentesA = new Adjacentes(vA);
        listaEsperadaVerticesAdjacentesA.adicionarVertice(vB);

        Adjacentes listaVerticesAdjacentesA = g.buscaListaItem(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));
    }

    @Test
    public void testGrafoAdicionarVariasArestas() throws Exception {
        Vertice vA = new Vertice('A');
        Vertice vB = new Vertice('B');
        Vertice vC = new Vertice('C');
        Vertice vD = new Vertice('D');
        Vertice vE = new Vertice('E');

        Grafo g = new Grafo(vA, vB, vC, vD, vE);

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

        Adjacentes listaVerticesAdjacentesA = g.buscaListaItem(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));

        Adjacentes listaEsperadaVerticesAdjacentesB = new Adjacentes(vB);
        listaEsperadaVerticesAdjacentesB.adicionarVertice(vD);
        listaEsperadaVerticesAdjacentesB.adicionarVertice(vE);

        Adjacentes listaVerticesAdjacentesB = g.buscaListaItem(vB);

        assertTrue(listaEsperadaVerticesAdjacentesB.equals(listaVerticesAdjacentesB));

        Adjacentes listaEsperadaVerticesAdjacentesC = new Adjacentes(vC);
        listaEsperadaVerticesAdjacentesC.adicionarVertice(vB);
        listaEsperadaVerticesAdjacentesC.adicionarVertice(vD);

        Adjacentes listaVerticesAdjacentesC = g.buscaListaItem(vC);

        assertTrue(listaEsperadaVerticesAdjacentesC.equals(listaVerticesAdjacentesC));

        Adjacentes listaEsperadaVerticesAdjacentesD = new Adjacentes(vD);
        listaEsperadaVerticesAdjacentesD.adicionarVertice(vE);

        Adjacentes listaVerticesAdjacentesD = g.buscaListaItem(vD);

        assertTrue(listaEsperadaVerticesAdjacentesD.equals(listaVerticesAdjacentesD));

        Adjacentes listaEsperadaVerticesAdjacentesE = new Adjacentes(vE);
        Adjacentes listaVerticesAdjacentesE = g.buscaListaItem(vE);

        assertTrue(listaEsperadaVerticesAdjacentesE.equals(listaVerticesAdjacentesE));
    }

    @Test
    public void testGrafoRemoverAresta() throws Exception {
        Vertice vA = new Vertice('A');
        Vertice vB = new Vertice('B');
        Vertice vC = new Vertice('C');
        Grafo g = new Grafo(vA, vB, vC);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        g.removerAresta(vA, vB);

        Adjacentes listaEsperadaVerticesAdjacentesA = new Adjacentes(vA);
        listaEsperadaVerticesAdjacentesA.adicionarVertice(vC);

        Adjacentes listaVerticesAdjacentesA = g.buscaListaItem(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));
    }

    @Test(expected = VerticeNaoEncontradoException.class)
    public void testGrafoAdicionarArestaEmVerticeNaoExistente() throws Exception {
        Vertice vA = new Vertice('A');
        Vertice vB = new Vertice('B');
        Vertice vC = new Vertice('C');
        Grafo g = new Grafo(vA, vB);

        g.adicionarAresta(vA, vC);
    }

    @Test(expected = VerticeNaoEncontradoException.class)
    public void testCriarGrafoRemoverVerticeInexistente() throws Exception {
        Vertice vA = new Vertice('A');
        Vertice vB = new Vertice('B');
        Grafo g = new Grafo(vA);
        g.removerVertice(vB);
    }

    @Test(expected = VerticeJaExisteException.class)
    public void testCriarGrafoComVerticeDuplicado() throws Exception {
        Vertice vA = new Vertice('A');
        new Grafo(vA, vA);
    }

    @Test(expected = VerticeJaExisteException.class)
    public void testGrafoAdicionarVerticeDuplicado() throws Exception {
        Vertice vA = new Vertice('A');
        Grafo g = new Grafo(vA);

        g.adicionarVertice(vA);
    }
}
