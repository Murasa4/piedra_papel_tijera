package piedra_papel_tijera;

import javax.swing.*;

public class AppGame {
    public static void main(String[] args) {
        //ejecutar el codigo dentro del evento de swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //instanciamos el objeto
                PiedraPapelTijeraGUI piedraPapelTijeraGUI = new PiedraPapelTijeraGUI();

                //mostrar la pantalla
                piedraPapelTijeraGUI.setVisible(true);
            }
        });

    }
}
