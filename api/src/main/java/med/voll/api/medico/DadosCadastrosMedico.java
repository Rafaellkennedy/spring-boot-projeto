package med.voll.api.medico;

import med.voll.api.endereço.DadosEndereço;

public record DadosCadastrosMedico<Especialidade>(String nome, String email, String crm, Especialidade especialidade, DadosEndereço endereço) {
}
