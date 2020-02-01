package edu.infnet.comercio.negocio.modelo;

public class Produto {

	private Integer id;

	private String nome;

	private String descricao;

	private Double preco;

	private String foto;

	//ctrl space enter -- construtor vazio
	

	public Produto() {
		// TODO Auto-generated constructor stub
	}
	//ctrl 3 gcuf(construtor com fields) com id
	public Produto(Integer id, String nome, String descricao, Double preco, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.foto = foto;
	}
	//ctrl 3 gcuf(construtor com fields) sem id
	public Produto(String nome, String descricao, Double preco, String foto) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.foto = foto;
	}
	//ctrl 3 gts (transforma em string)
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", foto="
				+ foto + "]";
	}
	//ctrl 3 ggas(getters and setters)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
