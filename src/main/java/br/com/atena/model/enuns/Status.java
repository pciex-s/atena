package br.com.atena.model.enuns;

public enum Status {

    ESTOQUE(0, "INATIVO"),
    ATIVO(1, "ATIVO");

    private int codigo;
    private String descricao;

    private Status(int codigo, String descricao) {
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

    public static Status toEnum(Integer codigo) {


        for (Status x : Status.values()) {
            if (codigo.equals(x.getCodigo()))
                return x;
        }
        return null;
    }
}
