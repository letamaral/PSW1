public class Ingrediente {
    private String nome;
    private int calorias;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCalorias(){
        return calorias;
    }
    public void setCalorias(int kal){
        calorias = kal;
    }
    
    /* CONSTRUTOR
    public Ingrediente(String n, int cal){
        calorias = cal;
        nome = n;
        System.out.println("Alguem instanciou um novo objeto.");
        calorias = 10;
    }*/
    
}
