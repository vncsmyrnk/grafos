package Tests.ListaAdjacencia;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ListaAdjacencia.*;
import Util.*;

public class GrafoTest {
    @Test
    public void testGrafoCaso1() {
        Vertice2 vA = new Vertice2('A');
        Vertice2 vB = new Vertice2('B');
        Grafo g = new Grafo(vA, vB);

        g.adicionarAresta(vA, vB);

        Item listaEsperadaVerticesAdjacentesA = new Item(vA);
        listaEsperadaVerticesAdjacentesA.adicionarVertice(vB);

        Item listaVerticesAdjacentesA = g.buscaListaItem(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));
    }

    @Test
    public void testGrafoCaso2() {
        Vertice2 vA = new Vertice2('A');
        Vertice2 vB = new Vertice2('B');
        Vertice2 vC = new Vertice2('C');
        Vertice2 vD = new Vertice2('D');
        Vertice2 vE = new Vertice2('E');

        Grafo g = new Grafo(vA, vB, vC, vD, vE);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        g.adicionarAresta(vB, vD);
        g.adicionarAresta(vB, vE);

        g.adicionarAresta(vC, vB);
        g.adicionarAresta(vC, vD);

        g.adicionarAresta(vD, vE);

        Item listaEsperadaVerticesAdjacentesA = new Item(vA);
        listaEsperadaVerticesAdjacentesA.adicionarVertice(vB);
        listaEsperadaVerticesAdjacentesA.adicionarVertice(vC);

        Item listaVerticesAdjacentesA = g.buscaListaItem(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));

        Item listaEsperadaVerticesAdjacentesB = new Item(vB);
        listaEsperadaVerticesAdjacentesB.adicionarVertice(vD);
        listaEsperadaVerticesAdjacentesB.adicionarVertice(vE);

        Item listaVerticesAdjacentesB = g.buscaListaItem(vB);

        assertTrue(listaEsperadaVerticesAdjacentesB.equals(listaVerticesAdjacentesB));

        Item listaEsperadaVerticesAdjacentesC = new Item(vC);
        listaEsperadaVerticesAdjacentesC.adicionarVertice(vB);
        listaEsperadaVerticesAdjacentesC.adicionarVertice(vD);

        Item listaVerticesAdjacentesC = g.buscaListaItem(vC);

        assertTrue(listaEsperadaVerticesAdjacentesC.equals(listaVerticesAdjacentesC));

        Item listaEsperadaVerticesAdjacentesD = new Item(vD);
        listaEsperadaVerticesAdjacentesD.adicionarVertice(vE);

        Item listaVerticesAdjacentesD = g.buscaListaItem(vD);

        assertTrue(listaEsperadaVerticesAdjacentesD.equals(listaVerticesAdjacentesD));

        Item listaEsperadaVerticesAdjacentesE = new Item(vE);
        Item listaVerticesAdjacentesE = g.buscaListaItem(vE);

        assertTrue(listaEsperadaVerticesAdjacentesE.equals(listaVerticesAdjacentesE));
    }

    @Test
    public void testGrafoCaso3() {
        Vertice2 vA = new Vertice2('A');
        Vertice2 vB = new Vertice2('B');
        Vertice2 vC = new Vertice2('C');
        Grafo g = new Grafo(vA, vB, vC);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        g.removerAresta(vA, vB);

        Item listaEsperadaVerticesAdjacentesA = new Item(vA);
        listaEsperadaVerticesAdjacentesA.adicionarVertice(vC);

        Item listaVerticesAdjacentesA = g.buscaListaItem(vA);

        assertTrue(listaEsperadaVerticesAdjacentesA.equals(listaVerticesAdjacentesA));
    }
}
