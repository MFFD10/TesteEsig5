package Models;

public enum PrioridadeTarefa {
	
	BAIXA("prioridade alta"),
	MEDIA("prioridade média"),
	ALTA("prioridade alta");
	
	private String prioridade;
	
	PrioridadeTarefa(String prioridade) {
		this.prioridade = prioridade;
	}
	
	public String getPrioridade() {
		return prioridade;
	}
	
}
	
	

