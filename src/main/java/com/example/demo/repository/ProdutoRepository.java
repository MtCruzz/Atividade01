package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;

import com.example.demo.Model.Produto;

import org.springframework.stereotype.Repository;

/**
 * ProdutoRepository
 */
@Repository
public class ProdutoRepository {

    HashMap <Integer, Produto> hmp = new HashMap <Integer, Produto> ();

    public ProdutoRepository ()
    {
        hmp.put(1, new Produto(1, "ADESIVO DO CURINTIA", 1, 25));
        hmp.put(2, new Produto(2, "CANETA AZUL CANETA", 4, 40));
        hmp.put(3, new Produto(3, "CADERNO DO PELÉ", 25, 30));
        hmp.put(4, new Produto(4, "APOSTILA TOPPER", 50, 50));
        hmp.put(5, new Produto(5, "MOCHILA DE RODINHA FALSA", 18, 60));
        hmp.put(6, new Produto(6, "GABARITO ENEM 2020", 5000, 1));
        hmp.put(7, new Produto(7, "BORRACHA", 3, 75));
        hmp.put(8, new Produto(8, "MASCARA CORONAVIRUS", 70, 2));
        hmp.put(9, new Produto(9, "CURA CORONAVIRUS", 9000, 3));
        hmp.put(10, new Produto(10, "BANANA DA TERRA", 6, 10));
    }

    public Produto getProdutoById(int id)
    {
        Produto p = new Produto ();
        for (int i=1; i <= hmp.size(); i++)
        {
            if (hmp.get(i).getCodigo() == id){
                p = hmp.get(i);
                return p;
            }
        }
        return null;
    }

    public Collection <Produto> getProdutos ()
    {
        return hmp.values();
    }
}