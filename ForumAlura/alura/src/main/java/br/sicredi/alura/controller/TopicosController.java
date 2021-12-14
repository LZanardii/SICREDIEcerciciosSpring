package br.sicredi.alura.controller;


import br.sicredi.alura.model.form.TopicoForm;
import br.sicredi.alura.model.dto.TopicoDto;
import br.sicredi.alura.model.Topico;
import br.sicredi.alura.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    TopicoService topicoService;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso){
        if (nomeCurso != null){
         return TopicoService.converterListaParaDto(topicoService.getTopicoRepository().findByCurso_Nome(nomeCurso));
        }
        return TopicoService.converterListaParaDto(topicoService.getTopicoRepository().findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> procuraPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(TopicoService.converterParaDto(topicoService.getTopicoRepository().findById(id).get()));
        }catch (NoSuchElementException notFoundException){
            return ResponseEntity.badRequest().body("ID não encontrado.");
        }
    }

    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@Valid @RequestBody TopicoForm topicoForm,
                                               UriComponentsBuilder uriBuilder){
        Topico topico = topicoForm.converter(topicoService.getCursoRepository());
        topicoService.getTopicoRepository().save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id,
                            @RequestHeader String titulo,
                            @RequestHeader String mensagem)
    {
        try {
            return ResponseEntity.ok(TopicoService.converterParaDto(topicoService.atualizaTopico(id, titulo, mensagem)));
        }catch (RuntimeException error){
            return ResponseEntity.badRequest().build();
        }
    }

}
