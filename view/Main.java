package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {

		KillController kcon = new KillController();

		String so = kcon.os();

		int op = 9;
		while (op != 0) {
			op = Integer.parseInt(JOptionPane.showInputDialog(so
					+ "\n1 - Listar todos os processos\n2 - Matar processo pelo PID \n3 - Matar processo pelo Nome  \n0 - Sair"));

			switch (op) {
			case 1:
				kcon.listaProcessos();
				break;

			case 2:
				String pid = JOptionPane.showInputDialog("Digite o Pid do processo");
				kcon.mataPID(pid);
				break;
				
			case 3:
				String nome = JOptionPane.showInputDialog("Digite o nome do processo");
				kcon.mataNome(nome);
				break;

			case 0:
				break;

			default:
				JOptionPane.showMessageDialog(null, "Op��o invalida");

			}
		}
	}
}
