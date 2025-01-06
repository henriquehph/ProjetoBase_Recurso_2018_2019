package aed.avaliacao.recurso.modelo;

import java.io.Serializable;

public class Imovel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String concelho;
    private String tipologia;
    private double preco;

    public Imovel(String concelho, String tipologia, double preco) {
        this.concelho = concelho;
        this.tipologia = tipologia;
        this.preco = preco;
    }

    public String getConcelho() {
        return concelho;
    }

    public String getTipologia() {
        return tipologia;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return concelho + " - " + tipologia + " - " + preco + "€";
    }
}
