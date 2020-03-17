package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Collection;

import com.example.demo.Model.Produto;
import com.example.demo.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository pr;

    public Produto getProduto (int id)
    {
        Produto p = pr.getProdutoById(id);
        if (p != null)
            return p; 
        return null;
    }

    public Collection <Produto> getProdutosEmEstoque()
    {
        return pr.getProdutos();
    }

    public Collection <Produto> getProdutosByValorAcima(double valor)
    {
        ArrayList <Produto> produtosAcima = new ArrayList <Produto> ();
        for (Produto pp: pr.getProdutos())
            if (pp.getValor() > valor)
                produtosAcima.add(pp);

        return produtosAcima;
    }

    public Collection <Produto> getProdutosByValorAbaixo(double valor)
    {
        ArrayList <Produto> produtosAbaixo = new ArrayList <Produto>();
        for (Produto pp: pr.getProdutos())
            if (pp.getValor() < valor)
                produtosAbaixo.add(pp);

        return produtosAbaixo;
    }


}