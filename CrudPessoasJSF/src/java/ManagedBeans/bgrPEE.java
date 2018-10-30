package ManagedBeans;

import Modelo.Controle;
import Modelo.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean
@RequestScoped
public class bgrPEE
{
    private String id;
    private String nome;
    private String rg;
    private String cpf;
    private String mensagem;

    public void pesquisarPorId()
    {
        Controle controle = new Controle();
        List<String> dadosPessoa = new ArrayList();
        
        dadosPessoa.add(0, this.id);
        dadosPessoa.add(1, "not value");
        dadosPessoa.add(2, "not value");
        dadosPessoa.add(3, "not value");
        
        Pessoa pessoa = controle.PesquisarPessoaPorID(dadosPessoa);
        
        if(pessoa.getId() != null)
        {
            this.id = pessoa.getId().toString();
            this.nome = pessoa.getNome();
            this.rg = pessoa.getRg();
            this.cpf = pessoa.getCpf();
        }
        else
        {
            this.mensagem = controle.mensagem;
        }
            
        
    }
    
    public String editar()
    {
        Controle controle = new Controle();
        List<String> dadosPessoa = new ArrayList();
        
        dadosPessoa.add(0, this.id);
        dadosPessoa.add(1, this.nome);
        dadosPessoa.add(2, this.rg);
        dadosPessoa.add(3, this.cpf);
        
        controle.EditarPessoa(dadosPessoa);
        
        this.mensagem = controle.mensagem;
        
        return "/Paginas/RespostaPesquisaEdicaoExclusao.xhtml";
    }
    
    public String excluir()
    {
        Controle controle = new Controle();
        List<String> dadosPessoa = new ArrayList();
        
        dadosPessoa.add(0, this.id);
        dadosPessoa.add(1, "not value");
        dadosPessoa.add(2, "not value");
        dadosPessoa.add(3, "not value");
        
        controle.ExcluirPessoa(dadosPessoa);
        
        this.mensagem = controle.mensagem;
        
        return "/Paginas/RespostaPesquisaEdicaoExclusao.xhtml";
    }
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }
}
