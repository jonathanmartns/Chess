
public interface Acoes {
	public boolean mover(int y, int x, Tabuleiro tabuleiro);
	public boolean comer(int y, int x, Tabuleiro tabuleiro);
    public boolean range(int y, int x, Tabuleiro tabuleiro);
    public String getNome();
    public double getImagemLargura();
    public double getImagemAltura();
    public double getImagemX();
    public double getImagemY();
}
