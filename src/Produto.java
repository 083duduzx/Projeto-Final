public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private String fornecedor;

    public Produto(int id, String nome, double preco, int quantidade, String fornecedor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getfornecedor() {
        return fornecedor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setfornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }


    public String toString() {
        return "Produto{" +
                "id = " + id +
                " , fornecedor = " + fornecedor + 
                " , nome = " + nome +
                " , preco = " + preco +
                " , quantidade = " + quantidade +
                '}';
    }
}
