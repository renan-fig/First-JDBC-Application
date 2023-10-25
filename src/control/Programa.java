package control;

import dao.Conexao;
import model.Aluno;
import model.Curso;

import java.sql.SQLException;
import java.util.Scanner;

import static dao.Conexao.conectar;

public class Programa {
    public static void main(String[] args) throws SQLException {

        boolean flag = false;
        Conexao conexao = new Conexao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("SISTEMA DE GESTÃO UNILSALLE");


        do{
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 - Cadastrar curso \n2 - Cadastrar aluno\n3 - Exibir alunos de um curso\n4 - Exibir dados do aluno\n5 - Sair" );
            Integer opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    Curso curso = new Curso();

                    System.out.print("Insira o código do curso: ");
                    curso.setCodigo(scanner.nextLine());
                    System.out.print("Insira o nome do curso: ");
                    curso.setDescricao(scanner.nextLine());
                    System.out.print("Insira a carga horária do curso: ");
                    curso.setCargaHoraria(scanner.nextInt());


                    conexao.insereDadosCurso(conectar(), curso.getCodigo(), curso.getDescricao(), curso.getCargaHoraria());

                    break;

                case 2:
                    Aluno aluno = new Aluno(null, null,  new Curso());

                    System.out.println("Insira a matricula do aluno: ");
                    aluno.setMatricula(scanner.nextLine());
                    System.out.println("Insira o nome do aluno: ");
                    aluno.setNome(scanner.nextLine());
                    System.out.println("Escolha um curso (código): ");
                    aluno.curso.setCodigo(scanner.next());

                    conexao.insereDadosAluno(conectar(), aluno.getMatricula(), aluno.getNome(), aluno.getCurso().getCodigo());

                    break;

                case 3:
                    Curso cursoProcurado = new Curso();

                    System.out.println("Insira o código do curso que deseja procurar: ");
                    cursoProcurado.setCodigo(scanner.nextLine());

                    conexao.exibeAlunosCurso(conectar(), cursoProcurado);

                    break;

                case 4:
                    Aluno alunoProcurado = new Aluno();

                    System.out.println("Insira a matrícula do aluno que deseja procurar: ");
                    alunoProcurado.setMatricula(scanner.nextLine());

                    conexao.exibeDadosAluno(conectar(), alunoProcurado);

                    break;

                case 5:

                    System.out.println("Programa finalizado!");

                    flag = true;
                    break;
            }
        }while(flag = false);

    }
}