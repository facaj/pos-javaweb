package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.model.Curso;
import dev.fujioka.java.avancado.web.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CursoService {

    @Autowired
    private CursoRepository CursoRepository;

    public Curso salvar(Curso Curso){
        return CursoRepository.save(Curso);
    }

    public List<Curso> listarCursos(){
        return CursoRepository.findAll();
    }

    public Curso consultarPorId(int id){
        return CursoRepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        CursoRepository.deleteById(id);
    }

    public Curso alterar(Curso Curso){
        if(Objects.isNull(Curso.getId())){
            throw new RuntimeException("ID não preenchido");
        }
        return CursoRepository.save(Curso);
    }

    public List<Curso> buscarCursoLike(String nome){
        return CursoRepository.buscarCursoPorNomeLike(nome);
    }

    public List<Curso> buscarCursoPorProfessorLike(String professor){
        return CursoRepository.buscarCursoPorProfessorLike(professor);
    }

    public List<Curso> buscarCursoPorDescricaoLike(String descricao){
        return CursoRepository.buscarCursoPorDescricaoLike(descricao);
    }


}
