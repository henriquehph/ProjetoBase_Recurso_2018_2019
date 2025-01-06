package aed.avaliacao.recurso.modelo;

import aed.Comparacao;

public enum CopAsc implements Comparacao<Imovel> {
    CRITERIO;

    @Override
    public int comparar(Imovel o1, Imovel o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}
