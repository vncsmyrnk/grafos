package Tests.ListaAdjacencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import Exception.VerticeJaExisteException;
import Exception.VerticeNaoEncontradoException;
import MatrizAdjacencia.Vertice;
import MatrizAdjacencia.Grafo;

public class GrafoMatrizAdjacenciaTest {
    Vertice vA;
    Vertice vB;
    Vertice vC;
    Vertice vD;
    Vertice vE;

    Grafo g;

    @Before
    public void initialize() throws VerticeJaExisteException {
        this.vA = new Vertice('A');
        this.vB = new Vertice('B');
        this.vC = new Vertice('C');
        this.vD = new Vertice('D');
        this.vE = new Vertice('E');

        this.g = new Grafo(vA, vB, vC, vD, vE);
    }

    @Test
    public void testGrafoAdicionarAresta() throws Exception {
        g.adicionarAresta(vA, vB);

        LinkedList<Vertice> listaEsperadaVerticesAdjacentesA = new LinkedList<Vertice>();
        listaEsperadaVerticesAdjacentesA.push(vB);

        LinkedList<Vertice> listaVerticesAdjacentesA = g.buscaAdjacentes(vA);

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

        LinkedList<Vertice> listaEsperadaVerticesAdjacentesA = new LinkedList<Vertice>();
        listaEsperadaVerticesAdjacentesA.push(vB);
        listaEsperadaVerticesAdjacentesA.push(vC);

        LinkedList<Vertice> listaVerticesAdjacentesA = g.buscaAdjacentes(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));

        LinkedList<Vertice> listaEsperadaVerticesAdjacentesB = new LinkedList<Vertice>();
        listaEsperadaVerticesAdjacentesB.push(vA);
        listaEsperadaVerticesAdjacentesB.push(vC);
        listaEsperadaVerticesAdjacentesB.push(vD);
        listaEsperadaVerticesAdjacentesB.push(vE);

        LinkedList<Vertice> listaVerticesAdjacentesB = g.buscaAdjacentes(vB);

        assertTrue(listaEsperadaVerticesAdjacentesB.equals(listaVerticesAdjacentesB));

        LinkedList<Vertice> listaEsperadaVerticesAdjacentesC = new LinkedList<Vertice>();
        listaEsperadaVerticesAdjacentesC.push(vA);
        listaEsperadaVerticesAdjacentesC.push(vB);
        listaEsperadaVerticesAdjacentesC.push(vD);

        LinkedList<Vertice> listaVerticesAdjacentesC = g.buscaAdjacentes(vC);

        assertTrue(listaEsperadaVerticesAdjacentesC.equals(listaVerticesAdjacentesC));

        LinkedList<Vertice> listaEsperadaVerticesAdjacentesD = new LinkedList<Vertice>();
        listaEsperadaVerticesAdjacentesD.push(vB);
        listaEsperadaVerticesAdjacentesD.push(vC);
        listaEsperadaVerticesAdjacentesD.push(vE);

        LinkedList<Vertice> listaVerticesAdjacentesD = g.buscaAdjacentes(vD);

        assertTrue(listaEsperadaVerticesAdjacentesD.equals(listaVerticesAdjacentesD));

        LinkedList<Vertice> listaEsperadaVerticesAdjacentesE = new LinkedList<Vertice>();
        listaEsperadaVerticesAdjacentesE.push(vB);
        listaEsperadaVerticesAdjacentesE.push(vD);

        LinkedList<Vertice> listaVerticesAdjacentesE = g.buscaAdjacentes(vE);

        assertTrue(listaEsperadaVerticesAdjacentesE.equals(listaVerticesAdjacentesE));
    }

    @Test
    public void testGrafoRemoverAresta() throws Exception {
        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        g.removerAresta(vA, vB);

        LinkedList<Vertice> listaEsperadaVerticesAdjacentesA = new LinkedList<Vertice>();
        listaEsperadaVerticesAdjacentesA.push(vC);

        LinkedList<Vertice> listaVerticesAdjacentesA = g.buscaAdjacentes(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));
    }

    @Test(expected = VerticeNaoEncontradoException.class)
    public void testGrafoAdicionarArestaEmVerticeNaoExistente() throws Exception {
        Grafo h = new Grafo(vA, vB);
        h.adicionarAresta(vA, vC);
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
        Vertice vA = new Vertice('A');
        Vertice vB = new Vertice('B');
        Vertice vC = new Vertice('C');
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
