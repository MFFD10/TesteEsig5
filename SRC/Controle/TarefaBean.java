package Controle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import CRUD.TarefaCreator;


import Models.PrioridadeTarefa;
import Models.ResponsavelTarefa;
import Models.SituacaoTarefa;
import Models.Tarefa;




@Named
@ViewScoped
public class TarefaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String titulo;
	private String descricao;
	private ResponsavelTarefa responsavel;
	private PrioridadeTarefa prioridade;
	private SituacaoTarefa situacao;
	private Date limiteData;
	
	@Inject
	private TarefaCreator tarefaCreator;
	
	private Tarefa tarefa;
	
	private List<Tarefa> tarefas;
	
	public TarefaBean() {
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public ResponsavelTarefa[] getResponsaveis() {
		return ResponsavelTarefa.values();
	}
	
	public ResponsavelTarefa getResponsavel() {
		return responsavel;
	
	}
	
	public void setResponsavel(ResponsavelTarefa responsavel) {
		this.responsavel = responsavel;
	}
	
	public PrioridadeTarefa[] getPrioridades() {
		return PrioridadeTarefa.values();
	}
	
	public PrioridadeTarefa getPrioridade() {
		return prioridade;
	}
	
	public void SetPrioridade(PrioridadeTarefa prioridade) {
		this.prioridade = prioridade;
	}
	
	public SituacaoTarefa getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoTarefa situacao) {
		this.situacao = situacao;
	}

	public Date getLimiteData() {
		return limiteData;
	}

	public void setLimiteData(Date limiteData) {
		this.limiteData = limiteData;
	}
	
	
	public void criarTarefa() throws Exception {
		setSituacao(SituacaoTarefa.ATIVIDADE_EM_ANDAMENTO);
		Tarefa tarefa = new Tarefa(titulo, descricao, responsavel, situacao, prioridade, limiteData );
		tarefaCreator.criarTarefa(tarefa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESS", "A sua tarefa foi cadastrada com Sucesso"));
		limparCampos();
	}
	
	public void listTarefas() {
		try {
			tarefas = tarefaCreator.listarTarefas(titulo, id, descricao, responsavel, situacao, prioridade, limiteData);
		}
		catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "UNSUCESS", "Não foi possível listar as tarefas"));
		}
	}
	
	public void DialogoEditar(Tarefa tarefa) {
		this.tarefa.setId(tarefa.getId());
		this.tarefa.setTitulo(tarefa.getTitulo());
		this.tarefa.setDescricao(tarefa.getDescricao());
		this.tarefa.setResponsavel(tarefa.getResponsavel());
		this.tarefa.setPrioridade(tarefa.getPrioridade());
		this.tarefa.setSituacao(tarefa.getSituacao());
		this.tarefa.setLimiteData(tarefa.getLimiteData());
		
	}
	
	public void salvarEditTarefas() throws Exception {
		tarefaCreator.atualizarTarefa(tarefa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESS", "A edição na tarefa foi um sucesso"));
	listTarefas();
	}
	
	public void excluirTarefa(Tarefa tarefa) throws Exception {
		tarefaCreator.excluirTarefa(tarefa);
		listTarefas();
		limparCampos();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESS", "A exclusão da tarefa foi um sucesso"));
	}
	
	public void concluirTarefa(Tarefa tarefa) throws Exception {
		tarefa.setSituacao(SituacaoTarefa.ATIVIDADE_CONCLUIDA);
		tarefaCreator.atualizarTarefa(tarefa);
		listTarefas();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESS", " A tarefa foi concluída"));
	}
	


	public void limparCampos() {
		titulo = null;
		descricao = null;
		responsavel = null;
		prioridade = null;
		limiteData = null;
	}
}