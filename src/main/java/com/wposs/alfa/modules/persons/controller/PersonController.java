package com.wposs.alfa.modules.persons.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.persons.model.Person;
import com.wposs.alfa.modules.persons.service.PersonServices;
import com.wposs.core.controller.BaseSpringController;
import com.wposs.core.controller.ProcessController;
import com.wposs.core.model.BaseArrayModel;
import com.wposs.core.model.BaseResponse;
import com.wposs.core.spring.Input;

@RestController
@RequestMapping(path = "/persons")
public class PersonController extends BaseSpringController<PersonServices>{

	@PostMapping("/getPersonByDocument")
	@Input(name="documentType",				required="true", 			type="String",				values="")
	@Input(name="document",					required="true", 			type="String",				values="")
	public ResponseEntity<BaseResponse<Person>> getPersonByDocument(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception  {
		return processController( new ProcessController<BaseResponse<Person>>( request, bindigResult ) {
			public ResponseEntity<BaseResponse<Person>> onProcess( BaseResponse<Person> response ) throws Exception {
				response.setModel( getService().getPersonByDocument(request) );
				return new ResponseEntity<>( response, HttpStatus.OK );
			}
		} ) ;
	}

	@PostMapping("/getAllPersons")
	public ResponseEntity<BaseResponse<BaseArrayModel<Person>>> getAllPersons(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception  {
		return processController( new ProcessController<BaseResponse<BaseArrayModel<Person>>>( request, bindigResult ) {
			public ResponseEntity<BaseResponse<BaseArrayModel<Person>>> onProcess( BaseResponse<BaseArrayModel<Person>> response ) throws Exception {
				response.setModel( getService().getAllPersons(request) );
				return new ResponseEntity<>( response, HttpStatus.OK );
			}
		} ) ;
	}

	public static void main(String[] args) throws Exception {
		String password = "123456";

		byte[] salt = new String("J0s3r4F@").getBytes();
		int iterationCount = 4000;
		int keyLength = 128;
		SecretKeySpec key = createSecretKey(password.toCharArray(), salt, iterationCount, keyLength);

		String originalPassword = password;
		System.out.println("Original password: " + originalPassword);
		String encryptedPassword = encrypt(originalPassword, key);
		System.out.println("Encrypted password: " + encryptedPassword);
		String decryptedPassword = decrypt(encryptedPassword, key);
		System.out.println("Decrypted password: " + decryptedPassword);
	}

	public static SecretKeySpec createSecretKey(char[] password, byte[] salt, int iterationCount, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
		PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
		SecretKey keyTmp = keyFactory.generateSecret(keySpec);
		return new SecretKeySpec(keyTmp.getEncoded(), "AES");
	}

	public static String encrypt(String dataToEncrypt, SecretKeySpec key) throws GeneralSecurityException, UnsupportedEncodingException {
		Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		pbeCipher.init(Cipher.ENCRYPT_MODE, key);
		AlgorithmParameters parameters = pbeCipher.getParameters();
		IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
		byte[] cryptoText = pbeCipher.doFinal(dataToEncrypt.getBytes("UTF-8"));
		byte[] iv = ivParameterSpec.getIV();
		return base64Encode(iv) + ":" + base64Encode(cryptoText);
	}

	private static String base64Encode(byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
	}

	public static String decrypt(String string, SecretKeySpec key) throws GeneralSecurityException, IOException {
		String iv = string.split(":")[0];
		String property = string.split(":")[1];
		Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		pbeCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(base64Decode(iv)));
		return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
	}

	private static byte[] base64Decode(String property) throws IOException {
		return Base64.getDecoder().decode(property);
	}



}
