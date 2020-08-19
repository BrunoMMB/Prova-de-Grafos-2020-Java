package grafo;
public class Aresta {

    public final Vertice fim;
    public final double peso;
    Vertice origem;

    public Aresta(Vertice fim, double peso) {
        this.fim = fim;
        this.peso = peso;
    }
    
}