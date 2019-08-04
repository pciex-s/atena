package br.com.atena.model.enuns;

public enum StatusProduto {

    ESTOQUE(1, "ESTOQUE"),
    FORA(2, "FORA");

    private int codigo;
    private String descricao;

    private StatusProduto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static StatusProduto toEnum(Integer codigo) {


        for (StatusProduto x : StatusProduto.values()) {
            if (codigo.equals(x.getCodigo()))
                return x;
        }
        return null;
    }
}
