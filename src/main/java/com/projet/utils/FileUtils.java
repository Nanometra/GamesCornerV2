package com.projet.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatch;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;

public class FileUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
	private static byte[] fichier;

	private String destination = "C:\\Users\\EXT_NPH42\\Documents\\Documents_Telecharges";

	public static byte[] transformFileToByte(UploadedFile file) throws Exception {
		if (file != null) {
			fichier = IOUtils.toByteArray(file.getInputstream());
		}
		return fichier;
	}

	public void Download(String inputName, InputStream in) {
		try {
			// Ecrit l'inputStream dans un outputStream (file)
			OutputStream out = new FileOutputStream(new File(destination + inputName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			LOGGER.info("Fichier créée");
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	public static String getMimeType(final byte[] image)
			throws MagicParseException, MagicMatchNotFoundException, MagicException {
		MagicMatch mime = Magic.getMagicMatch(image, true);
		
		return mime.getMimeType();
	}
}
