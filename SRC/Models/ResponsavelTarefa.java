package Models;

public enum ResponsavelTarefa {
	
	Yami("Yami Sukehiro"),
	Charlotte("Charlotte Roselei"),
	Nozel("Nozel Silva"),
	Dorathy("Dorathy Unsworth"),
	William("William Vangeance"),
	Fuegoleon("Fuegoleon Vemillion"),
	Rill("Rill Boismortier");
	
	
	private String responsavel;
	
	
	ResponsavelTarefa(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public String getResponsavel() {
		return responsavel;
	}
}

