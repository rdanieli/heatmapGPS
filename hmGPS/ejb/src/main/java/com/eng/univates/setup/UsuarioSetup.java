package com.eng.univates.setup;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.eng.univates.pojo.Usuario;

@Stateless
public class UsuarioSetup implements Setup<Usuario>{

	@Override
	public Predicate[] setup(CriteriaBuilder cb, Root from, Usuario entity) {
		Predicate pLogin = cb.equal(from.get("login"), entity.getLogin());
		Predicate pSenha = cb.equal(from.get("senha"), entity.getSenha());
		
		return new Predicate[] {
				pLogin,
				pSenha
		};
	}
}
