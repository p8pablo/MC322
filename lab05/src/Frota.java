import java.util.ArrayList;

public class Frota {

  private String code;
  private ArrayList<Veiculo> listaVeiculos;
  //Construtor  
  public Frota(String code, ArrayList<Veiculo> listaVeiculos) {
    this.code = gerarCode();
    this.listaVeiculos = listaVeiculos;
  }
  //Getters e Setters
    public String getCode() {
        return this.code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public Frota listaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        setListaVeiculos(listaVeiculos);
        return this;
    }
    //adicionar veiculo
    public boolean addVeiculo(Veiculo veiculo){
        for (Veiculo veiculos : listaVeiculos) {
            if(veiculos == veiculo){
                System.out.println("Veículo com placa já cadastrada!");
                return false;
            }
        }
        listaVeiculos.add(veiculo);
        return true;
    }

    //remover veiculo
    public boolean removeVeiculo(Veiculo veiculo){
        for(Veiculo veiculos : listaVeiculos){
            if(veiculos == veiculo){
                listaVeiculos.remove(veiculo);
                return true;
            }
        }
        System.out.println("Veículo inexistente!");
        return false;
    }
    
    //TODO
    public String gerarCode(){
        return code;
    }
    @Override
    public String toString() {
        return "{" +
            " code='" + getCode() + "'" +
            ", listaVeiculos='" + getListaVeiculos() + "'" +
            "}";
    }
  
}
