import java.util.ArrayList;

public class Historico<H>{
	private ArrayList <Acoes> acoes;
	
	private class Acoes<P>{
		private P pecaAtacante;
		private P pecaAlvo;
		private int yOrigemAtacante;
		private int xOrigemAtacante;

		Acoes(P pecaAtacante, P pecaAlvo){
			this.pecaAlvo = pecaAlvo;
			this.pecaAtacante = pecaAtacante;
			this.yOrigemAtacante = ((Piece)pecaAtacante).getPosicaoY();
			this.xOrigemAtacante = ((Piece)pecaAtacante).getPosicaoX();
		}

		public P getPecaAtacante() {
			return pecaAtacante;
		}

		public P getPecaAlvo() {
			return pecaAlvo;
		}

		public int getyAtacante() {
			return this.yOrigemAtacante;
		}

		public int getxAtacante() {
			return this.xOrigemAtacante;
		}	
	}
	
	Historico(){
		// falta limitar o histórico
		this.acoes = new ArrayList<Acoes>();
	}
	
	public void novaAcao(H peca) {
		acoes.add(new Acoes<H>(peca, null));
	}
	
	public void novaAcao(H peca1, H peca2) {
		acoes.add(new Acoes<H>(peca1, peca2));
	}
	
	public void voltarHistorico(int idJogada) {
		int tamanhoHistorico = this.acoes.size() - 1;
		
		for(int i=tamanhoHistorico; i>=idJogada; i--) {
			Object pecaAtacante = acoes.get(i).getPecaAlvo();
			Object pecaAlvo = acoes.get(i).getPecaAlvo();
			
			String nomeAtacante = "";
			String nomeAlvo = "";

			nomeAtacante = (pecaAtacante instanceof Peao)?(((Peao) pecaAtacante).getNome()):(nomeAtacante);
			nomeAtacante = (pecaAtacante instanceof Bispo)?(((Bispo) pecaAtacante).getNome()):(nomeAtacante);
			nomeAlvo = (pecaAlvo instanceof Peao)?(((Peao) pecaAlvo).getNome()):(nomeAlvo);
			nomeAlvo = (pecaAlvo instanceof Bispo)?(((Bispo) pecaAlvo).getNome()):(nomeAlvo);
			
			// apenas pra teste
			System.out.printf("Peça atacante: %s.\n", nomeAtacante);
			System.out.printf("Peça alvo: %s.\n\n", nomeAlvo);
		}
	}
}
