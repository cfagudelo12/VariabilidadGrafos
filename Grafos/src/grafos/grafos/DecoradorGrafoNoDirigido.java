package grafos.grafos;

import grafos.arcos.Arco;
import grafos.nodos.Nodo;

import java.util.List;

public class DecoradorGrafoNoDirigido implements Grafo {
    private Grafo grafo;

    public DecoradorGrafoNoDirigido(Grafo grafo) {
        this.grafo = grafo;
    }

    @Override
    public void agregarArco(String origen, String destino) {
        grafo.agregarArco(origen, destino);
        grafo.agregarArco(destino, origen);
    }

    @Override
    public void agregarArco(String origen, String destino, int peso) {
        grafo.agregarArco(origen, destino, peso);
        grafo.agregarArco(destino, origen, peso);
    }

    @Override
    public List<Nodo> darNodos() {
        return grafo.darNodos();
    }

    @Override
    public List<Arco> darArcos() {
        return grafo.darArcos();
    }

    @Override
    public void agregarNodo(String identificador) {
        grafo.agregarNodo(identificador);
    }

    @Override
    public Nodo buscarNodo(String identificador) {
        return grafo.buscarNodo(identificador);
    }

    @Override
    public List<Nodo> buscarRuta(String identificadorOrigen, String identificadorDestino) {
        return grafo.buscarRuta(identificadorOrigen, identificadorDestino);
    }

    @Override
    public boolean existeRuta(String identificadorOrigen, String identificadorDestino) {
        return grafo.existeRuta(identificadorOrigen, identificadorDestino);
    }
}
