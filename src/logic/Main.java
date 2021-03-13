package logic;

import logic.logs.LogAnalyzer;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello Wolrd !");
		LogAnalyzer la = new LogAnalyzer();
		la.analyzeLog();
	}
}
