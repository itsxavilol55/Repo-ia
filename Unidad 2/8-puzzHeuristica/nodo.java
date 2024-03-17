public class nodo {
    private String estado;
    private int costo;
    public nodo(String estadoInicial) {
        estado = estadoInicial;
    }
    public nodo(String suceso, int costo) {
        estado = suceso;
        this.costo=costo;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
