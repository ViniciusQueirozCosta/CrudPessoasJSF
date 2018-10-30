
package DAL;

import Modelo.Pessoa;
import java.util.List;

interface intMetodos
{
    public void CadastrarPessoa(Pessoa pessoa);
    public Pessoa PesquisarPessoaPorId(Pessoa pessoa);
    public void EditarPessoa(Pessoa pessoa);
    public void ExcluirPessoa(Pessoa pessoa);
    public List<Pessoa> PesquisarPessoaPorNome(Pessoa pessoa);
}
