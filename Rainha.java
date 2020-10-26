
public class Rainha extends Piece implements Acoes {
	
	// todas peças com movimentos que podem ser reaproveitado pela rainha
	private Piece[] movimentos;
	
	Rainha(){
		this.movimentos = new Piece[3];
		this.movimentos[0] = new Bispo(super.getCor());
		this.movimentos[1] = new Torre(super.getCor());
		this.movimentos[1] = new Rei(super.getCor());
	}
	
	@Override
	public boolean mover(int y, int x, Tabuleiro tabuleiro) {
		return range(y, x, tabuleiro);
	}

	@Override
	public boolean range(int y, int x, Tabuleiro tabuleiro) {
		for(int i=0; i<movimentos.length; i++) {
			if(this.movimentos[i].range(y, x, tabuleiro))
				return true;
		}
	
		return false;
	}
}
