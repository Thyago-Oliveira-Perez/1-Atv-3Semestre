package Model;

import java.util.Date;

abstract class AbstractEntity {

    private Long id;
    private Date cadastro;
    private Date atualizado;
    private Date excluido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public Date getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(Date atualizado) {
        this.atualizado = atualizado;
    }

    public Date getExcluido() {
        return excluido;
    }

    public void setExcluido(Date excluido) {
        this.excluido = excluido;
    }

    @Override
    public String toString() {
        return "Model.AbstractEntity{" +
                "id=" + id +
                ", cadastro=" + cadastro +
                ", atualizado=" + atualizado +
                ", excluido=" + excluido +
                '}';
    }
}
