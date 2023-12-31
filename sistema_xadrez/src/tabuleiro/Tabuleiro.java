package tabuleiro;

public class Tabuleiro {
	private int linhas, colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("ERRO: Deve ter ao menos uma linha e uma coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Peca peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new TabuleiroException("Posição inexistente!");
		}

		return pecas[linha][coluna];
	}

	public Peca peca(Posicao posicao) {

		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posição inexistente!");
		}

		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void colocarPeca(Peca peca, Posicao posicao) {
		if (temUmaPeca(posicao)) {
			throw new TabuleiroException("Já tem uma peça nessa posição");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}

	public boolean posicaoExiste(int linha, int coluna) {
		return (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas);

	}

	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());

	}

	public boolean temUmaPeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posição inexistente!");
		}
		return peca(posicao) != null;
	}

}
