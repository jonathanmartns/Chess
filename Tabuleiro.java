

public class Tabuleiro{
	private Piece[][] pecas; 
	public static final int linhas = 8;
	public static final int colunas = 8;

	Tabuleiro(){
		pecas = new Piece[linhas][colunas];
	}
	
	public Boolean colisao(int y, int x) {
		if(pecas[y][x] != null)
			return true;
		else
			return false;
	}
	
	public void atualizar() {
		
	}
}
