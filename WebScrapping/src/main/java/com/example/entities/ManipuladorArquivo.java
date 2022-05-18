package com.example.entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManipuladorArquivo {
	public static Scanner ler = new Scanner(System.in);

	public static File criarArquivo() {
		File arq = new File("URL.csv");
		try {
			arq.createNewFile();
		} catch (IOException e) {
			System.out.println("Arquivo não encontrado");
		}
		return arq;
	}

	public static void escreveDadosDoUsuario(String s, File arq) {
		try {
			FileWriter escrever = new FileWriter(arq, true);
			escrever.write(s + "\n");
			escrever.close();
		} catch (IOException e) {
			System.out.println("Arquivo não encontrado");
		}
	}



}
