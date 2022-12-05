package Tests.Algoritmos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Algoritmos.Conectividade;
import ListaAdjacencia.Grafo;
import Util.Vertice;

public class ConectividadeTest {
    @Test
    public void testGrafoConexo() throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Grafo g = new Grafo(vA, vB, vC);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        assertTrue(Conectividade.ehGrafoConexo(g));
    }

    @Test
    public void testGrafoConexo2() throws Exception {
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

        assertTrue(Conectividade.ehGrafoConexo(g));
    }

    @Test
    public void testGrafoConexo3() throws Exception {
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

        assertTrue(Conectividade.ehGrafoConexo(g));
    }

    @Test
    public void testGrafoNaoConexo() throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Grafo g = new Grafo(vA, vB, vC);

        g.adicionarAresta(vA, vB);

        assertFalse(Conectividade.ehGrafoConexo(g));
    }

    @Test
    public void testGrafoNaoConexo2() throws Exception {
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
        g.adicionarAresta(vD, vE);
        g.adicionarAresta(vD, vF);
        g.adicionarAresta(vE, vF);

        assertFalse(Conectividade.ehGrafoConexo(g));
    }
}
