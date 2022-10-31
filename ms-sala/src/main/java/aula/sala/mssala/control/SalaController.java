package aula.sala.mssala.control;

import aula.sala.mssala.control.dto.SalaDTO;
import aula.sala.mssala.model.Sala;
import aula.sala.mssala.repository.SalaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaRepositorio salaRepositorio;

    @GetMapping("/")
    public List<Sala> listarTodasSala(){
        return salaRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Sala buscarPorId(@PathVariable(name = "id")Long id){
        return salaRepositorio.findById(id).orElse(null);
    }
    @GetMapping("/inf/{id}")
    public SalaDTO buscarPodIdBasico(@PathVariable(name = "id")Long id){
        Sala sala = salaRepositorio.getReferenceById(id);
        SalaDTO dto = new SalaDTO(sala);
        return dto;
    }

    @PostMapping("/")
    public void inserirSala(@RequestBody Sala sala){
        salaRepositorio.save(sala);
    }

    @PutMapping("/{id}")
    public SalaDTO alterarSala(@PathVariable(name = "id")Long id, @RequestBody Sala sala){
        Sala salaBase = salaRepositorio.getReferenceById(id);
        salaBase.setNome(sala.getNome());
        salaBase.setNumeroLugares(sala.getNumeroLugares());
        salaRepositorio.save(salaBase);
        return new SalaDTO(salaBase);
    }

    @DeleteMapping("/{id}")
    public SalaDTO deletarSala(@PathVariable(name = "id")Long id){
        Sala sala = salaRepositorio.getReferenceById(id);
        SalaDTO dto = new SalaDTO(sala);
        salaRepositorio.delete(sala);
        return dto;
    }
}
