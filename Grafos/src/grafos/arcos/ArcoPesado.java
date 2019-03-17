package grafos.arcos;

import grafos.nodos.Nodo;

public class ArcoPesado extends Arco {
    private int peso;

    public ArcoPesado(Nodo origen, Nodo destino, int peso) {
        super(origen, destino);
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
