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
	public Boolean create(String id, String step, String cedula, DTOWfDocs doc) {
		Boolean out = false;

		try {

			String path = parametroRepository.findByParamIdAndParamtext("PATH", "FILES_USERS").getValue().trim();
			byte[] decodedImg = Base64.getDecoder()
					.decode(doc.getValue().split(",")[1].getBytes(StandardCharsets.UTF_8));
			String nameFile = id + "_" + step + "_" + cedula + "_" + doc.getIdDocumento() + "_" + doc.getNomDocumento()
					+ ".pdf";
			Path destinationFile = Paths.get(path, nameFile);
			Files.write(destinationFile, decodedImg);
			out = true;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

		return out;
	}

	@Override
	public List<DTOFilesUser> listAll(String user, String solicitud, String id, String nameFile) {

		String path = parametroRepository.findByParamIdAndParamtext("PATH", "FILES_USERS").getValue().trim();
		File folder = new File(path);
		List<DTOFilesUser> files = new ArrayList<>();
		for (File file : folder.listFiles()) {

			String name = file.getName();
			String nameIds[] = name.split("_");

			if (file.isDirectory()) {
				break;
			}
			if (nameIds.length < 4) {
				break;
			}

			String numRad = nameIds[0].substring(1, nameIds[0].length());
			String userFile = nameIds[2];
			String idFile = nameIds[3];

			//if (!"0".equals(id) && idFile.equals(id) & numRad.equals(solicitud) && user.equals(userFile)) {
			if (!"0".equals(id) && idFile.equals(id) & numRad.equals(solicitud) && name.equals(nameFile)) {
				
			byte[] fileContent = null;
				try {
					fileContent = FileUtils.readFileToByteArray(new File(file.getAbsolutePath()));
				} catch (IOException e) {
					e.printStackTrace();
				}
				String encodedString = Base64.getEncoder().encodeToString(fileContent);
				files.add(new DTOFilesUser(name, encodedString, userFile, numRad, idFile, path + name));
				break;
			}

			if ((userFile.equals(user)) && "0".equals(id) && "0".equals(solicitud)) {
				files.add(new DTOFilesUser(name, "", userFile, numRad, idFile, path + name));
			}

			if (userFile.equals(user) && "0".equals(id) && numRad.equals(solicitud)) {
				files.add(new DTOFilesUser(name, "", userFile, numRad, idFile, path + name));
			}

		}

		return files;
	}

	@Override
	public List<DTOFilesUser> listAllByIdRedAndStep(String solicitud, String step) {
		String path = parametroRepository.findByParamIdAndParamtext("PATH", "FILES_USERS").getValue().trim();
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
		String path = parametroRepository.findByParamIdAndParamtext("PATH", "FILES_USERS").getValue().trim();
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
