
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hash;
import model.Usuario;

public class UsuarioDAO {
    Connection con = null;
    public UsuarioDAO(){
        con = Conexao.abrirConexao();
    }
    
    public List<Usuario> pesquisarAll(){
        List<Usuario> lista = new ArrayList<>();
        try {            
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setLevel(rs.getInt("privilegios"));
                usuario.setId(rs.getInt("ID"));
                lista.add(usuario);               
            }
            
        } catch (Exception e) {
        }
        return lista;
    }
    
    
    public void CadastrarUsuario(Usuario usuario){
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios(nome, email, privilegios, senha) VALUES (?, ?, ?, ?)");
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setInt(3, usuario.getLevel()); 
            ps.setString(4, usuario.getSenha());
            ps.execute();
            
        }catch(Exception e){
            
        }
    }
    
    public void atualizarUsuario(Usuario usuario){
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, privilegios = ? WHERE ID = ?");
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setInt(3, usuario.getLevel());
            ps.setInt(4, usuario.getId());
            ps.execute();
        }catch(Exception e){
            
        }
    }
    
    
    public void deleteUsuario(int id){
        try{
            PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
        
        }
        
    }
    
    public boolean LoginUsuario(String user, String pass){
        boolean check = false;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE nome = ? AND senha = ? AND privilegios > 1");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                check = true;
            }
        }catch(Exception e){
        }
        
        return check;
    }

    /*public int pegarCodigo(){
        PreparedStatement ps;
        Usuario p = new Usuario();
        try {
            
            ps = con.prepareStatement("SELECT ID FROM usuarios ORDER BY ID DESC LIMIT 1");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setCodigo(rs.getInt("id"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p.getCodigo();
    }*/
    
    public void pesquisar(int numero){}
    
}
