package br.com.jau.domain;

import anotacao.ColunaTabela;
import anotacao.Tabela;
import anotacao.TipoChave;
import br.com.jau.dao.Persistente;

import java.util.HashSet;
import java.util.Set;

@Tabela("TB_ESTOQUE")
public class Estoque implements Persistente {
    
    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;
    
    @TipoChave("getCodigo")
    @ColunaTabela(dbName = "codigo", setJavaName = "setCodigo")
    private String codigo;
    
    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private Long quantidade;
    
    private Set<ProdutoQuantidade> produtos;
    
    public Estoque() {
        produtos = new HashSet<>();
    }
    
    public Estoque(String codigo, Long quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }
    
    public Integer getQuantidadeTotalProdutos() {
        int result = produtos.stream()
          .reduce(0, (partialCountResult, prod) -> partialCountResult + prod.getQuantidade(), Integer::sum);
        return result;
    }

    // Adiciona um produto ao estoque
    public void adicionarProduto(Produto produto, Integer quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero");
        }

        ProdutoQuantidade produtoQuantidade = new ProdutoQuantidade(produto, quantidade);
        produtos.add(produtoQuantidade);
        // Atualiza a quantidade total no estoque
        this.quantidade += quantidade;
    }

    // Consulta a quantidade de um produto específico no estoque
    public Integer consultarQuantidadeProduto(Produto produto) {
        return produtos.stream()
          .filter(prod -> prod.getProduto().getCodigo().equals(produto.getCodigo()))
          .map(ProdutoQuantidade::getQuantidade)
          .findFirst()
          .orElse(0);
    }

    // Remove um produto do estoque
    public void removerProduto(Produto produto, Integer quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero");
        }

        ProdutoQuantidade produtoQuantidade = produtos.stream()
          .filter(prod -> prod.getProduto().getCodigo().equals(produto.getCodigo()))
          .findFirst()
          .orElse(null);

        if (produtoQuantidade != null) {
            int quantidadeAtual = produtoQuantidade.getQuantidade();
            if (quantidadeAtual >= quantidade) {
                produtoQuantidade.setQuantidade(quantidadeAtual - quantidade);
                // Atualiza a quantidade total no estoque
                this.quantidade -= quantidade;
                if (produtoQuantidade.getQuantidade() == 0) {
                    produtos.remove(produtoQuantidade);
                }
            } else {
                throw new IllegalArgumentException("Não há produtos suficientes em estoque para remover");
            }
        } else {
            throw new IllegalArgumentException("Produto não encontrado no estoque");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long i) {
        this.quantidade = i;
    }
}
