package Util;

/**
 * Representação de um Vertice
 */

public class Vertice extends ItemGrafo {
    public Vertice(char rotulo) {
        super(rotulo);
    }

    public Vertice(char rotulo, int peso) {
        super(rotulo, peso);
    }
}
