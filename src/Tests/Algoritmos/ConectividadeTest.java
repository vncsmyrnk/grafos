package Tests.Algoritmos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import Algoritmos.Conectividade;
import Tests.TesteUtil;
import Util.Vertice;

public class ConectividadeTest {
    @RepeatedTest(2)
    public void testGrafoConexo(RepetitionInfo repetitionInfo) throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Util.Grafo g = TesteUtil.getInstanciaGrafoPorRepeticaoAtual(repetitionInfo.getCurrentRepetition(), vA, vB, vC);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);

        assertTrue(Conectividade.ehGrafoConexo(g));
    }

    @RepeatedTest(2)
    public void testGrafoConexo2(RepetitionInfo repetitionInfo) throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Util.Grafo g = TesteUtil.getInstanciaGrafoPorRepeticaoAtual(repetitionInfo.getCurrentRepetition(), vA, vB, vC,
                vD, vE, vF);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vC, vD);
        g.adicionarAresta(vD, vE);
        g.adicionarAresta(vD, vF);
        g.adicionarAresta(vE, vF);

        assertTrue(Conectividade.ehGrafoConexo(g));
    }

    @RepeatedTest(2)
    public void testGrafoConexo3(RepetitionInfo repetitionInfo) throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Util.Grafo g = TesteUtil.getInstanciaGrafoPorRepeticaoAtual(repetitionInfo.getCurrentRepetition(), vA, vB, vC,
                vD, vE, vF);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vC, vD);
        g.adicionarAresta(vD, vE);
        g.adicionarAresta(vD, vF);

        assertTrue(Conectividade.ehGrafoConexo(g));
    }

    @RepeatedTest(2)
    public void testGrafoNaoConexo(RepetitionInfo repetitionInfo) throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Util.Grafo g = TesteUtil.getInstanciaGrafoPorRepeticaoAtual(repetitionInfo.getCurrentRepetition(), vA, vB, vC);

        g.adicionarAresta(vA, vB);

        assertFalse(Conectividade.ehGrafoConexo(g));
    }

    @RepeatedTest(2)
    public void testGrafoNaoConexo2(RepetitionInfo repetitionInfo) throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Util.Grafo g = TesteUtil.getInstanciaGrafoPorRepeticaoAtual(repetitionInfo.getCurrentRepetition(), vA, vB, vC,
                vD, vE, vF);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vD, vE);
        g.adicionarAresta(vD, vF);
        g.adicionarAresta(vE, vF);

        assertFalse(Conectividade.ehGrafoConexo(g));
    }
}
