
package DAL;

import Modelo.Pessoa;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PessoaDAO implements intMetodos
{
    public String mensagem;
    Session session = Conexao.getSessionFactory().openSession();
    
    @Override
    public void CadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.save(pessoa);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Pessoa cadastrada com sucesso!";
        }
        catch (HibernateException e)
        {
            this.mensagem = "Erro no cadastro: " +e.getMessage();
        }
    }

    @Override
    public void EditarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.saveOrUpdate(pessoa);
            session.getTransaction().commit();
            session.close();

            this.mensagem = "Pessoa editada com sucesso!";
        }
        catch (HibernateException e)
        {
            this.mensagem= "Erro: " + e.getMessage();
        }
        
    }

    @Override
    public void ExcluirPessoa(Pessoa pessoa)
    {
        try
        {
            this.mensagem = "";
        
            session.beginTransaction();
            session.delete(pessoa);
            session.getTransaction().commit();
            session.close();
            
            this.mensagem = "Pessoa Excluida com sucesso!";
        }
        catch (HibernateException e)
        {
            this.mensagem= "Erro: " + e.getMessage();
        }
        
        
    }

    @Override
    public Pessoa PesquisarPessoaPorId(Pessoa pessoa)
    {
        try
        {
            this.mensagem = "";
        
            Query query = session.createQuery("from Pessoa p where p.id = :id");
            query.setParameter("id", pessoa.getId());
            List<Pessoa> listaPessoa =  query.list();
            pessoa = listaPessoa.get(0);
            return pessoa;
        }
        catch(HibernateException e)
        {
            this.mensagem= "Erro: " + e.getMessage();
            return null;
        }
        
    }

    @Override
    public List<Pessoa> PesquisarPessoaPorNome(Pessoa pessoa)
    {
        try
        {
            this.mensagem = "";
        
            Query query = session.createQuery("from Pessoa p where p.nome like :nome");
            query.setParameter("nome", "%" + pessoa.getNome() + "%");
            return (List<Pessoa>) query.list();
        }
        catch (HibernateException e)
        {
            this.mensagem= "Erro: " + e.getMessage();
            return null;
        }
        
    }
}
