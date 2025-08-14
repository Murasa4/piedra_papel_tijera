package piedra_papel_tijera;

import javax.swing.*;
import java.awt.*;

//Parte del frontend
public class PiedraPapelTijeraGUI extends JFrame {
    //variables globales para los botones del jugador
    JButton piedraBoton, papelBoton, tijeraBoton;

    //constructor del jframe y titulo del juego
    public PiedraPapelTijeraGUI() {
        super("Piedra - Papel - Tijera");

        //defino el tamaño de la ventana
        setSize(500, 600);

        //para no usar coordenadas a los componentes
        setLayout(null);

        //terminar cuando cierra el GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //centrar la pantalla al iniciar
        setLocationRelativeTo(null);

        // componentes del GUI
        addGuiComponente();
    }

    //metodo para agregar los componentes
    private void addGuiComponente() {
        //crear score de la pc y un label con el texto
        //sera el marcador de referencia de la ia
        JLabel pcScoreLabel = new JLabel("Pc: 0");

        //elegimos el tamaño y la posicion del layout
        pcScoreLabel.setBounds(0, 43, 450, 30);
        //elegimos la fuente
        pcScoreLabel.setFont(new Font("dialog", Font.BOLD, 26));
        //centramos el texto horizontalmente
        pcScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //agregamos el Jlabel al Jframe
        add(pcScoreLabel);


        //crear las decisiones de la maquina
        JLabel pcEleccion = new JLabel("?");
        pcEleccion.setBounds(175, 118,98,81);
        pcEleccion.setFont(new Font("Dialog", Font.PLAIN, 18));
        pcScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //crear borde negro alrededor
        pcEleccion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pcEleccion);

        //crear score del jugador
        //sera el marcador de referencia del player
        JLabel playerEleccion = new JLabel("Player: 0");

        //elegimos el tamaño y la posicion del layout
        playerEleccion.setBounds(0, 317, 450, 30);
        //elegimos la fuente
        playerEleccion.setFont(new Font("Dialog", Font.BOLD, 26));
        //centramos el texto horizontalmente
        playerEleccion.setHorizontalAlignment(SwingConstants.CENTER);
        //agregamos el Jlabel al Jframe
        add(playerEleccion);


        // boton del jugador

        //boton piedra
        piedraBoton = new JButton("Piedra");
        piedraBoton.setBounds(40, 387, 105, 81);
        piedraBoton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(piedraBoton);

        //boton papel
        papelBoton = new JButton("Papel");
        papelBoton.setBounds(165, 387, 105, 81);
        papelBoton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(papelBoton);

        //boton tijera
        tijeraBoton = new JButton("Papel");
        tijeraBoton.setBounds(298, 387, 105, 81);
        tijeraBoton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(tijeraBoton);

    }


    //mostrar el ganador y el seguir jugando
    private void mostrarDialogos(String mensaje) {
        JDialog resultadoDialogo = new JDialog(this, "Resultado", true);
        resultadoDialogo.setSize(227, 124);
        resultadoDialogo.setResizable(false);
    }
}
