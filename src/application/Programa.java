package application;

import java.util.Scanner;

import entities.Aluno;
import entities.Contrato;
import entities.Curso;
import entities.Disciplina;
import entities.Fornecedor;
import entities.Professor;
import entities.Turma;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int respostaUsuario;
		char respostaUsuarioSistema;
		
		do {
			System.out.println("Olá ! Seja bem-vindo(a) ao sistema de cadastro da universidade UNIPISEN.");
			System.out.println("Por favor, digite a operação desejada a partir dos números do menu abaixo:");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("0 -> Cancelar e sair do sistema.");
			System.out.println("1 -> Cadastrar novo(a) Aluno(a).");
			System.out.println("2 -> Cadastrar novo(a) Professor(a).");
			System.out.println("3 -> Cadastrar nova Turma.");
			System.out.println("4 -> Cadastrar novo Curso.");
			System.out.println("5 -> Cadastrar nova Disciplina.");
			System.out.println("6 -> Cadastrar novo Fornecedor.");
			System.out.println("7 -> Cadastrar novo Contrato.");
			System.out.println("8 -> Exibir todos os alunos.");
			System.out.println("9 -> Procurar aluno único por nome.");
			System.out.println("10-> Exibir todos os professores.");
			System.out.println("11-> Procurar professor único por nome.");
			System.out.println("12-> Exibir todas as turmas.");
			System.out.println("13-> Procurar turma única por número de registro.");
			System.out.println("14-> Exibir todos os cursos.");
			System.out.println("15-> Procurar curso único por nome.");
			System.out.println("16-> Exibir todas as disciplinas.");
			System.out.println("17-> Procurar disciplina única por nome.");
			System.out.println("18-> Exibir todos os fornecedores.");
			System.out.println("19-> Procurar fornecedor único por nome.");
			System.out.println("20-> Exibir todos os contratos.");
			System.out.println("21-> Procurar contrato único por número de registro.");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Qual das operações do menu acima você deseja realizar?");
			System.out.print("Por favor, digite um número de 0 a 21: ");
			
			respostaUsuario = sc.nextInt();
			
			switch (respostaUsuario) {
			case 0:
				System.out.println("O sistema está sendo finalizado. Volte sempre.");
				break;
			case 1:
				Aluno aluno = new Aluno();
				aluno.cadastrarPessoaFisica();
				break;
			case 2:
				Professor professor = new Professor();
				professor.cadastrarPessoaFisica();
				break;
			case 3:
				Turma turma = new Turma();
				turma.cadastrarTurma();
				break;
			case 4:
				Curso curso = new Curso();
				curso.cadastrarCurso();
				break;
			case 5:
				Disciplina disciplina = new Disciplina();
				disciplina.cadastrarDisciplina();
				break;
			case 6:
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.cadastrarPessoaJuridica();
				break;
			case 7:
				Contrato contrato = new Contrato();
				contrato.registrarContrato();
				break;
			case 8:
				Aluno aluno2 = new Aluno();
				aluno2.exibirPessoas();
				break;
			case 9:
				System.out.println("Qual o nome do aluno que deseja procurar pelo cadastro?");
				sc.nextLine();
				String nome = sc.nextLine();
				Aluno aluno3 = new Aluno();
				aluno3.exibirPessoa(nome);
				break;
			case 10:
				Professor professor2 = new Professor();
				professor2.exibirPessoas();
				break;
			case 11:
				System.out.println("Qual o nome do professor que deseja procurar pelo cadastro?");
				sc.nextLine();
				String nome2 = sc.nextLine();
				Professor professor3 = new Professor();
				professor3.exibirPessoa(nome2);
				break;
			case 12:
				Turma turma2 = new Turma();
				turma2.exibirTurmas();
				break;
			case 13:
				System.out.println("Qual o número de registro da turma que deseja procurar pelo cadastro?");
				int numeroRegistro = sc.nextInt();
				Turma turma3 = new Turma();
				turma3.exibirTurma(numeroRegistro);
				break;
			case 14:
				Curso curso2 = new Curso();
				curso2.exibirCursos();
				break;
			case 15:
				System.out.println("Qual o nome do curso que deseja procurar pelo cadastro?");
				sc.nextLine();
				String nome3 = sc.nextLine();
				Curso curso3 = new Curso();
				curso3.exibirCurso(nome3);
				break;
			case 16:
				Disciplina disciplina2 = new Disciplina();
				disciplina2.exibirDisciplinas();
				break;
			case 17:
				System.out.println("Qual o nome da disciplina que deseja procurar pelo cadastro?");
				sc.nextLine();
				String nome4 = sc.nextLine();
				Disciplina disciplina3 = new Disciplina();
				disciplina3.exibirDisciplina(nome4);
				break;
			case 18:
				Fornecedor fornecedor2 = new Fornecedor();
				fornecedor2.exibirEmpresas();
				break;
			case 19:
				System.out.println("Qual o nome/razão social do fornecedor que deseja procurar pelo cadastro?");
				sc.nextLine();
				String nome5 = sc.nextLine();
				Fornecedor fornecedor3 = new Fornecedor();
				fornecedor3.exibirEmpresa(nome5);
				break;
			case 20:
				Contrato contrato2 = new Contrato();
				contrato2.exibirContratos();
				break;
			case 21:
				System.out.println("Qual o número de registro do contrato que deseja procurar pelo cadastro?");
				int numeroRegistro2 = sc.nextInt();
				Contrato contrato3 = new Contrato();
				contrato3.exibirContrato(numeroRegistro2);
				break;
			default:
				System.out.println("Você digitou um valor inválido.");
			}
			System.out.println();
			
			if (respostaUsuario != 0) {
				System.out.println("Você deseja realizar mais alguma operação? Responda 's' para continuar ou entre com qualquer valor para encerrar o sistema: ");
				respostaUsuarioSistema = sc.next().charAt(0);
			}
			else {
				respostaUsuarioSistema = 'n';
			}
			
		} while (respostaUsuarioSistema == 's' || respostaUsuarioSistema == 'S');
		
		System.out.println("O sistema foi finalizado. Muito obrigado e volte sempre!");
		
		sc.close();
	}
}
