
public abstract class Piece implements Acoes {
	private String nome;
	private Cores cor;
	private int posicaoX;
	private int posicaoY;
	
	private double imagemLargura;
	private double imagemAltura;
	private double imagemX;
	private double imagemY;
	
	public int getPosicaoX() {
		return posicaoX;
	}
	
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	
	public int getPosicaoY() {
		return posicaoY;
	}
	
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
	
	public boolean deslocamento(int destinoY, int destinoX) {
		// verifica se realmente houve deslocamento
		int posicaoAtualY = getPosicaoY();
		int posicaoAtualX = getPosicaoX();
		
		if(posicaoAtualX - destinoX != 0 && posicaoAtualY - destinoY != 0)
			return true;
		else
			return false;
	}

	public Cores getCor() {
		return cor;
	}

	public void setCor(Cores cor) {
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getImagemLargura() {
		return imagemLargura;
	}

	public void setImagemLargura(double imagemLargura) {
		this.imagemLargura = imagemLargura;
	}

	public double getImagemAltura() {
		return imagemAltura;
	}

	public void setImagemAltura(double imagemAltura) {
		this.imagemAltura = imagemAltura;
	}

	public double getImagemX() {
		return imagemX;
	}

	public void setImagemX(double imagemX) {
		this.imagemX = imagemX;
	}

	public double getImagemY() {
		return imagemY;
	}

	public void setImagemY(double imagemY) {
		this.imagemY = imagemY;
	}
	
	

}
