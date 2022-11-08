package ListaAdjacencia;

import java.util.LinkedList;
import Util.*;

/**
 * Representação de Item de uma lista de Vertice2s adjacentes a um determinado
 * Vertice2
 */

public class Item {
    private Vertice2 vertice;
    private LinkedList<Vertice2> verticesAdjacentes;

    public Item(Vertice2 v) {
        this.vertice = v;
        this.verticesAdjacentes = new LinkedList<>();
    }

    public void adicionarVertice(Vertice2 v) {
        this.verticesAdjacentes.add(v);
    }

    public void removerVertice(Vertice2 v) {
        this.verticesAdjacentes.remove(v);
    }

    public boolean isItemDoVertice(Vertice2 v) {
        return this.vertice.equals(v);
    }

    public LinkedList<Vertice2> getVerticesAdjacentes() {
        return this.verticesAdjacentes;
    }

    public Vertice2 getVertice() {
        return this.vertice;
    }

    @Override
    public boolean equals(Object o) {
        Item i = (Item) o;
        if (i == null) {
            return false;
        }
        return this.vertice.equals(i.getVertice()) && this.verticesAdjacentes.equals(i.getVerticesAdjacentes());
    }
}
