package model;

import java.util.HashSet;

public class Curso {
    private String codigo;
    private String descricao;
    private Integer cargaHoraria;
    private HashSet<Aluno> listaAlunos = new HashSet<>();

    public Curso(String codigo, String descricao, Integer cargaHoraria) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public Curso() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public HashSet<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void insereAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public void removeAluno(Aluno aluno){
        listaAlunos.remove(aluno);
    }



}
