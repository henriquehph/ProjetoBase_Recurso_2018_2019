package aed.avaliacao.recurso;

import aed.avaliacao.recurso.modelo.GestorImoveis;
import aed.avaliacao.recurso.modelo.Imovel;
public class MainAvaliacaoGestorImoveis {

    public static void main(String[] args) {
        Imovel[] imoveis = new Imovel[]{ //novo array de objetos chamado imovel, que sao importados , vindos do modelo
                new Imovel("Lisboa", "T1", 500000),
                new Imovel("Lisboa", "T2", 1000000),
                new Imovel("Lisboa", "T1", 600000),
                new Imovel("Leiria", "T1", 200000),
                new Imovel("Leiria", "T2", 300000)
        };

        for (Imovel imovel : imoveis) { // for each member imovel tipo imovel de imoveis
            GestorImoveis.INSTANCIA.inserir(imovel);
        }

        System.out.println("Todos os imóveis");
        for (Imovel imovel : GestorImoveis.INSTANCIA.consultarImoveis()) {
            System.out.println(imovel);
        }

        System.out.println();
        System.out.println("Imóveis em Leiria");
        for (Imovel imovelDoPorto : GestorImoveis.INSTANCIA.consultarImoveis("Leiria")) {
            System.out.println(imovelDoPorto);
        }

        System.out.println();
        System.out.println("Preço médio de um T1 em Lisboa");
        System.out.println(GestorImoveis.INSTANCIA.consultarPrecoMedioImoveis("Lisboa", "T1"));

        System.out.println();
        System.out.println("Imóvel com preço máximo em Lisboa");
        System.out.println(GestorImoveis.INSTANCIA.consultarImovelComPrecoMaximo("Lisboa"));
    }

}
