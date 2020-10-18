
public class Bispo extends Piece {	
	public static final String nome = "Bispo";
	public static final int imagemLargura = 1;
	public static final int imagemAltura = 1;
	public static final int imagemX = 1;
	public static final int imagemY = 1;
	
	Bispo(Cores cor){
		super.cor = cor;
		super.nome = nome;
		super.setImagemLargura(imagemLargura);
		super.setImagemAltura(imagemAltura);
		super.setImagemX(imagemX);
		super.setImagemY(imagemY);
	}
	
	public boolean range(int alvoY, int alvoX) {
		// o movimento do bispo � ilimitado desde que seja em diagonais
		return false;
	}
	
	public boolean range(int y, int x, int alvoY, int alvoX, boolean Ycrescente, boolean Xcrescente, Tabuleiro tabuleiro) {
		// x e y assume o valor relativo da pr�xima casa em cada recursividade
		int distanciaY = Ycrescente ? alvoY - y : y - alvoY;
		int distanciaX = Xcrescente ? alvoX - x : x - alvoX;
		
		if(distanciaY>0 && distanciaX>0) {
			if(!tabuleiro.colisao(y, x)) {
				y = Ycrescente ? alvoY + 1 : alvoY - 1;
				x = Xcrescente ? alvoX + 1 : alvoX - 1;
				range(y, x, alvoY, alvoX, Ycrescente, Xcrescente, tabuleiro);
			}
			else {
				return false;
			}
		}
		return true;
	}

	public boolean mover(int y, int x, Tabuleiro tabuleiro) {
		// verificar se h� colis�es entre o caminho,
		// pois o bispo n�o pode pular pe�as
		int posicaoAtualY = super.getPosicaoY();
		int posicaoAtualX = super.getPosicaoX();
		boolean Ycrescente = posicaoAtualY > y ? false : true;
		boolean Xcrescente = posicaoAtualX > x ? false : true;
		
		// sempre x ser� igual a y se a trajet�ria for diagonal
		if(y != x)
			return false;
		
		// checar se realmente houve movimenta��o e se est� dentro do range
		if(posicaoAtualX - x != 0 && posicaoAtualY - y != 0)
			if(range(posicaoAtualY, posicaoAtualX, x, y, Ycrescente, Xcrescente, tabuleiro))
				return true;
		
		return false;
	}
	
	public boolean comer(int y, int x, Tabuleiro tabuleiro) {
		return true;
	}
}
