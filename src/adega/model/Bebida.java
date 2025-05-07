package adega.model;

public abstract class Bebida {

    private int id ;
    private String nome;
    private String fabricante;
    private int volume;
    private float preco;

    public Bebida (int id, String fabricante, String nome, float preco, int volume) {
        this.id  = id;
        this.fabricante = fabricante;
        this.nome = nome;
        this.preco = preco;
        this.volume = volume;
    }

    public void mostrarInformacoes() {
        System.out.printf("""
                
                *********************************
                           --Bebida--
                *********************************
                Id : %d
                Nome : %s
                Fabricante : %s
                Volume : %d
                Preco : %.2f
                """,
                id, nome, fabricante, volume, preco);
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getId() {
        return id;
    }
}
