package grafos.grafos;

import grafos.arcos.Arco;
import grafos.nodos.Nodo;

import java.util.List;

public interface Grafo {
    public List<Nodo> darNodos();
    public List<Arco> darArcos();
    public void agregarNodo(String identificador);
    public void agregarArco(String origen, String destino);
    public void agregarArco(String origen, String destino, int peso);
    public Nodo buscarNodo(String identificador);
    public List<Nodo> buscarRuta(String identificadorOrigen, String identificadorDestino);
    public boolean existeRuta(String identificadorOrigen, String identificadorDestino);
}
