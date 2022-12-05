package Tests.ListaAdjacencia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Algoritmos.Conectividade;
import ListaAdjacencia.Grafo;
import Util.Vertice;

public class ConectividadeTest {
    @Test
    public void testGrafoConexo() throws Exception {
        Vertice vA = new Vertice('A');
        Vertice vB = new Vertice('B');
        Vertice vC = new Vertice('C');
        Grafo g = new Grafo(vA, vB, vC);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        assertTrue(Conectividade.ehConexo(g));
    }

    @Test
    public void testGrafoNaoConexo() throws Exception {
        Vertice vA = new Vertice('A');
        Vertice vB = new Vertice('B');
        Vertice vC = new Vertice('C');
        Grafo g = new Grafo(vA, vB, vC);

        g.adicionarAresta(vA, vB);

        assertFalse(Conectividade.ehConexo(g));
    }
}
