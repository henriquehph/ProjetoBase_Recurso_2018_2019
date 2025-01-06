package aed.avaliacao.recurso.modelo;

import java.io.Serializable;
import java.util.Objects;

public class GestorPrecoMedio implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tipologia;
    private Double total;
    private Integer numeroimoveis;
    private Double media;
    //TODO Shift f6 - Alterar numeroimoveis para numeroImoveis (não alterei para não estragar o IDS)
    public GestorPrecoMedio(String tipologia) {
        total = 0D;
        numeroimoveis = 0;
        media = 0D;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestorPrecoMedio that = (GestorPrecoMedio) o;
        return Objects.equals(tipologia, that.tipologia);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tipologia);
    }

    @Override
    public String toString() {
        return " (" + tipologia + ", " + total + ", " + numeroimoveis + ", " + media + ")";
    }

    public double getMedia() {
        return media;
    }

    public void inserir(Imovel imovel) {
        total += imovel.getPreco();
        numeroimoveis++;
        media = total / numeroimoveis;
    }
}