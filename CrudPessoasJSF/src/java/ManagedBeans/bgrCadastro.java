
package ManagedBeans;

import Modelo.Controle;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean
@RequestScoped
public class bgrCadastro
{
    private String nome;
    private String rg;
    private String cpf;
    private String mensagem;
    
    public String cadastrarPessoa()
    {
        Controle controle = new Controle();
        List<String> dadosPessoa = new ArrayList();
        
        dadosPessoa.add(0, "0");
        dadosPessoa.add(1, this.nome);
        dadosPessoa.add(2, this.rg);
        dadosPessoa.add(3, this.cpf);
        
        controle.CadastrarPessoa(dadosPessoa);
        this.mensagem = controle.mensagem;
        
        return "/Paginas/RespostaCadastro.xhtml";
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
