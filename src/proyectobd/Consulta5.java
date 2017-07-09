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
public class Consulta5 extends javax.swing.JPanel {

    private JList lista;
    private JPanel panel, panel2;
    private JLabel nombre;

    public Consulta5() {
        nombre = new JLabel("CONSULTA 5:");
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

            ResultSet rs = stmt.executeQuery("SELECT DISTINCT V.TITULO, V.GENERO\n"
                    + "FROM VIDEOJUEGOS V, COPIA C, ARRIENDA A\n"
                    + "WHERE V.ID_VJ=C.ID_VJ\n"
                    + "AND V.ID_VJ NOT IN\n"
                    + "(SELECT V.ID_VJ\n"
                    + "FROM ARRIENDA A1\n"
                    + "WHERE A1.FEC_ARRIENDO BETWEEN '2017-04-01' AND '2017-04-30'\n"
                    + "AND A1.ID_COPIA=C.ID_COPIA)\n"
                    + "AND A.ID_COPIA=C.ID_COPIA\n"
                    + "GROUP BY V.TITULO, V.GENERO;");
            while (rs.next()) {
                listModel.addElement(rs.getString(1) + " - " + rs.getString(2));
            }
            stmt.close();

            lista.setModel(listModel);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta5.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
