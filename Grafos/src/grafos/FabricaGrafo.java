package grafos;

import grafos.estrategiasbusqueda.EstrategiaBusqueda;
import grafos.estrategiasbusqueda.EstrategiaBusquedaBFS;
import grafos.estrategiasbusqueda.EstrategiaBusquedaDFS;
import grafos.estrategiasbusqueda.EstrategiaBusquedaEnum;
import grafos.grafos.DecoradorGrafoNoDirigido;
import grafos.grafos.Grafo;
import grafos.grafos.GrafoImpl;
import grafos.grafos.GrafoPesadoImpl;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FabricaGrafo {
    private static ConfiguracionGrafo getConfiguracionGrafo() throws IOException {
        Properties opciones = new Properties();
        opciones.load(new FileReader("./data/config.properties"));
        boolean dirigido = opciones.getProperty("dirigido", "false").equals("true");
        boolean pesado = opciones.getProperty("pesado", "false").equals("true");
        String estrategia = opciones.getProperty("estrategia", "DFS");
        return new ConfiguracionGrafo(dirigido, pesado, estrategia);
    }

    public static Grafo getGrafo() throws IOException {
        ConfiguracionGrafo configuracionGrafo = getConfiguracionGrafo();
        EstrategiaBusqueda estrategiaBusqueda;
        Grafo grafo;
        if(configuracionGrafo.getEstrategiaBusquedaEnum() == EstrategiaBusquedaEnum.DFS) {
            estrategiaBusqueda = new EstrategiaBusquedaDFS();
        } else {
            estrategiaBusqueda = new EstrategiaBusquedaBFS();
        }
        if (configuracionGrafo.isPesado()) {
            grafo = new GrafoPesadoImpl(estrategiaBusqueda);
        } else {
            grafo = new GrafoImpl(estrategiaBusqueda);
        }
        if (!configuracionGrafo.isDirigido()) {
            return new DecoradorGrafoNoDirigido(grafo);
        }
        return grafo;
    }
}
