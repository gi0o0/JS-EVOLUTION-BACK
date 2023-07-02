package com.jarzsoft.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFilesUser;
import com.jarzsoft.dto.DTOWfDocs;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.service.IFilesUserService;

@Service
public class FilesUserService implements IFilesUserService {

	private final ParametroRepository parametroRepository;

	@Autowired
	public FilesUserService(ParametroRepository parametroRepository) {
		super();
		this.parametroRepository = parametroRepository;
	}

	@Override
	public List<DTOFilesUser> listAll(String user, String solicitud, String id) {

		return getFiles(user, solicitud, id);
	}

	private List<DTOFilesUser> getFiles(String user, String solicitud, String id) {
		String path = parametroRepository.findByParamIdAndParamtext("PATH", "FILES_USERS").getValue();
		File folder = new File(path);
		List<DTOFilesUser> files = new ArrayList<>();
		for (File file : folder.listFiles()) {
			String name = file.getName();
			String nameIds[] = name.split("_");
			if (!file.isDirectory()) {

				if (nameIds[0].startsWith(user)) {
					if (!"0".equals(solicitud)) {
						if (nameIds[1].equals(solicitud)) {
							if (!"0".equals(id)) {
								if (nameIds[2].equals(id)) {
									byte[] fileContent = null;
									try {
										fileContent = FileUtils.readFileToByteArray(new File(file.getAbsolutePath()));
									} catch (IOException e) {
										e.printStackTrace();
									}
									String encodedString = Base64.getEncoder().encodeToString(fileContent);
									files.add(new DTOFilesUser(name, encodedString, nameIds[0], nameIds[1], nameIds[2],
											path + name));
								}
							} else {
								files.add(new DTOFilesUser(name, "", nameIds[0], nameIds[1], nameIds[2], path + name));
							}
						}
					} else {
						files.add(new DTOFilesUser(name, "", nameIds[0], nameIds[1], nameIds[2], path + name));
					}

				}
			}
		}
		return files;
	}

	@Override
	public Boolean create(String idSolicitud, String step, String cedula, DTOWfDocs doc) {
		Boolean out = false;

		try {

			String path = parametroRepository.findByParamIdAndParamtext("PATH", "FILES_USERS").getValue();
			byte[] decodedImg = Base64.getDecoder()
					.decode(doc.getValue().split(",")[1].getBytes(StandardCharsets.UTF_8));
			Path destinationFile = Paths.get(path, idSolicitud + "_" + step + "_" + cedula + "_" + doc.getIdDocumento()
					+ "_" + doc.getNomDocumento() + ".pdf");
			Files.write(destinationFile, decodedImg);
			out = true;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

		return out;
	}

	@Override
	public List<DTOFilesUser> listAllByIdRedAndStep(String solicitud, String step) {
		String path = parametroRepository.findByParamIdAndParamtext("PATH", "FILES_USERS").getValue();
		File folder = new File(path);
		List<DTOFilesUser> files = new ArrayList<>();
		for (File file : folder.listFiles()) {
			String name = file.getName();
			String nameIds[] = name.split("_");
			if (!file.isDirectory()) {
				if (nameIds[0].startsWith(solicitud)) {
					if (nameIds[1].equals(step)) {
						byte[] fileContent = null;
						try {
							fileContent = FileUtils.readFileToByteArray(new File(file.getAbsolutePath()));
						} catch (IOException e) {
							e.printStackTrace();
						}
						String encodedString = Base64.getEncoder().encodeToString(fileContent);
						files.add(
								new DTOFilesUser(name, encodedString, nameIds[0], nameIds[1], nameIds[2], path + name));
					}
				}
			}
		}
		return files;

	}

	@Override
	public List<DTOFilesUser> listAllById(String solicitud) {
		String path = parametroRepository.findByParamIdAndParamtext("PATH", "FILES_USERS").getValue();
		File folder = new File(path);
		List<DTOFilesUser> files = new ArrayList<>();
		for (File file : folder.listFiles()) {
			String name = file.getName();
			String nameIds[] = name.split("_");
			if (!file.isDirectory()) {
				if (nameIds[0].startsWith(solicitud)) {
					byte[] fileContent = null;
					try {
						fileContent = FileUtils.readFileToByteArray(new File(file.getAbsolutePath()));
					} catch (IOException e) {
						e.printStackTrace();
					}
					String encodedString = Base64.getEncoder().encodeToString(fileContent);
					files.add(new DTOFilesUser(name, encodedString, nameIds[0], nameIds[1], nameIds[2], path + name));

				}
			}
		}
		return files;
	}

}
