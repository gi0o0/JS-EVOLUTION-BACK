package com.jarzsoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Bas_Usuario;

@Repository
public interface W_Bas_UsuarioRepository extends JpaRepository<W_Bas_Usuario, Long> {

	@Query(value = "SELECT us.Nom_usuario,LTRIM(RTRIM(ter.mailter)) as mailter ,us.CodTer FROM W_Bas_Usuario us,terceros ter WHERE us.usuario = :usuario AND us.codter=ter.codter", nativeQuery = true)
	List<Object[]> findByUsuario(@Param("usuario") String usuario);

	@Query(value = "SELECT * FROM W_Bas_Usuario us,terceros ter WHERE us.usuario = :usuario AND us.codter=ter.codter", nativeQuery = true)
	W_Bas_Usuario loadUserByUsername(@Param("usuario") String usuario);

	@Query(value = "SELECT us.Nom_usuario,ter.mailter FROM W_Bas_Usuario us,terceros ter WHERE us.usuario = :usuario AND clave_global=:clave_global AND us.codter=ter.codter", nativeQuery = true)
	List<Object[]> findByUsuarioAndPassword(@Param("usuario") String usuario, @Param("clave_global") String clave_global);

	@Query(value = "SELECT LTRIM(RTRIM(Usuario)) as Usuario FROM W_Bas_Usuario WHERE clave_link = :clave_link", nativeQuery = true)
	Object[] findByUsuarioAndClaveLink(@Param("clave_link") String clave_link);

	@Query(value = "SELECT * FROM W_Bas_Usuario us,terceros ter WHERE us.usuario = :usuario AND clave_global_his=:clave_his AND us.codter=ter.codter", nativeQuery = true)
	W_Bas_Usuario findByUsuarioAndClaveHis(@Param("usuario") String usuario, @Param("clave_his") String clave_his);

	@Transactional
	@Modifying
	@Query(value = "UPDATE W_Bas_Usuario SET clave_link = :clave_link WHERE Usuario= :usuario ", nativeQuery = true)
	public void modificarClaveLink(@Param("usuario") String usuario, @Param("clave_link") String clave_link);

	@Transactional
	@Modifying
	@Query(value = "UPDATE W_Bas_Usuario SET clave_umbral= :clave_umbral WHERE Usuario= :usuario", nativeQuery = true)
	public void modificarClaveumbral(@Param("clave_umbral") String clave_umbral, @Param("usuario") String usuario);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE W_Bas_Usuario SET clave_global = :clave_global,clave_global_his =:clave_global,clave_link='' WHERE Usuario= :usuario ", nativeQuery = true)
	public void modificarClaveGlobal(@Param("usuario") String usuario, @Param("clave_global") String clave_global);

}
