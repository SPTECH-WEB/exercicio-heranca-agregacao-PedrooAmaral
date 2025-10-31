package school.sptech;

import java.util.Objects;

public class Desenvolvedor {
    protected String nome;
    protected Double qtdHoras;
    protected Double valorHora;

    public Desenvolvedor() { }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getQtdHoras() { return qtdHoras; }
    public void setQtdHoras(Double qtdHoras) { this.qtdHoras = qtdHoras; }

    public Double getValorHora() { return valorHora; }
    public void setValorHora(Double valorHora) { this.valorHora = valorHora; }

    public Double calcularSalario() {
        Double horas = (qtdHoras == null ? 0.0 : qtdHoras);
        Double valor = (valorHora == null ? 0.0 : valorHora);
        return horas * valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Desenvolvedor)) return false;
        Desenvolvedor that = (Desenvolvedor) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

