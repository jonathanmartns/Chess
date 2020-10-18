
public class Peao extends Piece{
	// movimento especial do piao
	private Boolean enPassant = true; 
	
	public static final String nome = "Peão";
	public static final int imagemLargura = 1;
	public static final int imagemAltura = 1;
	public static final int imagemX = 1;
	public static final int imagemY = 1;
	
	Peao(Cores cor){
		super.nome = nome;
		super.cor = cor;
		super.setImagemLargura(imagemLargura);
		super.setImagemAltura(imagemAltura);
		super.setImagemX(imagemX);
		super.setImagemY(imagemY);
	}
	
	public boolean comer(int y, int x, Tabuleiro tabuleiro) {
		// o peao come em diagonal
		if(range(y, x, true))
			if(super.getPosicaoX() != x && tabuleiro.colisao(y, x))
				return true;
		
		return false;
	}
	
	public boolean range(int alvoY, int alvoX) {
		return range(alvoY, alvoX, false);
	}
	
	public boolean range(int alvoY, int alvoX, boolean movimentoDeCaptura) {
		// Este metodo verifica se a peça alvo está sob alcance do peao
		int posicaoAtualX = super.getPosicaoX();
		int posicaoAtualY = super.getPosicaoY();
		
		// impedir o recuo dos peões
		if((alvoY < posicaoAtualY && super.cor == Cores.BRANCA) || (alvoY > posicaoAtualY && super.cor == Cores.PRETA))
			return false;
		
		int distanciaY = (posicaoAtualY>alvoY)?(posicaoAtualY-alvoY):(alvoY-posicaoAtualY);
		int distanciaX = (posicaoAtualX>alvoX)?(posicaoAtualX-alvoX):(alvoX-posicaoAtualX);
		int distanciaYLimite;
		int distanciaXLimite = 1;
		
		if(!movimentoDeCaptura) {
			distanciaYLimite = (!enPassant)?(1):(2);
		}
		else 
			distanciaYLimite = 1;
		
		// checar se realmente houve movimentação e se está dentro do range
		if(distanciaY > 0)
			if(distanciaY <= distanciaYLimite && distanciaX <= distanciaXLimite)
				return true;
		
		return false;
	}
	
	public boolean mover(int y, int x, Tabuleiro tabuleiro) {
		if(range(y, x)) {
			if(!tabuleiro.colisao(y, x) || comer(y, x, tabuleiro)) {
				// após realizar a primeira jogada da peça
				this.enPassant = false;
				return true;
			}
		}
	
		return false;
	}
}
