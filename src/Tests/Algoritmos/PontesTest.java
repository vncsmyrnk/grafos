package Tests.Algoritmos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Algoritmos.Pontes;
import Exception.GrafoNaoPossuiPonteException;
import ListaAdjacencia.Grafo;
import Util.Aresta;
import Util.Vertice;

public class PontesTest {
    @Test
    public void testGrafoPonteCaso1() throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Grafo g = new Grafo(vA, vB, vC, vD, vE, vF);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vC, vD);
        g.adicionarAresta(vD, vE);
        g.adicionarAresta(vD, vF);
        g.adicionarAresta(vE, vF);

        Aresta arestaPonte = new Aresta(vC, vD);

        assertEquals(arestaPonte, Pontes.identificaPonteGrafo(g));
    }

    @Test
    public void testGrafoPonteCaso2() throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Vertice vG = new Vertice("G");
        Vertice vH = new Vertice("H");
        Grafo g = new Grafo(vA, vB, vC, vD, vE, vF, vG, vH);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vC, vD);
        g.adicionarAresta(vB, vE);
        g.adicionarAresta(vE, vF);
        g.adicionarAresta(vF, vG);
        g.adicionarAresta(vG, vH);
        g.adicionarAresta(vH, vE);

        Aresta arestaPonte = new Aresta(vB, vE);

        assertEquals(arestaPonte, Pontes.identificaPonteGrafo(g));
    }

    @Test
    public void testGrafoPonteCaso3() throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Vertice vG = new Vertice("G");
        Vertice vH = new Vertice("H");
        Grafo g = new Grafo(vA, vB, vC, vD, vE, vF, vG, vH);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vC, vD);
        g.adicionarAresta(vE, vF);
        g.adicionarAresta(vF, vG);
        g.adicionarAresta(vG, vH);
        g.adicionarAresta(vH, vE);

        Aresta arestaPonte = new Aresta(vC, vD);
        Aresta a = Pontes.identificaPonteGrafo(g);

        assertEquals(arestaPonte, Pontes.identificaPonteGrafo(g));
    }

    @Test(expected = GrafoNaoPossuiPonteException.class)
    public void testGrafoSemPonteCaso1() throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Grafo g = new Grafo(vA, vB, vC);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vC, vB);

        Pontes.identificaPonteGrafo(g);
    }

    @Test(expected = GrafoNaoPossuiPonteException.class)
    public void testGrafoSemPonteCaso2() throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Vertice vG = new Vertice("G");
        Vertice vH = new Vertice("H");
        Grafo g = new Grafo(vA, vB, vC, vD, vE, vF, vG, vH);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vE, vF);
        g.adicionarAresta(vF, vG);
        g.adicionarAresta(vG, vH);
        g.adicionarAresta(vH, vE);

        Pontes.identificaPonteGrafo(g);
    }
}
