package aula.funcionario.msfuncionario.control.dto;

import aula.funcionario.msfuncionario.model.Funcionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String dataAdmissao;
    private String dataNascimento;

    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.dataAdmissao = funcionario.getDataAdmissao().format(FORMATO_DATA);
        this.dataNascimento = funcionario.getDataNascimento().format(FORMATO_DATA);
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

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Funcionario converteFuncionario(){
        Funcionario funcionario = new Funcionario();
        funcionario.setId(this.getId());
        funcionario.setNome(this.getNome());
        funcionario.setDataAdmissao(LocalDate.parse(this.getDataAdmissao(),FORMATO_DATA));
        funcionario.setDataNascimento(LocalDate.parse(this.getDataNascimento(),FORMATO_DATA));
        return funcionario;
    }
    public static List<FuncionarioDTO> converteListaDTO(List<Funcionario> funcionarioList){
        List<FuncionarioDTO> dtos = new ArrayList<>();
        for (Funcionario funcionario :
                funcionarioList) {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
            dtos.add(funcionarioDTO);
        }
        return dtos;
    }
}
