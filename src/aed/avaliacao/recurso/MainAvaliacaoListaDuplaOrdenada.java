package aed.avaliacao.recurso;

import aed.ComparacaoInteiros;

public class MainAvaliacaoListaDuplaOrdenada {

    public static void main(String[] args) {
        ListaDuplaOrdenada<Integer> lista = new ListaDuplaOrdenada<>(ComparacaoInteiros.CRITERIO);

        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(3);
        lista.inserir(3);
        lista.inserir(3);
        lista.inserir(3);
        lista.inserir(12);
        lista.inserir(13);
        lista.inserir(13);
        lista.inserir(13);
        lista.inserir(11);
        lista.inserir(15);
        lista.inserir(10);

        System.out.println(lista);
        for (Integer elemento : lista.removerTodos(13)) {
            System.out.println(elemento);
        }
    }
}
