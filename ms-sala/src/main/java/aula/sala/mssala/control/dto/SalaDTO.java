package aula.sala.mssala.control.dto;

import aula.sala.mssala.model.Sala;

public class SalaDTO {
    private Long id;
    private String nome;

    public SalaDTO(Sala sala) {
        this.id = sala.getId();
        this.nome = sala.getNome();
    }

    public SalaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sala retornaSala(){
        Sala sala = new Sala();
        sala.setId(this.getId());
        sala.setNome(this.getNome());
        return sala;
    }
}
