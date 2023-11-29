/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 342009
 */
public class Professor {
    
    private int id;
    private String matr;
    private String nome;

    public Professor() {
    }

    public Professor(int id, String matr, String nome) {
        this.id = id;
        this.matr = matr;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatr() {
        return matr;
    }

    public void setMatr(String matr) {
        this.matr = matr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + '}';
    }
    
    
}

