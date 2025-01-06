package aed.avaliacao.recurso.modelo;

import aed.avaliacao.recurso.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;

public enum GestorImoveis {
    INSTANCIA;

    private ListaDuplaOrdenada<Imovel> imoveis;

    GestorImoveis() {
        imoveis = new ListaDuplaOrdenada<>(CopAsc.CRITERIO);
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis() {
        //TODO: PERGUNTA 3.a)
        return imoveis.iterador();
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis(String concelho) {
        //TODO: PERGUNTA 3.b)
        return null;
    }

    public Imovel consultarImovelComPrecoMaximo(String concelho) {
        //TODO: PERGUNTA 3.c)
        return null;
    }

    public double consultarPrecoMedioImoveis(String concelho, String tipologia) {
        //TODO: PERGUNTA 3.d)
        return -1;
    }

    public void inserir(Imovel imovel) {
        //TODO: PERGUNTA 3.e)
    }

}
