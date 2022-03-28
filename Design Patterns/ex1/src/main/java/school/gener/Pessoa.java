package school.gener;

public class Pessoa {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String endereco;
    private String ocupacao;
    private String rg;
    private String naturalidade;
    private String nacionalidade;
    private String nomePai;
    private String nomeMae;
    
    
    
    static class PessoaBuilder {
        
        protected Pessoa pessoa;
        
        PessoaBuilder() {
            this.pessoa = new Pessoa();
        }
        
        public Pessoa build() {
             return this.pessoa;
        }
        
        public PessoaBuilder buildNome(String nome) {
            this.pessoa.nome = nome;
            return this;
        }
        
        public PessoaBuilder buildCpf(String cpf) {
            this.pessoa.cpf = cpf;
            return this;
        }
        
        public PessoaBuilder buildDataNascimento(Date dataNascimento) {
            this.pessoa.dataNascimento = dataNascimento;
            return this;
        }
        
        
        public PessoaBuilder buildEndereco(String endereco) {
            this.pessoa.endereco = endereco;
            return this;
        }
        
        public PessoaBuilder buildOcupacao(String ocupacao) {
            this.pessoa.ocupacao = ocupacao;
            return this;
        }
        
        public PessoaBuilder buildRg(String rg) {
            this.pessoa.rg = rg;
            return this;
        }
        
        public PessoaBuilder buildNaturalidade(String naturalidade) {
            this.pessoa.naturalidade = naturalidade;
            return this;
        }
        
        public PessoaBuilder buildNacionalidade(String nacionalidade) {
            this.pessoa.nacionalidade =  nacionalidade;
            return this;
        }
        
        public PessoaBuilder buildNomePai(String nomePai) {
            this.pessoa.nomePai = nomePai;
            return this;
        }
        
        public PessoaBuilder nomeMae(String nomeMae) {
            this.pessoa.nomeMae = nomeMae;
            return this;
        }
    }
}