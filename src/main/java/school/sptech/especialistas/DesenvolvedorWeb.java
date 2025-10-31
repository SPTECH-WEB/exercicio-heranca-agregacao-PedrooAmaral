package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {
    private Double horasMentoria;
    private String backend;
    private String frontend;
    private String sgbd;

    public DesenvolvedorWeb() { }

    public Double getHorasMentoria() { return horasMentoria; }
    public void setHorasMentoria(Double horasMentoria) { this.horasMentoria = horasMentoria; }

    public String getBackend() { return backend; }
    public void setBackend(String backend) { this.backend = backend; }

    public String getFrontend() { return frontend; }
    public void setFrontend(String frontend) { this.frontend = frontend; }

    public String getSgbd() { return sgbd; }
    public void setSgbd(String sgbd) { this.sgbd = sgbd; }

    @Override
    public Double calcularSalario() {
        Double base = super.calcularSalario();
        Double mentoria = (horasMentoria == null ? 0.0 : horasMentoria);
        Double adicional = mentoria * 300.0;
        return base + adicional;
    }

    public Boolean isFullstack() {
        return backend != null && frontend != null && sgbd != null;
    }
}
