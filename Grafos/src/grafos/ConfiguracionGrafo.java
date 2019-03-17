package grafos;

import grafos.estrategiasbusqueda.EstrategiaBusquedaEnum;

public class ConfiguracionGrafo {
    private boolean dirigido;
    private boolean pesado;
    private EstrategiaBusquedaEnum estrategiaBusquedaEnum;

    public ConfiguracionGrafo(boolean dirigido, boolean pesado, String estrategia) {
        this.dirigido = dirigido;
        this.pesado = pesado;
        if (estrategia.equals("DFS")) {
            this.estrategiaBusquedaEnum = EstrategiaBusquedaEnum.DFS;
        } else {
            this.estrategiaBusquedaEnum = EstrategiaBusquedaEnum.BFS;
        }
    }

    public boolean isDirigido() {
        return dirigido;
    }

    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }

    public boolean isPesado() {
        return pesado;
    }

    public void setPesado(boolean pesado) {
        this.pesado = pesado;
    }

    public EstrategiaBusquedaEnum getEstrategiaBusquedaEnum() {
        return estrategiaBusquedaEnum;
    }

    public void setEstrategiaBusquedaEnum(EstrategiaBusquedaEnum estrategiaBusquedaEnum) {
        this.estrategiaBusquedaEnum = estrategiaBusquedaEnum;
    }
}
