/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ALIOMAR
 * cpf, nome, dt_nascimento, sexo, telefone, convenio
 */
public class PacienteDAO {
    public static int inserePaciente (Paciente paciente, Connection con) throws SQLException{
        String comando = "INSERT INTO PACIENTE VALUES ('" + 
                paciente.getCpf() + "','" + 
                paciente.getNome() + "','" +
                paciente.getDt_nascimento() + "','" +
                paciente.getSexo() + "','" +
                paciente.getTelefone() + "','" +
                paciente.getConvenio() + "')";
        Statement st;
        int qtd;
        st = con.createStatement();
        return st.executeUpdate(comando);
    }
}
