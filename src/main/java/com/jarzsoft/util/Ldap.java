package com.jarzsoft.util;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.entities.Parametro;
import com.jarzsoft.repository.ParametroRepository;

@Service
public class Ldap {

	private final ParametroRepository parametroRepository;

	@Autowired
	public Ldap(ParametroRepository parametroRepository) {
		super();
		this.parametroRepository = parametroRepository;
	}

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public String validateLdap(String user, String pass) {

		String numId = "";
		try {

			List<Parametro> parametroList = parametroRepository.findByParamId("LDAP");
			String url = "";
			String tree = "";
			String identificacion = "";

			for (Parametro parametro : parametroList) {
				String value = parametro.getParametroKey().getParam_text();
				if ("URL".equals(value)) {
					url = parametro.getValue();
				} else if ("TREE".equals(value)) {
					tree = parametro.getValue();
				} else if ("GETVALUE".equals(value)) {
					identificacion = parametro.getValue();
				}
			}

			String dn = user + identificacion;

			Hashtable<String, String> env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, url);
			env.put(Context.SECURITY_AUTHENTICATION, "simple");
			env.put(Context.SECURITY_PRINCIPAL, dn);
			env.put(Context.SECURITY_CREDENTIALS, pass);

			DirContext dc = new InitialDirContext(env);
			BasicAttributes searchAttrs = new BasicAttributes();
			searchAttrs.put("sAMAccountName", user);

			SearchControls searchControls = new SearchControls();
			searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration<SearchResult> objs = dc.search("DC=" + identificacion + ", DC=net",
					"(&(objectClass=user)(sAMAccountName=" + user + "))", searchControls);

			while (objs.hasMoreElements()) {

				SearchResult match = (SearchResult) objs.nextElement();
				Attributes attrs = match.getAttributes();

				NamingEnumeration e = attrs.getAll();

				while (e.hasMoreElements()) {
					Attribute attr = (Attribute) e.nextElement();

					if (attr.getID().equals("Identificacion")) {

						for (int i = 0; i < attr.size(); i++) {
							numId = attr.get(i).toString();
							System.out.println("IDENTIFICACION DEL USUARIO ENCONTRADA:" + numId);
						}
					}
				}
			}

		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
		return numId;
	}
}