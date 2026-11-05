package model;

public class Aluno {
    //static class alunoDados {
        private String nome;
        private int idade;
        private double nota;

        public void setNome(String nome){
            this.nome=nome;
        }
        public String getNome(){
            return this.nome;
        }
        public void setIdade(int idade){
            this.idade=idade;
        }
        public int getIdade(){
            return this.idade;
        }
        public void setNota(Double nota){
            this.nota=nota;
        }
        public Double getNota(){
            return this.nota;
        }
        @Override 
        public String toString(){
            return "Aluno: "+this.nome+"\r\nNota: "+this.nota+"\r\nIdade: "+this.idade;
        }
    }