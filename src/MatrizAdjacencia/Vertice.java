package MatrizAdjacencia;

public class Vertice extends Util.Vertice {
    private int posicaoMatriz;

    public Vertice(char rotulo) {
        super(rotulo);
        this.posicaoMatriz = 0;
    }

    public Vertice(char rotulo, int peso) {
        super(rotulo, peso);
        this.posicaoMatriz = 0;
    }

    public Vertice(char rotulo, int peso, int posicaoMatriz) {
        super(rotulo, peso);
        this.posicaoMatriz = posicaoMatriz;
    }

    public int getPosicaoMatriz() {
        return this.posicaoMatriz;
    }
}
