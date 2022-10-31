package aula.funcionario.msfuncionario.control;

import aula.funcionario.msfuncionario.control.dto.FuncionarioDTO;
import aula.funcionario.msfuncionario.model.Funcionario;
import aula.funcionario.msfuncionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping("/")
    public List<FuncionarioDTO> listarTodosFuncionarios(){
        List<Funcionario> funcionarioList = repository.findAll();
        List<FuncionarioDTO> dtos = FuncionarioDTO.converteListaDTO(funcionarioList);
        return dtos;
    }
    @GetMapping("/{id}")
    public FuncionarioDTO consutarPorId(@PathVariable(name = "id")Long id){
        Funcionario funcionario = repository.getReferenceById(id);
        return new FuncionarioDTO(funcionario);
    }
    @PostMapping("/")
    public void inserirFuncionario(@RequestBody FuncionarioDTO dto){
        Funcionario funcionario = dto.converteFuncionario();
        repository.save(funcionario);
    }
    @PutMapping("/{id}")
    public FuncionarioDTO alterarFuncionario(@PathVariable(name = "id")Long id, @RequestBody FuncionarioDTO dto){
        Funcionario funcionarioBase = repository.getReferenceById(id);
        dto.setId(funcionarioBase.getId());
        Funcionario funcionarioAlterado = dto.converteFuncionario();
        repository.save(funcionarioAlterado);
        return dto;
    }
    @DeleteMapping("/{id}")
    public FuncionarioDTO deletarFuncionario(@PathVariable(name = "id")Long id){
        Funcionario funcionario = repository.getReferenceById(id);
        FuncionarioDTO dto = new FuncionarioDTO(funcionario);
        repository.delete(funcionario);
        return dto;
    }
}
