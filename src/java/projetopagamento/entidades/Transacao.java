package projetopagamento.entidades;

public class Transacao {
    private int id;
    private String data;
    private float valor;
    private Usuario destinatario;
    private Usuario remetente;
    private Conta contaBeneficiada;
    private Cartao cartao;

    public Transacao(int id, String data, float valor, Usuario destinatario, Usuario remetente, Conta contaBeneficiada, Cartao cartao) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.destinatario = destinatario;
        this.remetente = remetente;
        this.contaBeneficiada = contaBeneficiada;
        this.cartao = cartao;
    }
    
    public Transacao() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public Conta getContaBeneficiada() {
        return contaBeneficiada;
    }

    public void setContaBeneficiada(Conta contaBeneficiada) {
        this.contaBeneficiada = contaBeneficiada;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
    
    
}
