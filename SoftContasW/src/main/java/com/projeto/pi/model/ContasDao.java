/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.pi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ContasDao {
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    
    public boolean conectar(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contasoft", "root","14728360Meub@nco");
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            return false;
        }
    }
    
    
    public void listar(){
        
        
        try{
            if(ListaNomeContas.Listar().isEmpty()){
                st = conn.prepareStatement("select nome from plano_de_contas");
                rs = st.executeQuery();
                
                while(rs.next()){
                    ListaNomeContas.Adicionar(rs.getString("nome"));
                    
                }
                
            }
            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Deu algo errado em listar, meu chapa: "+ex.getMessage());
                
            }
    
    }
    
    
    public void listarAtivo(){
                try{
            if(ListaNomeAtivo.Listar().isEmpty()){
                st = conn.prepareStatement("select nome, natureza, grupo, subgrupo from plano_de_contas join ativo on plano_de_contas.id = ativo.contas_id");
                rs = st.executeQuery();
                Contas c;
                while(rs.next()){
                    ListaNomeAtivo.Adicionar(rs.getString("nome"));
                    c = new Ativo(rs.getString("nome"), 0, rs.getString("natureza"), rs.getString("grupo"), rs.getString("subgrupo"));
                    ListaContasAtivo.Adicionar(c);
                }
                
            }
            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Deu algo errado em listarAtivo, meu chapa: "+ex.getMessage());
                
            }
    
    }
    
    public void listarPassivo(){
                try{
            if(ListaNomePassivo.Listar().isEmpty()){
                st = conn.prepareStatement("select nome, natureza, grupo from plano_de_contas join passivo on plano_de_contas.id = passivo.contas_id");
                rs = st.executeQuery();
                Contas c;
                while(rs.next()){
                    ListaNomePassivo.Adicionar(rs.getString("nome"));
                    c = new Passivo(rs.getString("nome"),0 ,rs.getString("natureza"), rs.getString("grupo"));
                    ListaContasPassivo.Adicionar(c);
                }
                
            }
            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Deu algo errado listarPassivo, meu chapa: "+ex.getMessage());
                
            }
    
    }
    
    
    public void listarPL(){
                try{
            if(ListaNomePL.Listar().isEmpty()){
                st = conn.prepareStatement("select nome, natureza, grupo from plano_de_contas join patrimonio_liquido on plano_de_contas.id = patrimonio_liquido.contas_id");
                rs = st.executeQuery();
                Contas c;
                while(rs.next()){
                    ListaNomePL.Adicionar(rs.getString("nome"));
                    c = new PL(rs.getString("nome"), 0,rs.getString("natureza"), rs.getString("grupo"));
                    ListaContasPL.Adicionar(c);
                }
                
            }
            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Deu algo errado listarPL, meu chapa: "+ex.getMessage());
                
            }
    
    }
    
    
    
    public void listarResultado(){
                try{
            if(ListaNomeResultado.Listar().isEmpty()){
                st = conn.prepareStatement("select nome, natureza, grupo from plano_de_contas join contas_de_resultado on plano_de_contas.id = contas_de_resultado.contas_id");
                rs = st.executeQuery();
                Contas c;
                while(rs.next()){
                    ListaNomeResultado.Adicionar(rs.getString("nome"));
                    c = new Resultado(rs.getString("nome"), 0, rs.getString("natureza"), rs.getString("grupo"));
                    ListaContasResultado.Adicionar(c);
                    
                }
                
            }
            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Deu algo errado listarResultado, meu chapa: "+ex.getMessage());
                
            }
    
    }
    
    
    
    
    
    public boolean comparaContasAtivo(Contas conta){
       
        if(ListaNomeContas.Listar().contains(conta.getNome().toUpperCase())){
            JOptionPane.showMessageDialog(null, "A conta está registrada no plano de contas!");
            if(ListaNomeAtivo.Listar().contains(conta.getNome().toUpperCase())){
                try{
                    String comparaNatureza = null;
                    String comparaGrupo = null;
                    String comparaSubgrupo = null;
                    st = conn.prepareStatement("select nome, natureza, grupo, subgrupo from plano_de_contas join ativo on plano_de_contas.id = ativo.contas_id where plano_de_contas.nome = ?");
                    st.setString(1, conta.getNome().toUpperCase());
                    rs = st.executeQuery();

                    if(rs.next()){
                        comparaNatureza = rs.getString("natureza");
                        comparaGrupo = rs.getString("grupo");
                        comparaSubgrupo = rs.getString("subgrupo");
                    }

                    if(conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo) && conta.getSubgrupo().equals(comparaSubgrupo)){
                        JOptionPane.showMessageDialog(null, "A conta foi validada com sucesso!");
                        return false;
                    }

                    else if(conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo) && !conta.getSubgrupo().equals(comparaSubgrupo)){
                        JOptionPane.showMessageDialog(null, "O subgrupo da conta está incorreto! O correto é "+comparaSubgrupo+"!");
                        return false;
                    }
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo) && conta.getSubgrupo().equals(comparaSubgrupo)){
                        JOptionPane.showMessageDialog(null, "Grupo da conta está incorreto! O correto é "+comparaGrupo+"!");
                        return false;
                    }
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo) && !conta.getSubgrupo().equals(comparaSubgrupo)){
                        JOptionPane.showMessageDialog(null, "Grupo e subgrupo da conta estão incorretos! O grupo correto é "+comparaGrupo+" e o subgrupo é "+comparaSubgrupo+"!");
                        return false;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo) && !conta.getSubgrupo().equals(comparaSubgrupo)){
                        JOptionPane.showMessageDialog(null, "Natureza e subgrupo da conta estão incorretos! O grupo correto é "+comparaGrupo+" e o subgrupo é "+comparaSubgrupo+"!");
                        return false;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo) && conta.getSubgrupo().equals(comparaSubgrupo)){
                        JOptionPane.showMessageDialog(null, "Natureza da conta está incorreta! O correto é "+comparaNatureza+"!");
                        return false;
                    }
           
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo) && conta.getSubgrupo().equals(comparaSubgrupo)){
                        JOptionPane.showMessageDialog(null, "Natureza e grupo da conta estão incorretos! O correto é "+comparaNatureza+", "+comparaGrupo+"!");
                        return false;
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo) && !conta.getSubgrupo().equals(comparaSubgrupo)){
                        JOptionPane.showMessageDialog(null, "A natureza, o grupo, e o subgrupo da conta estão incorretos! O corretos são "+comparaNatureza+", "+comparaGrupo+", "+comparaSubgrupo+"!");
                        return false;
                    }
                    

                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Deu algo errado comparaContasAtivo, meu chapa: "+ex.getMessage());
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Essa conta não é uma conta de ativo!");
                return false;
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null, "A conta não está registrada no plano de contas!");
            return false;
        }
        return true;
    }
    
    
    
        

    
    
        public void comparaContasPassivo(Contas conta){
        
        if(ListaNomeContas.Listar().contains(conta.getNome().toUpperCase())){
            JOptionPane.showMessageDialog(null, "A conta está registrada no plano de contas!");
            if(ListaNomePassivo.Listar().contains(conta.getNome().toUpperCase())){
                try{
                    String comparaNatureza = null;
                    String comparaGrupo = null;
                    st = conn.prepareStatement("select nome, natureza, grupo from plano_de_contas join passivo on plano_de_contas.id = passivo.contas_id where plano_de_contas.nome = ?");
                    st.setString(1, conta.getNome().toUpperCase());
                    rs = st.executeQuery();
                    
                    if(rs.next()){
                        comparaNatureza = rs.getString("natureza");
                        comparaGrupo = rs.getString("grupo");
                    }
                    

                    if(conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "A conta foi validada com sucesso!");
                    }
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "O grupo da conta está incorreto! O correto é "+comparaGrupo+"!");
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "A natureza da conta está incorreta! O correto é "+comparaNatureza+"!");
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "Você registrou a conta incorretamente!");
                    }
                                        
                    

                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Deu algo errado comparaContasPassivo, meu chapa: "+ex.getMessage());
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Essa conta não é uma conta de passivo!");
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null, "A conta não está registrada no plano de contas!");
        }
    }
        
        
        public void comparaContasPL(Contas conta){
        
        if(ListaNomeContas.Listar().contains(conta.getNome().toUpperCase())){
            JOptionPane.showMessageDialog(null, "A conta está registrada no plano de contas!");
            if(ListaNomePL.Listar().contains(conta.getNome().toUpperCase())){
                try{
                    String comparaNatureza = null;
                    String comparaGrupo = null;
                    st = conn.prepareStatement("select nome, natureza, grupo from plano_de_contas join patrimonio_liquido on plano_de_contas.id = patrimonio_liquido.contas_id where plano_de_contas.nome = ?");
                    st.setString(1, conta.getNome().toUpperCase());
                    rs = st.executeQuery();
                    
                    if(rs.next()){
                        comparaNatureza = rs.getString("natureza");
                        comparaGrupo = rs.getString("grupo");
                    }

                    if(conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "A conta foi validada com sucesso!");
                    }
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "O grupo da conta está incorreto! O correto é "+comparaGrupo+"!");
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "A natureza da conta está incorreta! O correto é "+comparaNatureza+"!");
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "Você registrou a conta incorretamente! A natureza correta é: "+comparaNatureza+" e o grupo correto é: "+comparaGrupo+"!");
                    }
                                        
                    

                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Deu algo errado comparaContasPL, meu chapa: "+ex.getMessage());
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Essa conta não é uma conta de patrimônio líquido!");
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null, "A conta não está registrada no plano de contas!");
        }
    }
        
    
    public void comparaContasResultado(Contas conta){
        
        if(ListaNomeContas.Listar().contains(conta.getNome().toUpperCase())){
            JOptionPane.showMessageDialog(null, "A conta está registrada no plano de contas!");
            if(ListaNomeResultado.Listar().contains(conta.getNome().toUpperCase())){
                try{
                    String comparaNatureza = null;
                    String comparaGrupo = null;
                    st = conn.prepareStatement("select nome, natureza, grupo from plano_de_contas join passivo on plano_de_contas.id = passivo.contas_id where plano_de_contas.nome = ?");
                    st.setString(1, conta.getNome().toUpperCase());
                    rs = st.executeQuery();

                    if(rs.next()){
                        comparaNatureza = rs.getString("natureza");
                        comparaGrupo = rs.getString("grupo");
                    }
                    

                    if(conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "A conta foi validada com sucesso!");
                    }
                    
                    else if(conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "O grupo da conta está incorreto! O correto é "+comparaGrupo+"!");
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "A natureza da conta está incorreta! O correto é "+comparaNatureza+"!");
                    }
                    
                    else if(!conta.getNatureza().equals(comparaNatureza) && !conta.getGrupo().toLowerCase().equals(comparaGrupo)){
                        JOptionPane.showMessageDialog(null, "Você registrou a conta incorretamente!");
                    }
                                        
                    

                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Deu algo errado comparaContasResultado, meu chapa: "+ex.getMessage());
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Essa conta não é uma conta de patrimônio líquido!");
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null, "A conta não está registrada no plano de contas!");
        }
    }
        
    
    
    public void desconectar(){
        try{
            conn.close();
        }catch(SQLException ex){
        
        }
    }
    
    
}
    

