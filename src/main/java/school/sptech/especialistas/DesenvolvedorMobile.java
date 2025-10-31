package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorMobile extends Desenvolvedor {
    private Double horasPrototipacao;
    private String plataforma;
    private String linguagem;

    public DesenvolvedorMobile() { }

    public Double getHorasPrototipacao() { return horasPrototipacao; }
    public void setHorasPrototipacao(Double horasPrototipacao) { this.horasPrototipacao = horasPrototipacao; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public String getLinguagem() { return linguagem; }
    public void setLinguagem(String linguagem) { this.linguagem = linguagem; }

    @Override
    public Double calcularSalario() {
        Double base = super.calcularSalario();
        Double prot = (horasPrototipacao == null ? 0.0 : horasPrototipacao);
        Double adicional = prot * 200.0;
        return base + adicional;
    }
}

