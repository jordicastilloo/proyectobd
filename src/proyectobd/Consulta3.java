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
public class Consulta3 extends javax.swing.JPanel {

    private JList lista;
    private JPanel panel, panel2;
    private JLabel nombre;

    public Consulta3() {
        nombre = new JLabel("CONSULTA 3:");
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

            ResultSet rs = stmt.executeQuery("SELECT * FROM C3");
            while (rs.next()) {
                listModel.addElement(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
            }
            stmt.close();

            lista.setModel(listModel);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
