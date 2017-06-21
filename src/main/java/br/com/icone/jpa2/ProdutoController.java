/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icone.jpa2;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Gleywson
 */
@Named(value = "produtoController")
@SessionScoped
public class ProdutoController implements Serializable{

    @Inject
    private ProdutoFacade repositorio;
    
    private Produto produto;
    
    
    public ProdutoController() {
        this.produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void salvar() {
        if(produto.getId() == null) {
            repositorio.create(produto);
        }
        else {
            repositorio.edit(produto);
        }
    }
}
