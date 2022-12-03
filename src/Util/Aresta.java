package Util;

/**
 * Representacao de uma aresta de um determinado grafo
 */

public class Aresta extends ItemGrafo {
    public Aresta(char rotulo) {
        super(rotulo);
    }

    public Aresta(char rotulo, int peso) {
        super(rotulo, peso);
    }
}
