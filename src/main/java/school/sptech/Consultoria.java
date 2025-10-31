package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer qtdVagas;
    private final List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Consultoria() { }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getQtdVagas() { return qtdVagas; }
    public void setQtdVagas(Integer qtdVagas) { this.qtdVagas = qtdVagas; }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedor == null) return;
        Integer vagas = (qtdVagas == null ? 0 : qtdVagas);
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor == null) return;
        if (Boolean.TRUE.equals(desenvolvedor.isFullstack())) {
            contratar(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double total = 0.0;
        for (Desenvolvedor d : desenvolvedores) {
            total += d.calcularSalario();
        }
        return total;
    }

    public Integer qtdDesenvolvedoresMobile() {
        int count = 0;
        for (Desenvolvedor d : desenvolvedores) {
            if (d instanceof DesenvolvedorMobile) count++;
        }
        return count;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        Double alvo = (salario == null ? 0.0 : salario);
        List<Desenvolvedor> out = new ArrayList<>();
        for (Desenvolvedor d : desenvolvedores) {
            if (d.calcularSalario() >= alvo) out.add(d);
        }
        return out;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) return null;
        Desenvolvedor menor = desenvolvedores.get(0);
        Double menorSalario = menor.calcularSalario();
        for (int i = 1; i < desenvolvedores.size(); i++) {
            Desenvolvedor d = desenvolvedores.get(i);
            Double sal = d.calcularSalario();
            if (sal < menorSalario) {
                menor = d;
                menorSalario = sal;
            }
        }
        return menor;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> out = new ArrayList<>();
        if (tecnologia == null) return out;
        String alvo = tecnologia.trim();
        for (Desenvolvedor d : desenvolvedores) {
            if (d instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb w = (DesenvolvedorWeb) d;
                if (equalsTech(w.getBackend(), alvo) ||
                        equalsTech(w.getFrontend(), alvo) ||
                        equalsTech(w.getSgbd(), alvo)) {
                    out.add(d);
                }
            } else if (d instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile m = (DesenvolvedorMobile) d;
                if (equalsTech(m.getPlataforma(), alvo) ||
                        equalsTech(m.getLinguagem(), alvo)) {
                    out.add(d);
                }
            }
        }
        return out;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double total = 0.0;
        for (Desenvolvedor d : buscarPorTecnologia(tecnologia)) {
            total += d.calcularSalario();
        }
        return total;
    }

    private Boolean equalsTech(String a, String b) {
        if (a == null || b == null) return false;
        return a.trim().equalsIgnoreCase(b.trim());
    }
}

