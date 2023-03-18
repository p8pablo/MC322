import java.util.Random;

public class Sinistro{
    private int id;
    private String data;
    private String endereco;

    //Construtor
    public Sinistro(int id, String data ,String endereco){
        this.data = data;
        this.endereco = endereco;
        Random gerarInteiro = new Random();
        int id = gerarInteiro.nextInt();        
    }

    //Getters e Setters
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    public String getEndereco (){
        return endereco;
    }
    public void setEndereco(){
        this.endereco = endereco;
    }

}