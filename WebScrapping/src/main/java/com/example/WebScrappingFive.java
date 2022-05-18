package com.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.example.entities.ManipuladorArquivo;

@Service
public class WebScrappingFive {

	public static void main(String[] args) throws IOException, InterruptedException {		
		File arq = ManipuladorArquivo.criarArquivo();
		String url = "https://www.mairovergara.com/";

		Document doc = Jsoup.connect(url).get();

		List<Element> artigos = doc.getElementsByClass("entry-title td-module-title");

		List<Element> as = new ArrayList<Element>();
		List<String> hrefs = new ArrayList<String>();

		artigos.forEach(element -> {
			as.add(element.getElementsByTag("a").first());
		});

		as.forEach(element -> {
			hrefs.add(element.attr("href"));
		});

		Thread t1 = new Thread(() -> 
			hrefs.forEach(s -> {
			System.out.println("URL: " + s);
			ManipuladorArquivo.escreveDadosDoUsuario(s, arq);
		}));

		t1.start();

	}

}
