package com.gunther.rapsberry.bluetooth.bluetooth;

public class App {
	public static void main(String[] args) {
		ShellCommandExecutor executor = new ShellCommandExecutor();

		String output = executor.executeCommand(ShellCommandExecutor.SHELL_START_BLUETOOTH);
		System.out.println("Resultat : " + output + " ! ");
	}
}
