package com.pessoas.api.utils.mapper;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;


import javax.persistence.Tuple;

import org.apache.commons.lang3.math.NumberUtils;

import com.pessoas.api.model.dao.PessoaDAO;

public class PessoaMapper {
	 public static List<PessoaDAO> toPessoa(List<Tuple> tuples) {
	        List<PessoaDAO> result = new ArrayList<>();
	        for (Tuple tuple : tuples) {
	            PessoaDAO pessoaDAO = new PessoaDAO();
	            pessoaDAO.setId(toLong(tuple.get("ID"), null));
	            pessoaDAO.setIdade(toInteger(tuple.get("IDADE"), null));
	            pessoaDAO.setNome(toString(tuple.get("NOME"), null));
	            result.add(pessoaDAO);
	        }
	        return result;
	    }


	    public static String toString(Object object, String defaultValue) {
	        if (defaultValue == null) {
	            defaultValue = "";
	        }
	        return Objects.toString(object, defaultValue);
	    }

	    public static Long toLong(Object object, Long defaultValue) {
	        if (object instanceof Boolean) {
	            defaultValue =
	                    ((Boolean) object).booleanValue() ? NumberUtils.LONG_ONE : NumberUtils.LONG_ZERO;
	        } else if (defaultValue == null) {
	            defaultValue = NumberUtils.LONG_ZERO;
	        }


	        return NumberUtils.toLong(Objects.toString(object, ""), defaultValue);
	    }

	    public static Integer toInteger(Object object, Integer defaultValue) {
	        if (object instanceof Boolean) {
	            defaultValue =
	                    ((Boolean) object).booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
	        } else if (defaultValue == null) {
	            defaultValue = NumberUtils.INTEGER_ZERO;
	        }


	        return NumberUtils.toInt(Objects.toString(object, ""), defaultValue);
	    }
}
