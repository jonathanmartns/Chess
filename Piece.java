
public abstract class Piece implements Acoes {
	protected String nome; 
	protected Cores cor;
	private int posicaoX;
	private int posicaoY;
	private String diretorioAtual;
	public static final String diretorioImagemBranca = "/sprites/branca.png";
	public static final String diretorioImagemPreta = "/sprites/preta.png";
	private int imagemLargura;
	private int imagemAltura;
	private int imagemX;
	private int imagemY;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

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
	
	public String getDiretorioAtual() {
		return diretorioAtual;
	}

	public void setDiretorioAtual(String diretorioAtual) {
		this.diretorioAtual = diretorioAtual;
	}

	public int getImagemLargura() {
		return imagemLargura;
	}
	
	public void setImagemLargura(int imagemLargura) {
		this.imagemLargura = imagemLargura;
	}
	
	public int getImagemAltura() {
		return imagemAltura;
	}
	
	public void setImagemAltura(int imagemAltura) {
		this.imagemAltura = imagemAltura;
	}
	
	public int getImagemX() {
		return imagemX;
	}
	
	public void setImagemX(int imagemX) {
		this.imagemX = imagemX;
	}
	
	public int getImagemY() {
		return imagemY;
	}
	
	public void setImagemY(int imagemY) {
		this.imagemY = imagemY;
	}
}
