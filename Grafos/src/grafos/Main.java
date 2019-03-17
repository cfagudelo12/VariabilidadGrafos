package grafos;

import grafos.grafos.Grafo;
import grafos.nodos.Nodo;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Grafo g = FabricaGrafo.getGrafo();
        g.agregarNodo("A");
        g.agregarNodo("B");
        g.agregarNodo("C");

        g.agregarArco("A", "B", 3);
        g.agregarArco("B", "C", 4);
        g.agregarArco("A", "C", 5);

        List<Nodo> camino = g.buscarRuta("A", "C");

        if (camino == null) {
            System.out.println("Camino A -> C no encontrado");
        } else {
            System.out.println("Camino A -> C encontrado");
            for (Nodo nodo: camino) {
                System.out.println(nodo.getIdentificador());
            }
        }
        System.out.println();
    }
}
