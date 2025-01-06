package aed.avaliacao.recurso;

import aed.ComparacaoInteiros;

public class MainAvaliacaoPesquisaCentrada {

    public static void main(String[] args) {
        PesquisaCentrada<Integer> pesquisaCentrada = new PesquisaCentrada<>(ComparacaoInteiros.CRITERIO);

        // ##### Índice no centro
        //	-> Existe no centro
        pesquisaCentrada.apresentar(4, 13, 1, 10, 20, 5, 13, 51, 101, 200, 2);

        //  -> Existe à esquerda
        pesquisaCentrada.apresentar(4, 10, 1, 10, 20, 5, 13, 51, 101, 200, 2);

        //	-> Existe à direita
        pesquisaCentrada.apresentar(4, 2, 1, 10, 20, 5, 13, 51, 101, 200, 2);

        //  -> Não existe
        pesquisaCentrada.apresentar(4, 3, 1, 10, 20, 5, 13, 51, 101, 200, 2);


        // ##### Índice à esquerda
        //	-> Existe à esquerda
        pesquisaCentrada.apresentar(2, 10, 1, 10, 20, 5, 13, 51, 101, 200, 2);

        //  -> Existe à direita
        pesquisaCentrada.apresentar(2, 2, 1, 10, 20, 5, 13, 51, 101, 200, 2);

        //	-> Não existe
        pesquisaCentrada.apresentar(2, 3, 1, 10, 20, 5, 13, 51, 101, 200, 2);


        // ##### Índice à direita
        //	-> Existe à esquerda
        pesquisaCentrada.apresentar(5, 10, 1, 10, 20, 5, 13, 51, 101, 200, 2);

        //  -> Existe à direita
        pesquisaCentrada.apresentar(5, 2, 1, 10, 20, 5, 13, 51, 101, 200, 2);

        //	-> Não existe
        pesquisaCentrada.apresentar(5, 3, 1, 10, 20, 5, 13, 51, 101, 200, 2);
    }

}
