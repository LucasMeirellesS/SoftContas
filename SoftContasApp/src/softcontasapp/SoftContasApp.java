package softcontasapp;
import java.util.Scanner;
import softcontas.gui.TelaI;
public class SoftContasApp {

    public static void main(String[] args) {
        /*ContasDao dao = new ContasDao();
        dao.conectar();
        dao.listarPL();
        dao.listarPassivo();
        for(Contas c: ListaContasPL.Listar()){
            System.out.println(c.getNome());
            System.out.println(c.getNatureza());
            System.out.println(c.getGrupo());
            System.out.println("-----------------");
        
        }
        dao.desconectar();*/
        
        TelaI tela = new TelaI();
        tela.setVisible(true);
        
        
    }
    
}
