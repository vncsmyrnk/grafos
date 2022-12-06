package Tests.Algoritmos;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import Algoritmos.Pontes;
import Tests.TesteUtil;
import Util.Aresta;
import Util.Vertice;

public class PontesTest {
    @RepeatedTest(2)
    public void testGrafoPonteCaso1(RepetitionInfo repetitionInfo) throws Exception {
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

        LinkedList<Aresta> arestaPonte = new LinkedList<>(Arrays.asList(new Aresta(vC, vD)));

        assertEquals(arestaPonte, Pontes.identificaPontesGrafo(g));
    }

    @RepeatedTest(2)
    public void testGrafoPonteCaso2(RepetitionInfo repetitionInfo) throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Vertice vG = new Vertice("G");
        Vertice vH = new Vertice("H");
        Util.Grafo g = TesteUtil.getInstanciaGrafoPorRepeticaoAtual(repetitionInfo.getCurrentRepetition(), vA, vB, vC,
                vD, vE, vF, vG, vH);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vC, vD);
        g.adicionarAresta(vB, vE);
        g.adicionarAresta(vE, vF);
        g.adicionarAresta(vF, vG);
        g.adicionarAresta(vG, vH);
        g.adicionarAresta(vH, vE);

        LinkedList<Aresta> arestaPonte = new LinkedList<>(Arrays.asList(new Aresta(vB, vE), new Aresta(vC, vD)));

        assertEquals(arestaPonte, Pontes.identificaPontesGrafo(g));
    }

    @RepeatedTest(2)
    public void testGrafoPonteCaso3(RepetitionInfo repetitionInfo) throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Vertice vG = new Vertice("G");
        Vertice vH = new Vertice("H");
        Util.Grafo g = TesteUtil.getInstanciaGrafoPorRepeticaoAtual(repetitionInfo.getCurrentRepetition(),
                vA, vB, vC,
                vD, vE, vF, vG, vH);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vC, vD);
        g.adicionarAresta(vE, vF);
        g.adicionarAresta(vF, vG);
        g.adicionarAresta(vG, vH);
        g.adicionarAresta(vH, vE);

        LinkedList<Aresta> arestaPonte = new LinkedList<>(Arrays.asList(new Aresta(vC, vD)));

        assertEquals(arestaPonte, Pontes.identificaPontesGrafo(g));
    }

    @RepeatedTest(2)
    public void testGrafoSemPonteCaso1(RepetitionInfo repetitionInfo) throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Util.Grafo g = TesteUtil.getInstanciaGrafoPorRepeticaoAtual(repetitionInfo.getCurrentRepetition(),
                vA, vB, vC);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vC, vB);

        LinkedList<Aresta> arestaPonte = new LinkedList<>();

        assertEquals(arestaPonte, Pontes.identificaPontesGrafo(g));
    }

    @RepeatedTest(2)
    public void testGrafoSemPonteCaso2(RepetitionInfo repetitionInfo) throws Exception {
        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Vertice vG = new Vertice("G");
        Vertice vH = new Vertice("H");
        Util.Grafo g = TesteUtil.getInstanciaGrafoPorRepeticaoAtual(repetitionInfo.getCurrentRepetition(),
                vA, vB, vC,
                vD, vE, vF, vG, vH);

        g.adicionarAresta(vA, vB);
        g.adicionarAresta(vA, vC);
        g.adicionarAresta(vB, vC);
        g.adicionarAresta(vE, vF);
        g.adicionarAresta(vF, vG);
        g.adicionarAresta(vG, vH);
        g.adicionarAresta(vH, vE);

        LinkedList<Aresta> arestaPonte = new LinkedList<>();

        assertEquals(arestaPonte, Pontes.identificaPontesGrafo(g));
    }
}
