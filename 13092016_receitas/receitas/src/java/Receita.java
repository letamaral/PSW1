import java.util.List;
public class Receita {
    private String nome;
    private String modoPreparo;
    private int pessoas;
    private List<Ingrediente> ingredientes;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getModoPreparo() {
        return modoPreparo;
    }
    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }
    public int getPessoas() {
        return pessoas;
    }
    public void setPessoas(int pessoas) {
        this.pessoas = pessoas;
    }
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
    
    
}
