public class Secretaria extends Pessoa{

    private String ctps;
    private int cargaHoraria;

    public Secretaria() {
    }

    public Secretaria(String ctps, int cargaHoraria) {
        this.ctps = ctps;
        this.cargaHoraria = cargaHoraria;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Secretaria{" +
                "ctps='" + ctps + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
