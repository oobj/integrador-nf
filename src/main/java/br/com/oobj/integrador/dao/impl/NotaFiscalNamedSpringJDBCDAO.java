package br.com.oobj.integrador.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.oobj.integrador.dao.NotaFiscalDAO;
import br.com.oobj.integrador.dao.impl.NotaFiscalSpringJDBCDAO.NotaFiscalRowMapper;
import br.com.oobj.integrador.model.NotaFiscal;

@Repository
public class NotaFiscalNamedSpringJDBCDAO implements NotaFiscalDAO {

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	public NotaFiscalNamedSpringJDBCDAO(DataSource dataSource) {
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
		return 0;
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
	public int atualizar(NotaFiscal notaFiscal) {
		String sqlUpdate = "update nfe set nome = :nome, conteudo = :conteudo, data_hora_emissao = :data_hora where id = :id";

		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("nome", notaFiscal.getNomeArquivo());
		namedParameters.put("conteudo", notaFiscal.getConteudoArquivo());
		namedParameters.put("data_hora", notaFiscal.getDataHoraEmissao());
		namedParameters.put("id", notaFiscal.getId());
		
//		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(notaFiscal);

		return this.namedJdbcTemplate.update(sqlUpdate, namedParameters);
	}

	@Override
	public NotaFiscal buscarPeloId(Long id) {
		String sql = "select * from nfe where id = :id";

		SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);

		return namedJdbcTemplate.queryForObject(sql, namedParameters, 
				new NotaFiscalRowMapper());
	}

}
