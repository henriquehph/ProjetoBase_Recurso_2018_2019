package aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.deprecated;

import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */

@Deprecated
public class ListaDuplaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    private static final long serialVersionUID = 1L;
    protected No noInicial;
    protected No noFinal;
    protected int numeroElementos;

    public ListaDuplaNaoOrdenada() {
        noInicial = null;
        noFinal = null;
        numeroElementos = 0;
    }

    public ListaDuplaNaoOrdenada(ColecaoIteravel<T> colecao) {
        this();

        IteradorIteravel<T> iterador = colecao.iterador();
        if (iterador.podeAvancar()) {
            noFinal = noInicial = new No(iterador.avancar());
        }
        while (iterador.podeAvancar()) {
            No novo = new No(iterador.avancar());
            noFinal.seguinte = novo;
            noFinal = novo;
        }
        numeroElementos = colecao.getNumeroElementos();
    }

    protected No getNo(T elem) {
        No cor = noInicial;
        while (cor != null && !cor.elemento.equals(elem)) {
            cor = cor.seguinte;
        }

        return cor;
    }

    protected No getNoPorReferencia(T elem) {
        No cor = noInicial;
        while (cor != null && cor.elemento != elem) {
            cor = cor.seguinte;
        }

        return cor;
    }

    private No getNoPorIndice(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            throw new IndexOutOfBoundsException();
        }

        No cor;
        if (indice < numeroElementos / 2) {
            cor = noInicial;
            while (indice-- > 0) {
                cor = cor.seguinte;
            }
        } else {
            cor = noFinal;
            while (++indice < numeroElementos) {
                cor = cor.anterior;
            }
        }

        return cor;
    }

    @Override
    public void inserirNoInicio(T elem) {
        if (++numeroElementos == 1) {
            noInicial = noFinal = new No(elem);
        } else {
            noInicial = new No(elem, noInicial);
        }
    }

    @Override
    public void inserirNoFim(T elem) {
        noFinal = new No(elem);
        if (++numeroElementos == 1) {
            noInicial = noFinal;
        }
    }

    @Override
    public void inserirPorIndice(int indice, T elem) {
        if (indice == 0) {
            inserirNoInicio(elem);
        } else if (indice == numeroElementos) {
            inserirNoFim(elem);
        } else {
            new No(elem, getNoPorIndice(indice));
            numeroElementos++;
        }

    }

    private T removerNo(No aRemover) {
        aRemover.anterior.seguinte = aRemover.seguinte;
        aRemover.seguinte.anterior = aRemover.anterior;
        numeroElementos--;

        return aRemover.elemento;
    }

    @Override
    public T remover(T elem) {
        if (numeroElementos == 0) {
            return null;
        }

        if (noInicial.elemento.equals(elem)) {
            return removerDoInicio();
        }

        if (noFinal.elemento.equals(elem)) {
            return removerDoFim();
        }

        No no = getNo(elem);

        return no != null ? removerNo(no) : null;
    }

    @Override
    public T removerPorReferencia(T elem) {
        if (numeroElementos == 0) {
            return null;
        }

        if (noInicial.elemento == elem) {
            return removerDoInicio();
        }

        if (noFinal.elemento == elem) {
            return removerDoFim();
        }

        No no = getNoPorReferencia(elem);

        return no != null ? removerNo(no) : null;
    }

    @Override
    public T removerPorIndice(int indice) {
        if (indice == 0) {
            return removerDoInicio();
        }
        if (indice == numeroElementos - 1) {
            return removerDoFim();
        }

        return removerNo(getNoPorIndice(indice));
    }

    @Override
    public T removerDoInicio() {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = noInicial;
        noInicial = noInicial.seguinte;
        if (--numeroElementos == 0) {
            noFinal = null;
        } else {
            noInicial.anterior = null;
        }

        return aux.elemento;
    }

    @Override
    public T removerDoFim() {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = noFinal;
        if (--numeroElementos == 0) {
            noInicial = noFinal = null;
        } else {
            noFinal = noFinal.anterior;
            noFinal.seguinte = null;
        }

        return aux.elemento;
    }

    @Override
    public T consultarPorIndice(int indice) {
        return getNoPorIndice(indice).elemento;
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public boolean contem(T elem) {
        return getNo(elem) != null;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem) != null;
    }

    @Override
    public IteradorIteravelDuplo<T> iterador() {
        return new Iterador();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Lista Dupla Não Ordenada = {\n");
        No aux = noInicial;
        while (aux != null) {
            s.append(aux.elemento).append("\n");
            aux = aux.seguinte;
        }
        s.append("}\n");
        return s.toString();
    }


    public class No implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No anterior;
        protected No seguinte;

        // Criação de nó com elemento elem depois do noFinal da lista
        protected No(T elem) {
            elemento = elem;
            anterior = noFinal;
            seguinte = null;
            if (noFinal != null) {
                noFinal.seguinte = this;
            }
        }

        // Criação de nó com elemento elem e inserção antes o nó seg (!= null)
        protected No(T elem, No seg) {
            elemento = elem;
            anterior = seg.anterior;
            seguinte = seg;
            seg.anterior = this;

            if (anterior != null) {
                anterior.seguinte = this;
            }
        }
    }

    public class Iterador implements IteradorIteravelDuplo<T> {
        protected No anterior;
        protected No corrente;
        protected No seguinte;

        protected Iterador() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            anterior = noFinal;
            corrente = null;
            seguinte = noInicial;
        }

        @Override
        public T corrente() {
            if (corrente == null) {
                throw new NoSuchElementException();
            }
            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return seguinte != null;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }

            anterior = corrente;
            corrente = seguinte;
            seguinte = seguinte.seguinte;
            return corrente.elemento;
        }


        @Override
        public boolean podeRecuar() {
            return anterior != null;
        }

        @Override
        public T recuar() {
            if (!podeRecuar()) {
                throw new NoSuchElementException();
            }

            seguinte = corrente;
            corrente = anterior;
            anterior = anterior.anterior;
            return corrente.elemento;
        }
    }
}
