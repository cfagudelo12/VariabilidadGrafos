package grafos.nodos;

import grafos.arcos.Arco;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private String identificador;
    private List<Arco> arcos;

    public Nodo(String identificador) {
        this.identificador = identificador;
        arcos = new ArrayList<>();
    }

    public void agregarArco(Arco arco) {
        arcos.add(arco);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public List<Nodo> getNodosAdyacentes() {
        List<Nodo> nodos = new ArrayList<>();
        for (Arco arco : arcos) {
            nodos.add(arco.getDestino());
        }
        return nodos;
    }
}
