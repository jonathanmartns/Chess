public class Principal{
	Principal(){
		Tabuleiro tabuleiro = new Tabuleiro();
		Bispo b1 = new Bispo(Cores.BRANCA);
		b1.setPosicaoX(0);
		b1.setPosicaoY(0);
		
		int novaPosicaoX = 5;
		int novaPosicaoY = 7;
	
		if(b1.mover(novaPosicaoY, novaPosicaoX, tabuleiro)) {
			b1.setPosicaoY(novaPosicaoY);
			System.out.printf("%s movendo...\n", b1.getNome());
		}
		else {
			System.out.println("Movimento impossibilitado...");
		}
		
		novaPosicaoX = 2;
		novaPosicaoY = 2;
		
		if(b1.mover(novaPosicaoY, novaPosicaoX, tabuleiro)) {
			b1.setPosicaoY(novaPosicaoY);
			System.out.printf("%s movendo...\n", b1.getNome());
		}
		else {
			System.out.println("Movimento impossibilitado...");
		}
		
	}
	
	public static void main(String[] args) {
		new Principal();
	}
}
