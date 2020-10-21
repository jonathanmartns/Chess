public class Principal{
	Principal(){
		Tabuleiro<Piece> tabuleiro = new Tabuleiro<Piece>();
		Bispo b1 = new Bispo(Cores.BRANCA);
		Peao p1 = new Peao(Cores.BRANCA);
		
		b1.setPosicaoX(0);
		b1.setPosicaoY(0);
		tabuleiro.alocar(b1, b1.getPosicaoY(), b1.getPosicaoX());
		
		p1.setPosicaoX(1);
		p1.setPosicaoY(1);
		tabuleiro.alocar(p1, p1.getPosicaoY(), p1.getPosicaoX());
		
		int novaPosicaoY = 2;
		int novaPosicaoX = 2;
		
		tabuleiro.imprimirTabuleiro();
		
		if(tabuleiro.mover(b1, novaPosicaoY, novaPosicaoX)) {
			System.out.printf("%s movendo...\n", b1.getNome());
		}
		else {
			System.out.println("Movimento impossibilitado...");
		}
		
		// novaPosicaoY = 4;
		// novaPosicaoX = 1;
		
		if(tabuleiro.mover(b1, novaPosicaoY, novaPosicaoX)) {
			System.out.printf("%s movendo...\n", b1.getNome());
		}
		else {
			System.out.println("Movimento impossibilitado...");
		}
		
		tabuleiro.imprimirTabuleiro();
	}
	
	public static void main(String[] args) {
		new Principal();
	}
}
