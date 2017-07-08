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
public class Consulta2 extends javax.swing.JPanel {

    private JList lista;
    private JPanel panel, panel2;
    private JLabel nombre;

    public Consulta2() {
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

            ResultSet rs = stmt.executeQuery("SELECT V.ID_VJ, V.TITULO\n"
                    + "FROM VIDEOJUEGOS V, COPIA C, ARRIENDA A, TIENEJUEGO T, SUCURSALES S, PERTENECE P\n"
                    + "WHERE S.ID_SUC NOT IN\n"
                    + "(SELECT S1.ID_SUC\n"
                    + "FROM PERTENECE P1, CIUDAD C1, SUCURSALES S1\n"
                    + "WHERE S1.ID_SUC=C1.ID_SUC AND C1.COD_CIU=P1.COD_CIU)\n"
                    + "AND V.ID_VJ=T.ID_VJ AND T.ID_SUC=S.ID_SUC;");
            while (rs.next()) {
                listModel.addElement(rs.getString(1) + " - " + rs.getString(2));
            }
            stmt.close();

            lista.setModel(listModel);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
