
public class Bispo extends Piece {	
	public static final String nome = "Bispo";
	public static final double imagemLargura = 1.0;
	public static final double imagemAltura = 1.0;
	public static final double imagemX = 1.0;
	public static final double imagemY = 1.0;
	
	Bispo(Cores cor){
		super.setNome(nome);
		super.setCor(cor);
		super.setImagemAltura(imagemAltura);
		super.setImagemAltura(imagemAltura);
		super.setImagemX(imagemX);
		super.setImagemY(imagemY);
	}
	
	public boolean range(int alvoY, int alvoX, Tabuleiro tabuleiro) {
		// o movimento do bispo � ilimitado desde que seja em diagonais
		int posicaoAtualY = super.getPosicaoY();
		int posicaoAtualX = super.getPosicaoX();
		
		// verificar se o movimento � crescente
		// se o moviment for � esquerda por exemplo, o movimento em X n�o ser� crescente
		// portanto, assumir� o valor falso
		boolean crescenteY = posicaoAtualY > alvoY ? false : true;
		boolean crescenteX = posicaoAtualX > alvoX ? false : true;
		
		// uma medida pra evitar bug
		// na primeira itera��o a pe�a colidiria com a pr�pria pe�a
		posicaoAtualX = crescenteX ? ++posicaoAtualX : --posicaoAtualX;
		posicaoAtualY = crescenteY ? ++posicaoAtualY : --posicaoAtualY;
		
		return range(posicaoAtualY, posicaoAtualX, alvoY, alvoX, crescenteY, crescenteX, tabuleiro);
	}
	
	public boolean range(int y, int x, int alvoY, int alvoX, boolean crescenteY, boolean crescenteX, Tabuleiro tabuleiro) {
		// x e y assume o valor relativo da pr�xima casa em cada recursividade
		int distancia = crescenteX ? alvoX - x : x - alvoX;				
		
		// em cada intera��o, checa se houve uma colis�o entre o bispo e seu alvo,
		// pois o bispo n�o pode pular pe�as
		if(tabuleiro.colisao(y, x)) {
			return false;
		}
		
		if(distancia>0) {
			y = crescenteY ? ++y : --y;
			x = crescenteX ? ++x : --x;
			range(y, x, alvoY, alvoX, crescenteY, crescenteX, tabuleiro);
		}
		
		return true;
	}

	public boolean mover(int y, int x, Tabuleiro tabuleiro) {	
		// checa se realmente houve deslocamento e se est� dentro do range
		if(super.deslocamento(y, x) && range(x, y, tabuleiro))
			return true;
		
		return false;
	}
	
	public boolean comer(int y, int x, Tabuleiro tabuleiro) {
		return (range(y, x, tabuleiro) && ((Piece)tabuleiro.getPeca(y, x)).getCor() != super.getCor());
	}
}
