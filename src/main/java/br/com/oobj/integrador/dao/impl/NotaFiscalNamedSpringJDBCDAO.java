package br.com.oobj.integrador.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import br.com.oobj.integrador.dao.NotaFiscalDAO;
import br.com.oobj.integrador.model.NotaFiscal;

public class NotaFiscalNamedSpringJDBCDAO implements NotaFiscalDAO {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public NotaFiscalNamedSpringJDBCDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public void inserirNotaFiscal(NotaFiscal nota) {
		String sqlInsert = 
				"insert into nfe (nome, conteudo, data_hora_emissao) "
				+ "values (:nomeArquivo, :conteudoArquivo, :dataHoraEmissao)";
		
		// Primeira abordagem: adicionando os valores na mão.
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("nomeArquivo", nota.getNomeArquivo());
		namedParameters.addValue("conteudoArquivo", nota.getConteudoArquivo());
		namedParameters.addValue("dataHoraEmissao", nota.getDataHoraEmissao());
		
		// Segunda abordagem: usando os atributos do bean (no caso, NotaFiscal)
		SqlParameterSource namedParameters2 = new BeanPropertySqlParameterSource(nota);
		
		int linhasAfetadas = namedJdbcTemplate.update(sqlInsert, namedParameters);
		
		System.out.println("Linhas afetadas : " + linhasAfetadas);

	}

	@Override
	public int contar() {
		// jdbcTemplate...?
		return 0;
	}

	@Override
	public List<NotaFiscal> listarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removerNota(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int atualizar(NotaFiscal notaFiscal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotaFiscal buscarPeloId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
