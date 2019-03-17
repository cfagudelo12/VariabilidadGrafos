package grafos.grafos;

import grafos.arcos.Arco;
import grafos.estrategiasbusqueda.EstrategiaBusqueda;
import grafos.nodos.Nodo;

import java.util.ArrayList;
import java.util.List;

public class GrafoImpl implements Grafo {

    private List<Arco> arcos;
    private List<Nodo> nodos;
    private EstrategiaBusqueda estrategiaBusqueda;

    public GrafoImpl(EstrategiaBusqueda estrategiaBusqueda) {
        this.arcos = new ArrayList<>();
        this.nodos = new ArrayList<>();
        this.estrategiaBusqueda = estrategiaBusqueda;
    }

    @Override
    public List<Nodo> darNodos() {
        return nodos;
    }

    @Override
    public List<Arco> darArcos() {
        return arcos;
    }

    @Override
    public void agregarNodo(String identificador) {
        Nodo nodo = new Nodo(identificador);
        nodos.add(nodo);
    }

    @Override
    public void agregarArco(String origen, String destino) {
        Nodo nodoOrigen = buscarNodo(origen);
        Nodo nodoDestino = buscarNodo(destino);
        Arco arco = new Arco(nodoOrigen, nodoDestino);
        arcos.add(arco);
        nodoOrigen.agregarArco(arco);
    }

    @Override
    public void agregarArco(String origen, String destino, int peso) {
        throw new UnsupportedOperationException("No se pueden usar arcos pesados");
    }

    @Override
    public Nodo buscarNodo(String identificador) {
        return this.nodos.stream()
                .filter(nodo -> nodo.getIdentificador().equals(identificador))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Nodo> buscarRuta(String identificadorOrigen, String identificadorDestino) {
        return estrategiaBusqueda.buscarRuta(this, identificadorOrigen, identificadorDestino);
    }

    @Override
    public boolean existeRuta(String identificadorOrigen, String identificadorDestino) {
        return estrategiaBusqueda.existeRuta(this, identificadorOrigen, identificadorDestino);
    }
}
