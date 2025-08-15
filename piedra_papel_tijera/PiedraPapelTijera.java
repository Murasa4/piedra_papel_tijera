package piedra_papel_tijera;

import java.util.Random;

//logica para el juego
public class PiedraPapelTijera {
    //elecciones de la pc
    private static final String[] pcElecciones = {"Piedra", "Papel", "Tijera"};

    public String getPcEleccion() {
        return pcEleccion;
    }

    public int getPcScore() {
        return pcScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private String pcEleccion;

    private int pcScore, playerScore;

    //hacemos un generador random para sus elecciones
    private Random random;

    public PiedraPapelTijera() {
        random = new Random();
    }

    public String playerEleccion(String jugadorEleccion) {
        //pc elecciones generador
        pcEleccion = pcElecciones[random.nextInt(pcElecciones.length)];

        String resultado;

        //condiciones
        if(pcEleccion.equals("Piedra")) {
            if(jugadorEleccion.equals("Papel")) {
                resultado = "Jugador Gana";
                playerScore++;
            } else if(jugadorEleccion.equals("Tijera")) {
                resultado = "Pc Gana";
                pcScore++;
            } else {
                resultado = "Empate";
            }
        } else if(pcEleccion.equals("Papel")) {
            if(jugadorEleccion.equals("Tijera")) {
                resultado = "Jugador Gana";
                playerScore++;
            } else if(jugadorEleccion.equals("Piedra")) {
                resultado = "Pc Gana";
                pcScore++;
            } else {
                resultado = "Empate";
            }
        } else {
            //pc elige tijera
            if(jugadorEleccion.equals("Piedra")) {
                resultado = "Jugador Gana";
                playerScore++;
            } else if(jugadorEleccion.equals("Papel")) {
                resultado = "Pc Gana";
                pcScore++;
            } else {
                resultado = "Empate";
            }
        }
        return resultado;
    }
}