package Util;

/**
 * Representação de um Vertice
 */

public class Vertice {
    private char rotulo;
    private int peso;

    public Vertice(char rotulo) {
        this.rotulo = rotulo;
        this.peso = 1;
    }

    public Vertice(char rotulo, int peso) {
        this.rotulo = rotulo;
        this.peso = peso;
    }

    /**
     * Retorna o rotulo
     * 
     * @return char
     */
    public char getRotulo() {
        return this.rotulo;
    }

    /**
     * Retorna o peso
     * 
     * @return
     */
    public int getPeso() {
        return this.peso;
    }

    /**
     * Sobrescreve a comaparacao de iguais realizando a comparacao entre os rotulos
     * 
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        Vertice v = (Vertice) o;
        if (v == null) {
            return false;
        }
        return this.rotulo == v.getRotulo();
    }
}
