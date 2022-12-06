package Tests.Algoritmos;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import Algoritmos.Fleury;
import Algoritmos.Tarjan;
import ListaAdjacencia.Grafo;
import Util.Vertice;

public class FleuryTest {
    @Test
    public void flueryTest() throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Grafo g = new Grafo(vA, vB, vC, vD, vE, vF);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vA, vE);
        g.adicionarAresta(vA, vF);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vB, vD);
        g.adicionarAresta(vB, vE);
        g.adicionarAresta(vC, vD);
        g.adicionarAresta(vC, vE);
        g.adicionarAresta(vD, vE);
        g.adicionarAresta(vD, vF);

        Fleury f = new Fleury(g, new Tarjan(g));
        LinkedList<Vertice> caminhoEuleriano = new LinkedList<>(
                Arrays.asList(vB, vC, vA, vE, vB, vD, vC, vE, vD, vF, vA));

        assertEquals(caminhoEuleriano, f.buscaCaminhoEuleriano());
    }
}
