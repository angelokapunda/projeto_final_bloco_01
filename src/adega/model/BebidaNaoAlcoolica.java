package adega.model;

public class BebidaNaoAlcoolica extends Bebida{

    private String contemAcucar;


    public BebidaNaoAlcoolica(String fabricante, String nome, float preco, int volume, String contemAcucar) {
        super(fabricante, nome, preco, volume);
        this.contemAcucar = contemAcucar;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.println("Contem Açucar : " + contemAcucar );
    }

    public String isContemAcucar() {
        return contemAcucar;
    }

    public void setContemAcucar(String contemAcucar) {
        this.contemAcucar = contemAcucar;
    }
}
