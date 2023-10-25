package dao;

import model.Aluno;
import model.Curso;

import java.sql.*;

public class Conexao {
    public Conexao() {
    }

    public static Connection conectar() throws SQLException {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/escola";
        String user = "postgres";
        String password = "postgres";

        Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

        return connection;
    }

    public void insereDadosAluno(Connection connection, String mat, String nome, String codCurso) throws SQLException {
        // Insere um ALUNO usando PreparedStatement.
        String insertSql = "INSERT INTO aluno (mat, nome, cod_curso) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, mat);
        preparedStatement.setString(2, nome);
        preparedStatement.setString(3, codCurso);
        preparedStatement.executeUpdate();
        preparedStatement.close();

        System.out.println("Inserção bem-sucedida!");
        connection.close();
    }

    public void insereDadosCurso(Connection connection, String cod, String descricao, Integer cargaHoraria) throws SQLException {
        // Insere um CURSO usando PreparedStatement.
        String insertSql = "INSERT INTO curso (cod_curso, descricao, carga_horaria) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, cod);
        preparedStatement.setString(2, descricao);
        preparedStatement.setInt(3, cargaHoraria);
        preparedStatement.executeUpdate();
        preparedStatement.close();

        System.out.println("Inserção bem-sucedida!");
        connection.close();
    }

    public void exibeDadosAluno(Connection connection, Aluno aluno) throws SQLException {

        // Recupera todos os alunos e seus respectivos cursos .
        String selectSql = "SELECT a.mat, a.nome, c.descricao FROM aluno a, curso c WHERE a.mat = ? AND a.cod_curso = c.cod_curso";
        PreparedStatement pstmt = connection.prepareStatement(selectSql);
        pstmt.setString(1, aluno.getMatricula());
        ResultSet rs = pstmt.executeQuery();

        // Verifica se o resultSet foi nulo
        if(!rs.next()){
            System.out.println("Nenhum resultado encontrado!");
        }

        // Exibe os alunos.
        while (rs.next()) {
            String matricula = rs.getString("mat");
            String nome = rs.getString("nome");
            String cursoDesc = rs.getString("descricao");
            System.out.println("CURSO DO ALUNO: " + nome);
            System.out.println("Matrícula: " + matricula + ", Curso: " + cursoDesc);
        }

        // Fecha ResultSet e Statement
        pstmt.close();
        rs.close();
        connection.close();
    }

    public void exibeAlunosCurso(Connection connection, Curso curso) throws SQLException {

        // Recupera todos os alunos.
        String selectSql = "SELECT a.mat, a.nome, c.descricao FROM aluno a, curso c WHERE c.cod_curso = ? AND a.cod_curso = c.cod_curso";
        PreparedStatement pstmt = connection.prepareStatement(selectSql);
        pstmt.setString(1, curso.getCodigo());
        ResultSet rs = pstmt.executeQuery();

        // Verifica se o resultSet foi nulo
        if(!rs.next()){
            System.out.println("Nenhum resultado encontrado!");
        }

        // Exibe os alunos.
        while (rs.next()) {
            String codCurso = rs.getString("mat");
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            System.out.println("ALUNOS PRESENTES NO CURSO: " + descricao);
            System.out.println("Matrícula: " + codCurso + ", Alunoo: " + nome);
        }

        // Fecha ResultSet e Statement
        pstmt.close();
        rs.close();
        connection.close();
    }

}
