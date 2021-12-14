package br.sicredi.alura.model.form;

import br.sicredi.alura.model.Curso;
import br.sicredi.alura.model.Topico;
import br.sicredi.alura.repository.CursoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopicoForm {

    @NotNull(message = "titulo não pode ser null")
    @NotEmpty(message = "titulo não pode ser vazio")
    private String titulo;

    @NotNull(message = "mensagem não pode ser null")
    @NotEmpty(message = "mensagem não pode ser vazia")
    private String mensagem;

    @NotNull(message = "nomeCurso não pode ser null")
    @NotEmpty(message = "nomeCurso não pode ser vazio")
    private String nomeCurso;

    public Topico converter(CursoRepository cursoRepository){
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
