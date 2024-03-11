package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public String os() {

		String os = System.getProperty("os.name");
		return os;
	}

	public void listaProcessos() {

		String os = os();
		String process = "";

		if (os.contains("Windows"))
			process = "TASKLIST /FO TABLE";
		else if (os.contains("Linux"))
			process = "ps-ef";

		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			String[] mediaString = null;

			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void mataPID(String pid) {
		String os = os();
		String process = "";

		if (os.contains("Windows"))
			process = "TASKKILL /PID "+ pid;
		else if (os.contains("Linux"))
			process = "kill -9 "+pid;
		

		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			String[] mediaString = null;

			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public void mataNome(String nome) {
		String os = os();
		String process = "";

		if (os.contains("Windows"))
			process = "TASKKILL /IM "+nome;
		else if (os.contains("Linux"))
			process = "pkill -f "+ nome;
		

		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			String[] mediaString = null;

			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
