

public class Tabuleiro<P>{
	private P[][] slots;
	public static final int linhas = 8;
	public static final int colunas = 8;
	private final String diretorioAtual = "";
	
	Tabuleiro(){
		this.slots = (P[][]) new Object[linhas][colunas];
	}
	
	public Boolean colisao(int y, int x) {
		return (this.slots[y][x] != null ? true : false);
	}
	
	public void desocuparSlot(int y, int x) {
		this.slots[y][x] = null;
	}
	
	public void alocar(P peca, int y, int x) {
		// posicoes anteriores
		Piece pp = (Piece) peca;
		// int yAnterior = pp.getPosicaoY();
		// int xAnterior = pp.getPosicaoX();;
		// desocuparSlot(yAnterior, xAnterior);
		
		this.slots[y][x] = peca; 
		
		// atualiza a nova posição da peça
		pp.setPosicaoY(y);
		pp.setPosicaoX(x);
	}
	
	// apenas pra teste enquanto não há interface visual
	public void imprimirTabuleiro() {
		char[] coluna = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		
		for(int i=0; i<linhas; i++) { 
			for(int j=0; j<colunas; j++) {
				if(this.slots[i][j] instanceof Piece)
					System.out.printf("%d%c: %s ", i, coluna[j], ((Piece) this.slots[i][j]).getNome());
				else
					System.out.printf("%d%c: %s ", i, coluna[j], "vazio");
			}
			System.out.println();
		}
	}
	
	public boolean mover(P peca, int y, int x) {
		boolean movimentoValido = false;
		movimentoValido = peca instanceof Peao ? ((Peao) peca).mover(y, x, this) : movimentoValido;
		movimentoValido = peca instanceof Bispo ? ((Bispo) peca).mover(y, x, this) : movimentoValido;
		
		if(movimentoValido) {
			//Cuida da antiga posicao
			int yOrigem = ((Piece) peca).getPosicaoY();
			int xOrigem = ((Piece) peca).getPosicaoX();;
			desocuparSlot(yOrigem, xOrigem);
			
			//Atualiza a nova posicao
			alocar(peca, y, x);
			((Piece) peca).setPosicaoY(y);
			((Piece) peca).setPosicaoX(x);	
		}
		
		return movimentoValido;
	}
	
	public P getPeca(int y, int x) {
		return this.slots[y][x];
	}
	
	public void inicializarSlots() {
		
	}
	
	public void atualizar() {

	}
}
