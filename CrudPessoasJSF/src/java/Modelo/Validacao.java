package Modelo;
import java.util.List;

public class Validacao
{
    public int id;
    public String mensagem = "";
    
    public void ValidarDadosPessoa(List<String> DadosPessoa)
    {
        
        try
        {
            this.id = Integer.parseInt(DadosPessoa.get(0));
            if(this.id < 0)
                this.mensagem += "ID invalido, insira um ID maior que 0";
        }
        catch(Exception e)
        {
            this.mensagem += "ID invalido, Insira um número válido\n";
        }
        
        if( DadosPessoa.get(1).equals("") && DadosPessoa.get(2).equals("") && DadosPessoa.get(3).equals(""))
            this.mensagem += "Preencha pelo menos um dos dados\n";
        
        else
        {
            if(DadosPessoa.get(1).length() > 30)
                this.mensagem += "Nome com mais de 30 Caracteres\n";

            if(DadosPessoa.get(2).length() > 10)
                this.mensagem += "RG com mais de 10 Caracteres\n";

            if(DadosPessoa.get(3).length() > 13)
                this.mensagem += "CPF com mais de 13 Caracteres\n";
        }
        
    }
    
    public void ValidarIDDadosPessoa(List<String> DadosPessoa)
    {
        this.mensagem = "";
        try
        {
            this.id = Integer.parseInt(DadosPessoa.get(0));
            if(this.id < 0)
                this.mensagem += "ID invalido, insira um ID maior que 0 \n";
        }
        catch(Exception e)
        {
            this.mensagem += "ID invalido, Insira um número válido.\n";
        }
    } 
}
