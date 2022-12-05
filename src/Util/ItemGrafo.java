package Util;

/**
 * Representacao de um item a ser utilizado dentro de um grafo
 */

public class ItemGrafo {
    private char rotulo;
    private int peso;
    private boolean sinalizado;

    public ItemGrafo(char rotulo) {
        this.rotulo = rotulo;
        this.peso = 1;
        this.sinalizado = false;
    }

    public ItemGrafo(char rotulo, int peso) {
        this.rotulo = rotulo;
        this.peso = peso;
        this.sinalizado = false;
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
     * @return int
     */
    public int getPeso() {
        return this.peso;
    }

    /**
     * Retorna se o item esta sinalizado
     * 
     * @return boolean
     */
    public boolean estaSinalizado() {
        return this.sinalizado == true;
    }

    /**
     * Retorna se o item nao esta sinalizado
     * 
     * @return boolean
     */
    public boolean naoEstaSinalizado() {
        return this.sinalizado != true;
    }

    /**
     * Sinaliza o item
     * 
     * @return void
     */
    public void sinaliza() {
        this.sinalizado = true;
    }

    /**
     * Marca o item como nao sinalizado
     * 
     * @return void
     */
    public void cancelaSinalizacao() {
        this.sinalizado = false;
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
