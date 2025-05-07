package adega.model;

public class BebidaAlcoolica extends Bebida{

    private int teorDeAlcool;

    public BebidaAlcoolica(String fabricante, String nome, float preco, int volume, int teorDeAlcool) {
        super(fabricante, nome, preco, volume);
        this.teorDeAlcool = teorDeAlcool;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.printf("Teor de Álcool : %d ", teorDeAlcool);
    }

    public int getTeorDeAlcool() {
        return teorDeAlcool;
    }

    public void setTeorDeAlcool(int teorDeAlcool) {
        this.teorDeAlcool = teorDeAlcool;
    }
}
