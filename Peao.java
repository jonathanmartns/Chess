
public class Peao extends Piece{
	// movimento especial do piao
	private Boolean enPassant = true; 
	
	public static final String nome = "Peão";
	public static final double imagemLargura = 1.0;
	public static final double imagemAltura = 1.0;
	public static final double imagemX = 1.0;
	public static final double imagemY = 1.0;
	
	Peao(Cores cor){
		super.setNome(nome);
		super.setCor(cor);
		super.setImagemAltura(imagemAltura);
		super.setImagemAltura(imagemAltura);
		super.setImagemX(imagemX);
		super.setImagemY(imagemY);
	}
	
	public boolean comer(int y, int x, Tabuleiro tabuleiro) {
		// o peao come em diagonal
		// portanto x será incrementado 
		return (
			super.getPosicaoX() != x &&
			tabuleiro.colisao(y, x) && 
			((Piece)tabuleiro.getPeca(y, x)).getCor() != super.getCor());
	}
	
	public boolean range(int alvoY, int alvoX, Tabuleiro tabuleiro) {
		return range(alvoY, alvoX, comer(alvoY, alvoX, tabuleiro), tabuleiro);
	}
	
	public boolean range(int alvoY, int alvoX, boolean movimentoDeCaptura, Tabuleiro tabuleiro) {
		// Este metodo verifica se a peça alvo está sob alcance do peao
		int posicaoAtualX = super.getPosicaoX();
		int posicaoAtualY = super.getPosicaoY();
		
		// impedir o recuo dos peões
		if(super.getCor() == Cores.BRANCA) {
			if(alvoY < posicaoAtualY)
				return false;
		}
		else {
			// cor preta
			if(alvoY > posicaoAtualY && super.getCor() == Cores.PRETA)
				return false;
		}
		
		// não há a possibilidade de realizar o enpassant capturando alguma peça
		if(enPassant && movimentoDeCaptura)
			return false;
			
		int distanciaY = (posicaoAtualY>alvoY)?(posicaoAtualY-alvoY):(alvoY-posicaoAtualY);
		int distanciaX = (posicaoAtualX>alvoX)?(posicaoAtualX-alvoX):(alvoX-posicaoAtualX);
		int distanciaYLimite = enPassant ? 2 : 1;
		int distanciaXLimite = movimentoDeCaptura ? 1 : 0;
		
		if(distanciaY <= distanciaYLimite && distanciaX <= distanciaXLimite)
			return true;
		else
			return false;
	}
	
	public boolean mover(int y, int x, Tabuleiro tabuleiro) {
		if(range(y, x, tabuleiro) && !tabuleiro.colisao(y, x)) {
			// após realizar a primeira jogada da peça
			this.enPassant = false;
			return true;
		}
		else
			return false;
	}
}
