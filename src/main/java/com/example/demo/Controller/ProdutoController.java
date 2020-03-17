package com.example.demo.Controller;

import java.util.Collection;

import com.example.demo.Model.Produto;
import com.example.demo.Service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProdutoController
 */
@Controller
 public class ProdutoController {
    
    @Autowired
    private ProdutoService ps;

    @GetMapping ("")
    public ModelAndView menu ()
    {
        ModelAndView menu = new ModelAndView("menu");
            return menu;
    }


    @GetMapping ("/produto/{id}")
    public ModelAndView produto(
        @PathVariable("id") int id
    )
    {
        ModelAndView produto = new ModelAndView("produto");
        Produto p = ps.getProduto(id);
        produto.addObject("produto", p);
        return produto;
    }

    @GetMapping ("/produtosEmEstoque")
    public ModelAndView estoque()
    {
        ModelAndView estoque = new ModelAndView ("estoque");
        Collection <Produto> produtos = ps.getProdutosEmEstoque();
        estoque.addObject("produtos", produtos);
        return estoque;   
    }      
    
    @GetMapping ("/produtosValorAcima/{valor}")
    public ModelAndView acima(
        @PathVariable("valor") int valor
    )
    {
        ModelAndView acima = new ModelAndView("acima");
        Collection <Produto> p = ps.getProdutosByValorAcima(valor);
        acima.addObject("produtos", p);
        return acima;
    }

    @GetMapping ("/produtosValorAbaixo/{valor}")
    public ModelAndView abaixo(
        @PathVariable("valor") int valor
    )
    {
        ModelAndView abaixo = new ModelAndView("abaixo");
        Collection <Produto> p = ps.getProdutosByValorAbaixo(valor);
        abaixo.addObject("produtos", p);
        return abaixo;
    }
}