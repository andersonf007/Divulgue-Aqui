/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Izaquias
 */
@Entity
public class Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(length = 35, nullable = false, unique = true)
    private String nome;
    @Column(length = 35, nullable = false)
    private String endereco;

    public Pessoa() {
    }

    public Pessoa( String nome, String endereco) {
        
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome da Pessoa  deve ser Infomado com um valor válido!");
        }
        
        if(endereco == null || endereco.isEmpty()){
            throw new IllegalArgumentException("O endereço deve ser Informado Corretamente com um valor válido!");
        }
        this.nome = nome;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
