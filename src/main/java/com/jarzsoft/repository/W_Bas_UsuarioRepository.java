package com.jarzsoft.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Bas_Usuario;

@Repository
public interface W_Bas_UsuarioRepository extends JpaRepository<W_Bas_Usuario, String> {

	@Query(value = "SELECT us.Nom_usuario,LTRIM(RTRIM(ter.mailter)) as mailter ,us.CodTer FROM W_Bas_Usuario us,terceros ter WHERE us.usuario = :usuario AND us.codter=ter.codter", nativeQuery = true)
	List<Object[]> findByUsuario(@Param("usuario") String usuario);

	@Query(value = "SELECT * FROM W_Bas_Usuario us,terceros ter WHERE us.usuario = :usuario AND us.codter=ter.codter", nativeQuery = true)
	W_Bas_Usuario loadUserByUsername(@Param("usuario") String usuario);

	@Query(value = "SELECT us.Nom_usuario,ter.mailter FROM W_Bas_Usuario us,terceros ter WHERE us.usuario = :usuario AND clave_global=:clave_global AND us.codter=ter.codter", nativeQuery = true)
	List<Object[]> findByUsuarioAndPassword(@Param("usuario") String usuario,
			@Param("clave_global") String clave_global);

	@Query(value = "SELECT ter.nitter ,t1.cod_ter,ter.nomter, ter.pri_apellido ,ter.seg_apellido FROM fodataso t1 inner join terceros ter on t1.cod_ter =ter.codter"
			+ " WHERE NOT EXISTS (SELECT NULL FROM w_bas_usuario t2 WHERE t2.CodTer = t1.cod_ter )", nativeQuery = true)
	List<Object[]> findUsersFodataso();

	@Query(value = "SELECT LTRIM(RTRIM(Usuario)) as Usuario FROM W_Bas_Usuario WHERE clave_link = :clave_link", nativeQuery = true)
	Object[] findByUsuarioAndClaveLink(@Param("clave_link") String clave_link);

	@Query(value = "SELECT * FROM W_Bas_Usuario us,terceros ter WHERE us.usuario = :usuario AND clave_global_his=:clave_his AND us.codter=ter.codter", nativeQuery = true)
	W_Bas_Usuario findByUsuarioAndClaveHis(@Param("usuario") String usuario, @Param("clave_his") String clave_his);

	@Query(value = " select wb.usuario, LTRIM(RTRIM(wb.nom_usuario)) as nom_usuario, wb.codter, wb.estado, wp.codperfil, LTRIM(RTRIM(wp.nomperfil)) as nomperfil from w_bas_usuario wb , w_bas_T_Perfil  wp where wb.codperfil = wp.codperfil and us.usuario = :usuario ", nativeQuery = true)
	List<Object[]> findByUser(@Param("usuario") String usuario);

	@Query(value = "SELECT * FROM W_Bas_Usuario WHERE usuario = :usuario", nativeQuery = true)
	Optional<W_Bas_Usuario> findByUserWeb(@Param("usuario") String usuario);

	@Query(value = "select wb.usuario, LTRIM(RTRIM(wb.nom_usuario)) as nom_usuario, wb.clave, wb.codter, wb.clave1, wb.estado, wp.codperfil, LTRIM(RTRIM(wp.nomperfil)) as nomperfil, wb.clave_link, wb.clave_global,wb.date_mod, wb.clave_umbral,wb.clave_global_his,wb.tipoAut, wp.usu_ult_mod, wp.fec_ult_mod, wp.fec_crea, wp.usu_crea from w_bas_usuario wb , w_bas_T_Perfil  wp where wb.codperfil = wp.codperfil order by wb.nom_usuario", nativeQuery = true)
	List<W_Bas_Usuario> findUserComplete();

	@Query(value = "select wb.usuario, LTRIM(RTRIM(wb.nom_usuario)) as nom_usuario, wb.clave, wb.codter, wb.clave1, wb.estado, wp.codperfil, LTRIM(RTRIM(wp.nomperfil)) as nomperfil, wb.clave_link, wb.clave_global,wb.date_mod, wb.clave_umbral,wb.clave_global_his,wb.tipoAut, wp.usu_ult_mod, wp.fec_ult_mod, wp.fec_crea, wp.usu_crea from w_bas_usuario wb , w_bas_T_Perfil  wp where wb.codperfil = wp.codperfil order by wb.nom_usuario", nativeQuery = true)
	List<Object[]> findUserCompleteObj();

	@Transactional
	@Modifying
	@Query(value = "UPDATE W_Bas_Usuario SET clave_link = :clave_link WHERE Usuario= :usuario ", nativeQuery = true)
	public void modificarClaveLink(@Param("usuario") String usuario, @Param("clave_link") String clave_link);

	@Transactional
	@Modifying
	@Query(value = "UPDATE W_Bas_Usuario SET codperfil = :codperfil,USU_ULT_MOD =:usuMod,FEC_ULT_MOD = GETDATE()  WHERE Usuario= :usuario ", nativeQuery = true)
	public void modificarCodperfil(@Param("usuario") String usuario, @Param("codperfil") String codperfil,
			@Param("usuMod") String usuMod);

	@Transactional
	@Modifying
	@Query(value = "UPDATE W_Bas_Usuario SET clave_umbral= :clave_umbral WHERE Usuario= :usuario", nativeQuery = true)
	public void modificarClaveumbral(@Param("clave_umbral") String clave_umbral, @Param("usuario") String usuario);

	@Transactional
	@Modifying
	@Query(value = "UPDATE W_Bas_Usuario SET clave_global = :clave_global,clave_global_his =:clave_global,clave_link='',clave_umbral='0' WHERE Usuario= :usuario ", nativeQuery = true)
	public void modificarClaveGlobal(@Param("usuario") String usuario, @Param("clave_global") String clave_global);

	@Transactional
	@Modifying
	@Query(value = "UPDATE W_Bas_Usuario SET estado = :estado, codperfil =:codperfil WHERE Usuario= :usuario ", nativeQuery = true)
	public void modifyUserCreate(@Param("usuario") String usuario, @Param("codperfil") String codperfil,
			@Param("estado") String estado);

}
