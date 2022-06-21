/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author pc
 */
public class Nota  {

    private Integer idNotas;
    private Materia idCurso;
    private Alumno alumno;
    private double nota;

    public Nota(double na) {
        this.nota = na;
    }



    public Integer getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public Materia getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Materia idCurso) {
        this.idCurso = idCurso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Nota(Materia idCurso, Alumno idAlumno, double nota) {
        this.idCurso = idCurso;
        this.alumno = idAlumno;
        this.nota = nota;
    }

    public Nota(Integer idNotas, Materia idCurso, Alumno idAlumno, double nota) {
        this.idNotas = idNotas;
        this.idCurso = idCurso;
        this.alumno = idAlumno;
        this.nota = nota;
    }

}
