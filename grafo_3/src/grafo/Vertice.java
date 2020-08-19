/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;

/**
 *
 * @author hugo
 */
public class Vertice implements Comparable<Vertice> {

    public final String nome;
    public ArrayList<Aresta> adjacentes;
    public ArrayList<Vertice> caminho;
    public double menDistancia = Double.POSITIVE_INFINITY;
    public Vertice anterior;

    public int compareTo(Vertice other) {
        return Double.compare(menDistancia, other.menDistancia);
    }

    public Vertice(String nome) {
        this.nome = nome;
        adjacentes = new ArrayList<Aresta>();
        caminho = new ArrayList<Vertice>();
    }

    public String toString() {
        return nome;
    }
    
    public int calcPesoSoma() {
        int tam = this.adjacentes.size();
        int i = 0;
        int somaPeso = 0;
        
        while(i < tam){
            somaPeso = (int) (somaPeso + this.adjacentes.get(i).peso);
            i++;
        }
        return somaPeso;
    }
    
    
}