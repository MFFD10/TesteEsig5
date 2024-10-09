package Models;

public enum SituacaoTarefa {
	
		
		ATIVIDADE_EM_ANDAMENTO ("Em andamento"),
		ATIVIDADE_CONCLUIDA ("Concluída");
		
		private String situacao;
		
		SituacaoTarefa(String situacao) {
			this.situacao = situacao;
		}
		
		public String getSituacao() {
			return situacao;
		}
}
