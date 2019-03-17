package grafos.estrategiasbusqueda;

import grafos.grafos.Grafo;
import grafos.nodos.Nodo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EstrategiaBusquedaDFS implements EstrategiaBusqueda {
    public EstrategiaBusquedaDFS() {
    }

    @Override
    public List<Nodo> buscarRuta(Grafo grafo, String identificadorOrigen, String identificadorDestino) {
        Nodo nodoOrigen = grafo.buscarNodo(identificadorOrigen);
        Nodo nodoDestino = grafo.buscarNodo(identificadorDestino);
        List<Nodo> nodosRuta = new ArrayList<>();

        if (nodoOrigen == null) {
            throw new RuntimeException("Error en la Búsqueda: Nodo origen no encontrado");
        }
        if (nodoDestino == null) {
            throw new RuntimeException("Error en la Búsqueda: Nodo destino no encontrado");
        }

        if (buscarRutaDFS(nodosRuta, nodoOrigen, nodoDestino)) {
            return nodosRuta;
        } else {
            return null;
        }
    }

    @Override
    public boolean existeRuta(Grafo grafo, String identificadorOrigen, String identificadorDestino) {
        return (buscarRuta(grafo, identificadorOrigen, identificadorDestino) != null);
    }

    private boolean buscarRutaDFS(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino) {
        nodosRuta.add(nodoOrigen);

        if(nodoOrigen.getIdentificador().equals(nodoDestino.getIdentificador())){
            return true;
        }

        Stack<Nodo> pilaDeNodos = new Stack<>();
        List<Nodo> nodosVisitados = new ArrayList<>();

        pilaDeNodos.add(nodoOrigen);

        while(!pilaDeNodos.isEmpty()){
            Nodo actual = pilaDeNodos.pop();

            if (nodosVisitados.contains(actual))
                continue;

            if (actual.equals(nodoDestino)) {
                nodosRuta.addAll(pilaDeNodos);
                nodosRuta.add(nodoDestino);
                return true;
            }
            else {
                nodosVisitados.add(actual);
                for(Nodo nodo: actual.getNodosAdyacentes()) {
                    if (!pilaDeNodos.contains(nodo))
                        pilaDeNodos.add(nodo);
                }
            }
        }
        return false;
    }
}
