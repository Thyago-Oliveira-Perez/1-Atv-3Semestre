public class Paciente extends Pessoa {

    private String plano;
    private String convenio;

    public Paciente() {
    }

    public Paciente(String plano, String convenio) {
        this.plano = plano;
        this.convenio = convenio;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "plano='" + plano + '\'' +
                ", convenio='" + convenio + '\'' +
                '}';
    }
}
