package br.com.oobj.integrador.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.oobj.integrador.dao.NotaFiscalDAO;
import br.com.oobj.integrador.model.NotaFiscal;

public class NotaFiscalSpringJDBCDAO implements NotaFiscalDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public NotaFiscalSpringJDBCDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void inserirNotaFiscal(NotaFiscal nota) {
		String sqlInsert = "insert into nfe (nome, conteudo, data_hora_emissao) values (?, ?, ?)";
		
		//nome, conteudo, data_hora_emissao
		int linhasAfetadas = jdbcTemplate.update(sqlInsert, 
				nota.getNomeArquivo(), 
				nota.getConteudoArquivo(), 
				nota.getDataHoraEmissao());
		
		System.out.println("Linhas afetadas : " + linhasAfetadas);

	}

	@Override
	public int contar() {
		return jdbcTemplate.queryForObject("select count(*) from nfe", Integer.class);
	}

	@Override
	public List<NotaFiscal> listarTodas() {
		return null;
	}

	@Override
	public int removerNota(Long id) {
		return 0;
	}

	@Override
	public NotaFiscal atualizar(NotaFiscal notaFiscal) {
		return null;
	}

	@Override
	public NotaFiscal buscarPeloId(Long id) {
		return null;
	}

}
