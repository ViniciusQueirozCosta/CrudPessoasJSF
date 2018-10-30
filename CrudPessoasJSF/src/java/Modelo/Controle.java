package Modelo;
import DAL.PessoaDAO;
import java.util.ArrayList;
import java.util.List;

public class Controle
{
    public String mensagem;
    
    public void CadastrarPessoa(List<String> DadosPessoa)
    {
        this.mensagem="";
        Validacao validacao = new Validacao();
        validacao.ValidarDadosPessoa(DadosPessoa);
        if(validacao.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(0);
            pessoa.setNome(DadosPessoa.get(1));
            pessoa.setRg(DadosPessoa.get(2));
            pessoa.setCpf(DadosPessoa.get(3));
            
            DAL.PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.CadastrarPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem; 
        }
    }
    
    public Pessoa PesquisarPessoaPorID(List<String> DadosPessoa)
    {
        this.mensagem="";
        Pessoa pessoa = new Pessoa();
        Validacao validacao = new Validacao();
        validacao.ValidarIDDadosPessoa(DadosPessoa);
        if(validacao.mensagem.equals(""))
        {
            pessoa.setId(validacao.id);
            DAL.PessoaDAO pessoaDAO = new PessoaDAO();
            pessoa = pessoaDAO.PesquisarPessoaPorId(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
            this.mensagem += validacao.mensagem;
                
        return pessoa;
    }
    
    public void ExcluirPessoa(List<String> DadosPessoa)
    {
        this.mensagem="";
        Validacao validacao = new Validacao();
        validacao.ValidarIDDadosPessoa(DadosPessoa);
        if(validacao.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(validacao.id);
            DAL.PessoaDAO pessoaDAO = new PessoaDAO();
            pessoa = pessoaDAO.PesquisarPessoaPorId(pessoa);
            if(pessoa.getId() != 0) 
            {
                pessoaDAO.ExcluirPessoa(pessoa);
                this.mensagem =  pessoaDAO.mensagem;
            } 
            else
                this.mensagem = validacao.mensagem;
        }
        else
            this.mensagem = validacao.mensagem;
    }
    
    public void EditarPessoa(List<String> DadosPessoa)
    {
        this.mensagem="";
        Validacao validacao = new Validacao();
        validacao.ValidarDadosPessoa(DadosPessoa);
        if(validacao.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            DAL.PessoaDAO pessoaDAO = new PessoaDAO();
            pessoa.setId(validacao.id);
            pessoa = pessoaDAO.PesquisarPessoaPorId(pessoa);
            if(pessoa.getId() != 0)
            {
                pessoa.setNome(DadosPessoa.get(1));
                pessoa.setRg(DadosPessoa.get(2));
                pessoa.setCpf(DadosPessoa.get(3));
                pessoaDAO.EditarPessoa(pessoa);
                this.mensagem = pessoaDAO.mensagem;
            }
            else
                this.mensagem = pessoaDAO.mensagem;
        }
        else
            this.mensagem = validacao.mensagem;
    }
    
    public void PesquisarPessoaPorNome(List<String> DadosPessoa)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.ValidarDadosPessoa(DadosPessoa);
        if(validacao.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(DadosPessoa.get(1));
            PessoaDAO pessoaDAO = new PessoaDAO();
            atbEstaticos.listaPessoasEstatico = pessoaDAO.PesquisarPessoaPorNome(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
            this.mensagem = validacao.mensagem;
                
    }
}
