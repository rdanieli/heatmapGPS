package com.eng.univates.setup;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.eng.univates.pojo.Usuario;

@Stateless
public class UsuarioSetup implements Setup<Usuario>{

	@Override
	public void setup(CriteriaBuilder cb, Root from, Usuario entity, List<Predicate> p) {
		if(entity.getLogin() != null){
			 p.add(cb.equal(from.get("login"), entity.getLogin()));
		}
		
		if(entity.getSenha() != null) {
			p.add(cb.equal(from.get("senha"), entity.getSenha()));			
		}
	}
}
