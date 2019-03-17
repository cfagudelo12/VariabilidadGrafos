package grafos.estrategiasbusqueda;

import grafos.grafos.Grafo;
import grafos.nodos.Nodo;

import java.util.List;

public interface EstrategiaBusqueda {
    public List<Nodo> buscarRuta(Grafo grafo, String identificadorOrigen, String identificadorDestino);
    public boolean existeRuta(Grafo grafo, String identificadorOrigen, String identificadorDestino);
}
