package Util;

public class Vertice2 {
    private char rotulo;

    public Vertice2(char rotulo) {
        this.rotulo = rotulo;
    }

    public char getRotulo() {
        return this.rotulo;
    }

    @Override
    public boolean equals(Object o) {
        Vertice2 v = (Vertice2) o;
        if (v == null) {
            return false;
        }
        return this.rotulo == v.getRotulo();
    }
}
