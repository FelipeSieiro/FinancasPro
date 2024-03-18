package br.com.fiap.financaspro.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.financaspro.model.Categoria;
import br.com.fiap.financaspro.repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("categoria")
@Slf4j
@SuppressWarnings("null")
public class CategoriaController {


    @Autowired // envia mudanças para o banco de dados automaticamente
    CategoriaRepository repository;

    @GetMapping
    public List<Categoria> index() {
        return repository.findAll() ; //retorna lista de categoria do banco de dados

    }

  
    @PostMapping
    @ResponseStatus(CREATED)
    public Categoria create(@RequestBody Categoria categoria) { // binding
        log.info("cadastrando categoria {} ", categoria);
        return repository.save(categoria);
    }


    @GetMapping("{id}")
    public ResponseEntity<Categoria> show(@PathVariable Long id) {
        log.info("buscando categoria por id {}", id);

        return repository
            .findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando categoria");

        verificarSeExisteCategoria(id);
        repository.deleteById(id);
    }



    @PutMapping("{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria){
        log.info("atualizando categoria com id {} para {}", id, categoria);
        
        verificarSeExisteCategoria(id);        
        categoria.setId(id);
        return repository.save(categoria);
    }



    private void verificarSeExisteCategoria(Long id) {
            repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Não existe categoria com o `id` informado. Consulte lista em /categoria"
            ));
    }
}   