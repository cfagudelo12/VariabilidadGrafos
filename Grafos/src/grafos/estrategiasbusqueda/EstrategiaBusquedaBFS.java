package grafos.estrategiasbusqueda;

import grafos.grafos.Grafo;
import grafos.nodos.Nodo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EstrategiaBusquedaBFS implements EstrategiaBusqueda {

    public EstrategiaBusquedaBFS() {
    }

    @Override
    public List<Nodo> buscarRuta(Grafo grafo, String identificadorOrigen, String identificadorDestino) {
        Nodo nodoOrigen = grafo.buscarNodo(identificadorOrigen);
        Nodo nodoDestino = grafo.buscarNodo(identificadorDestino);
        List<Nodo> nodosRuta = new ArrayList<>();

        if (nodoOrigen == null) {
            throw new RuntimeException("Error en la Búsqueda: grafos.nodos.Nodo origen no encontrado");
        }
        if (nodoDestino == null) {
            throw new RuntimeException("Error en la Búsqueda: grafos.nodos.Nodo destino no encontrado");
        }

        if (buscarRutaBFS(nodosRuta, nodoOrigen, nodoDestino)) {
            return nodosRuta;
        } else {
            return null;
        }
    }

    private boolean buscarRutaBFS(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino) {
        if(nodoOrigen.getIdentificador().equals(nodoDestino.getIdentificador())){
            System.err.println("grafos.nodos.Nodo destino encontrado en el mismo nodo origen");
            nodosRuta.add(nodoOrigen);
            return true;
        }

        Queue<Nodo> queue = new LinkedList<>();
        ArrayList<Nodo> nodosVisitados = new ArrayList<>();

        queue.add(nodoOrigen);
        nodosVisitados.add(nodoOrigen);

        while(!queue.isEmpty()){

            Nodo actual = queue.remove();
            if(actual.equals(nodoDestino)) {
                nodosRuta.add(actual);
                return true;
            }
            else{
                if(actual.getNodosAdyacentes().isEmpty())
                    return false;
                else {
                    for (Nodo nodo: actual.getNodosAdyacentes()) {
                        if (!nodosVisitados.contains(nodo))
                            queue.add(nodo);
                    }
                }

            }
            if (!nodosRuta.contains(actual))
                nodosRuta.add(actual);
        }

        return false;
    }

    @Override
    public boolean existeRuta(Grafo grafo, String identificadorOrigen, String identificadorDestino) {
        return (buscarRuta(grafo, identificadorOrigen, identificadorDestino) != null);
    }
}
