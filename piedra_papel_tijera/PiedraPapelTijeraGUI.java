package piedra_papel_tijera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Parte del frontend
public class PiedraPapelTijeraGUI extends JFrame implements ActionListener {
    //variables globales para los botones del jugador
    JButton piedraBoton, papelBoton, tijeraBoton;

    //eleccion de la PC
    JLabel pcEleccion;

    JLabel pcScoreLabel, playerEleccion;

    //objeto del backend
    PiedraPapelTijera piedraPapelTijera;

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

        // iniciar el objeto del backend
        piedraPapelTijera = new PiedraPapelTijera();

        // componentes del GUI
        addGuiComponente();
    }

    //metodo para agregar los componentes
    private void addGuiComponente() {
        //crear score de la pc y un label con el texto
        //sera el marcador de referencia de la ia
        pcScoreLabel = new JLabel("Pc: 0");

        //elegimos el tamaño y la posicion del layout
        pcScoreLabel.setBounds(0, 43, 450, 30);
        //elegimos la fuente
        pcScoreLabel.setFont(new Font("dialog", Font.BOLD, 26));
        //centramos el texto horizontalmente
        pcScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //agregamos el Jlabel al Jframe
        add(pcScoreLabel);


        //crear las decisiones de la maquina
        pcEleccion = new JLabel("?");
        pcEleccion.setBounds(175, 118,98,81);
        pcEleccion.setFont(new Font("Dialog", Font.PLAIN, 20));
        pcEleccion.setHorizontalAlignment(SwingConstants.CENTER);

        //crear borde negro alrededor
        pcEleccion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pcEleccion);

        //crear score del jugador
        //sera el marcador de referencia del player
        playerEleccion = new JLabel("Player: 0");

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
        piedraBoton.addActionListener(this);
        add(piedraBoton);

        //boton papel
        papelBoton = new JButton("Papel");
        papelBoton.setBounds(165, 387, 105, 81);
        papelBoton.setFont(new Font("Dialog", Font.PLAIN, 18));
        papelBoton.addActionListener(this);
        add(papelBoton);

        //boton tijera
        tijeraBoton = new JButton("Tijera");
        tijeraBoton.setBounds(298, 387, 105, 81);
        tijeraBoton.setFont(new Font("Dialog", Font.PLAIN, 18));
        tijeraBoton.addActionListener(this);
        add(tijeraBoton);




    }


    //mostrar el ganador y el seguir jugando
    private void mostrarDialogos(String mensaje) {
        JDialog resultadoDialogo = new JDialog(this, "Resultado", true);
        resultadoDialogo.setSize(250, 300);
        resultadoDialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultadoDialogo.setResizable(false);

        //mensaje del label
        JLabel resultadoLabel = new JLabel(mensaje);
        resultadoLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultadoDialogo.add(resultadoLabel, BorderLayout.CENTER);


        //intentar de nuevo
        JButton tryAgainButton = new JButton("Jugar otra vez?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reiniciar eleccion PC
                pcEleccion.setText("?");

                //cerrar dialogo
                resultadoDialogo.dispose();
            }
        });

        resultadoDialogo.add(tryAgainButton, BorderLayout.SOUTH);

        resultadoDialogo.setLocationRelativeTo(this);
        resultadoDialogo.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //get de la eleccion de jugador
        String jugadorEleccion = e.getActionCommand().toString();
        // jugar y marcar el resultado
        String resultado = piedraPapelTijera.playerEleccion(jugadorEleccion);

        // cargar la eleccion de la pc
        pcEleccion.setText(piedraPapelTijera.getPcEleccion());

        //actualizar score
        pcScoreLabel.setText("PC: "+ piedraPapelTijera.getPcScore());
        playerEleccion.setText("Player: "+piedraPapelTijera.getPlayerScore());

        //mostrar dialogo de resultado
        mostrarDialogos(resultado);
    }
}
