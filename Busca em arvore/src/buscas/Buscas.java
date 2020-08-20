package buscas;

import java.util.ArrayList;
import java.util.Collections;

public class Buscas {

    private ArrayList<Integer> lista = new ArrayList();
    
    public ArrayList getLista(){
        return this.lista;
    }
    public void inserirNumero(int numero) {
        this.lista.add(numero);
    }

    public void removerNumero(int numero) {
        int tamanho = lista.size() - 1;
        int contador = 0;
        while(contador <= tamanho){
            if(lista.get(contador) == numero){
                break;
            }
            contador++;
        }
        this.lista.remove(contador);
        Collections.sort(lista);
    }
    
    public void ordenar(){
        Collections.sort(this.lista);
    }
    
    public String mostrar(){
        int tamanho = this.lista.size()-1, contador = 0;
        String visual = "";
        while(contador <= tamanho){
            if(contador == 0){
                visual = String.valueOf(lista.get(contador).intValue());
            }else{
                visual = visual + "-->" + String.valueOf(lista.get(contador).intValue());
            }
            contador++;
        }
        return visual;
    }

    public int pesquisaSequencial(int num, ArrayList<Integer> lista) {
        int cont = 0;
        for (cont = 0; cont < lista.size(); cont++) {

            if (lista.get(cont).intValue() == num) {
                return 1;
            }
        }
        return 0;
    }

    public int pesquisaSequencialSentinela(int num, ArrayList<Integer> lista) {
        int contador = 0;
        lista.add(num);
        int tamanhoVetor = lista.size();
        while (lista.get(contador).intValue() != num) {
            contador++;
        }

        lista.remove(tamanhoVetor - 1);

        if (contador == (tamanhoVetor - 1)) {
            return 0; //nao encontrado
        } else {
            return 1; //encontrado
        }
    }

    public int buscaBinaria(int num, ArrayList<Integer> lista) {
        Collections.sort(lista);
        int esquerda = 0;
        int direita = lista.size() -1;
        while(esquerda <= direita){
            int soma = esquerda+direita;
            double divisao = soma / 2.0;
            int meio = (int)Math.round(divisao);
            if(num < lista.get(meio)){
                esquerda = meio - 1;
            }
            else if(num > lista.get(meio)){
                direita = meio + 1;
            }
            else{
                return meio;
            }
        }
        return -1;
    }
    
    public int buscaInterpolada(int num, ArrayList<Integer> lista){
        int inicio, fim, pos;
        inicio = 0;
        fim = lista.size() - 1;
        
        while((inicio<=fim) && (num >= lista.get(inicio)) && (num <= lista.get(fim))){
            pos = (int) Math.round(inicio + (((fim - inicio)/lista.get(fim) - lista.get(inicio)) * (num - lista.get(inicio))));
            if(lista.get(pos).intValue() == num){
                return pos;
            }
            else if(lista.get(pos).intValue() > num){
                inicio = pos + 1;
            }
            else{
                inicio = pos - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //
    }

}
