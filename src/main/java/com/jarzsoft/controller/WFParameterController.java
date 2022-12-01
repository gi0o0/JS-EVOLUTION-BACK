package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOWFParameter;
import com.jarzsoft.dto.DTOWFParameterEst;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWFParameterStepAut;
import com.jarzsoft.dto.DTOWFParameterStepDoc;
import com.jarzsoft.service.IWFParameterService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_WFPARAMETER)
public class WFParameterController {

	private final IWFParameterService service;

	@Autowired
	public WFParameterController(IWFParameterService service) {
		super();
		this.service = service;
	}

	@GetMapping(produces = "application/json")
	public List<DTOWFParameter> listarAll() {
		return service.listAll();
	}

	@GetMapping(value = "/{id}/steps", produces = "application/json")
	public List<DTOWFParameterStep> listWK(@PathVariable("id") String id) {
		return service.listSteps(id);
	}

	@GetMapping(value = "/{id}/ests", produces = "application/json")
	public List<DTOWFParameterEst> listWKEst(@PathVariable("id") String id) {
		return service.listEsts(id);
	}

	@PostMapping(value = "/{id}/ests", produces = "application/json", consumes = "application/json")
	public DTOWFParameterEst createEst(@RequestBody DTOWFParameterEst o, @RequestAttribute(name = "user") String user,
			@PathVariable("id") Integer id) {
		o.setUsuCrea(user);
		o.setIdWf(new Long(id));
		return service.createEst(o);
	}

	@PostMapping(value = "/{id}/steps", produces = "application/json", consumes = "application/json")
	public DTOWFParameterStep createStep(@RequestBody DTOWFParameterStep o,
			@RequestAttribute(name = "user") String user, @PathVariable("id") Integer id) {
		o.setUsuCrea(user);
		o.setIdWf(new Long(id));
		return service.create(o);
	}

	@DeleteMapping(value = "/{id}/steps", produces = "application/json", consumes = "application/json")
	public DTOWFParameterStep delete(@RequestBody DTOWFParameterStep o) {
		return service.delete(o);
	}

	@DeleteMapping(value = "/{id}/ests/{idest}", produces = "application/json")
	public DTOWFParameterEst deleteEsts(@PathVariable("id") String id, @PathVariable("idest") String idest) {
		return service.deleteEst(id, idest);
	}

	@PutMapping(value = "/{id}/steps", produces = "application/json", consumes = "application/json")
	public DTOWFParameterStep updateStep(@RequestBody DTOWFParameterStep o,
			@RequestAttribute(name = "user") String user, @PathVariable("id") Integer id) {
		o.setUsuUltMod(user);
		o.setIdWf(new Long(id));
		return service.update(o);
	}

	@PutMapping(value = "/{id}/ests", produces = "application/json", consumes = "application/json")
	public DTOWFParameterEst updateEst(@RequestBody DTOWFParameterEst o, @RequestAttribute(name = "user") String user,
			@PathVariable("id") Integer id) {
		o.setUsuUltMod(user);
		o.setIdWf(new Long(id));
		return service.updateEst(o);
	}

	@GetMapping(value = "/{id}/steps/{idpaso}/docs", produces = "application/json")
	public List<DTOWFParameterStepDoc> listDocs(@PathVariable("id") String id, @PathVariable("idpaso") String idpaso) {
		return service.listStepsDoc(id, idpaso);
	}

	@GetMapping(value = "/{id}/steps/{idpaso}/auts", produces = "application/json")
	public List<DTOWFParameterStepAut> lissAuts(@PathVariable("id") String id, @PathVariable("idpaso") String idpaso) {
		return service.listStepsAut(id, idpaso);
	}

	@DeleteMapping(value = "/{id}/steps/{idpaso}/docs/{iddoc}", produces = "application/json")
	public DTOWFParameterStepDoc deleteDoc(@PathVariable("id") String id, @PathVariable("idpaso") String idpaso,
			@PathVariable("iddoc") String iddoc) {
		return service.deleteDoc(id, idpaso, iddoc);
	}

	@DeleteMapping(value = "/{id}/steps/{idpaso}/auts/{idaut}", produces = "application/json")
	public DTOWFParameterStepAut deleteAut(@PathVariable("id") String id, @PathVariable("idpaso") String idpaso,
			@PathVariable("idaut") String idaut) {
		return service.deleteAut(id, idpaso, idaut);
	}

	@PostMapping(value = "/{id}/steps/{idpaso}/auts", produces = "application/json", consumes = "application/json")
	public DTOWFParameterStepAut createStepAut(@RequestBody DTOWFParameterStepAut o,
			@RequestAttribute(name = "user") String user, @PathVariable("id") Integer id,
			@PathVariable("idpaso") String idpaso) {
		o.setUsuCrea(user);
		o.setIdWf(new Long(id));
		o.setIdPaso(new Long(idpaso));
		return service.createAut(o);
	}
	
	@GetMapping(value = "/wf/{id_wf}/step/{id_step}/security", produces = "application/json")
	public DTOWFParameterStepAut validStepByUser( @PathVariable("id_wf") String wf, @PathVariable("id_step") String step,@RequestAttribute(name = "user") String user) {
		return service.validStepByUser(wf,step,user);
	}

}
