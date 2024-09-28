package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Dados da " + (i+1) + "ª aula: ");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char opt = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			
			if (opt == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				
				list.add(new Video(title, url, seconds));
			}
			else if (opt == 't') {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				
				list.add(new Task(title, description, questionCount));
			}
			
		}
		
		int sum = 0;
		
		for (Lesson les : list) {
			sum += les.duration();
		}
		
		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", sum);
		
		sc.close();
	}

}
