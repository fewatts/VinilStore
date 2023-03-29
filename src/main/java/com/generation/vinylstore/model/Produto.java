package com.generation.vinylstore.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produto {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Size(max = 5000, message = "O link da foto não podeter mais de 5000 caracteres")
        private String foto;

        @NotBlank(message = "O nome do produto é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve conter no mínimo 3 e no máximo 100 caracteres.")
        private String nome;

        @NotBlank(message = "O país do produto é obrigatório")
        @Size(min = 3, max = 100, message = "O nome do país deve conter no mínimo 3 e no máximo 100 caracteres.")
        private String pais;

        @Positive
        private Integer quantidade;

        @Positive
        @Digits(integer = 6, fraction = 2, message = "O preço é obrigatório!")
        private Float valor;

        @UpdateTimestamp
        private LocalDate data;

    @ManyToOne
        @JsonIgnoreProperties("produto")
        private Categorias categorias;

    @ManyToOne
        @JsonIgnoreProperties("produto")
        private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
