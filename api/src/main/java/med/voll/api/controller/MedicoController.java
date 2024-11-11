package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.medico.DadosCadastrosMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastrosMedico dados){
        medicoRepository.save(new Medico(dados));

    }
    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);

    }
}
