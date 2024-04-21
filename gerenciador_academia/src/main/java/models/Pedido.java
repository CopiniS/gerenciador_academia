
package models;

public class Pedido {
    private String formaPagamento;
    private Integer quantidadeParcelas;
    private Plano plano;
    private Cliente cliente;

    public Pedido(String formaPagamento, Integer quantidadeParcelas, Plano plano, Cliente cliente) {
        this.formaPagamento = formaPagamento;
        this.quantidadeParcelas = quantidadeParcelas;
        this.plano = plano;
        this.cliente = cliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
