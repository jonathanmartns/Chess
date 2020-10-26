
public class Torre extends Piece implements Acoes{
	private enum Movimentos {
		HORIZONTAL,
		VERTICAL
	}
	
	public static final String nome = "Torre";
	public static final double imagemLargura = 1.0;
	public static final double imagemAltura = 1.0;
	public static final double imagemX = 1.0;
	public static final double imagemY = 1.0;
	
	Torre(Cores cor){
		super.setNome(nome);
		super.setCor(cor);
		super.setImagemAltura(imagemAltura);
		super.setImagemAltura(imagemAltura);
		super.setImagemX(imagemX);
		super.setImagemY(imagemY);
	}
	
	@Override
	public boolean range(int y, int x, Tabuleiro tabuleiro) {
		int posicaoAtualX = super.getPosicaoX();
		int posicaoAtualY = super.getPosicaoY();
		
		int distanciaX = posicaoAtualX > x ? posicaoAtualX - x : x - posicaoAtualX;
		int distanciaY = posicaoAtualY > y ? posicaoAtualY - y : y - posicaoAtualY;
		
		// se a diferença entre a origem e o destino for positiva.
		// crescente é verdadeiro
		// caso contrário, negativo
		Boolean crescente = false;
		crescente = posicaoAtualY < y ? true : crescente;
		crescente = posicaoAtualX < x ? true : crescente;

		// a torre pode se movimentar somente em um sentido entre horizontal ou vertical
		// Portanto, mudanças nas duas ordenadas, X e Y, são erros
		if(distanciaX > 0 && distanciaY > 0) {
			return false;
		}
		
		Movimentos sentido;
		
		if(distanciaY > 0) {
			// assumindo que a condicional anterior,
			// se a distancia entre os 2 pontos y for maior que zero
			// indica que o movimento é vertical
			sentido = Movimentos.VERTICAL;
			
			// previne que haja colisão com a própria peça
			posicaoAtualY = crescente ? ++posicaoAtualY : --posicaoAtualY;
		}
		else {
			// distancia entre os 2 pontos x, movimento horizontal
			sentido = Movimentos.HORIZONTAL;
			
			// previne que haja colisão com a própria peça
			posicaoAtualX = crescente ? ++posicaoAtualX : --posicaoAtualX;
		}	
		
		return range(posicaoAtualY, posicaoAtualX, y, x, sentido, tabuleiro);
	}
	
	private boolean range(int y, int x, int alvoY, int alvoX, Movimentos sentido, Tabuleiro tabuleiro) {
		// checa se há colisão durante a trajetória até o destino
		if(y == alvoY && x == alvoX) {	
			// chegou ao destino
			return true;
		} 
		else if(tabuleiro.colisao(y, x)) {
			return false;
		}
			
		if(sentido == Movimentos.HORIZONTAL) {
			x = alvoX > x ? ++x : --x;
		}
		else {
			y = alvoY > y ? ++y : --y;
		}
		
		return range(y, x, alvoY, alvoX, sentido, tabuleiro);			
	}
	
	@Override
	public boolean mover(int y, int x, Tabuleiro tabuleiro) {
		// implementar: mover impossibilita o rock
		return (range(y, x, tabuleiro) && super.deslocamento(y, x));
	}

}
