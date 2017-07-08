package proyectobd;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jordicastillo
 */
public class Consulta1 extends javax.swing.JPanel {

    private JList lista;
    private JPanel panel, panel2;
    private JLabel nombre;

    public Consulta1() {
        nombre = new JLabel("Consulta 1:");
        lista = new JList();

        panel = new JPanel(new BorderLayout());
        panel2 = new JPanel(new GridLayout(1, 3));
        panel.add("North", nombre);
        panel.add("Center", lista);
        panel.add("South", panel2);
        add(panel);
        llenarlista();
    }

    void llenarlista() {
        DefaultListModel listModel = new DefaultListModel();
        String database = "proyecto";
        String user = "postgres";
        String pass = "postgres";
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + database + "?", user, pass);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT DISTINCT C.NOM_CL, C.APE_CL\n"
                    + "FROM CLIENTES C, ARRIENDA A, COPIA B, VIDEOJUEGOS V\n"
                    + "WHERE V.GENERO='ACCION' AND V.ID_VJ=B.ID_VJ AND B.ID_COPIA=A.ID_COPIA AND A.ID_CL=C.ID_CL\n"
                    + "EXCEPT\n"
                    + "SELECT C2.NOM_CL, C2.APE_CL\n"
                    + "FROM CLIENTES C2, ARRIENDA A2, COPIA B2, VIDEOJUEGOS V2\n"
                    + "WHERE V2.GENERO='INFANTIL' AND V2.ID_VJ=B2.ID_VJ AND B2.ID_COPIA=A2.ID_COPIA AND A2.ID_CL=C2.ID_CL;");
            while (rs.next()) {
                listModel.addElement(rs.getString(1) + " " + rs.getString(2));
            }
            stmt.close();

            lista.setModel(listModel);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
