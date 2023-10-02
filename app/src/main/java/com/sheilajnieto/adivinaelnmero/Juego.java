package com.sheilajnieto.adivinaelnmero;

import java.util.Random;

public class Juego {

    int valorMinimo = 1;

    int valorMaximo = 10;
    private int intentos = 3;
    private int numeroGenerado;
    private Random random = new Random();

    private boolean winner = false;

   public Juego(int valorMaximo, int valorMinimo) {
        this.valorMaximo = valorMaximo;
       this.valorMinimo = valorMinimo;
   }

    public int generarNumAleatorio() {
        numeroGenerado = random.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;

        return numeroGenerado;
    }

    public String comprobarIntento(int num) {
        if (intentos > 0) {
            //intentos--;
            if (num < numeroGenerado) {
                return "El número es mayor.";
            } else if (num > numeroGenerado) {
                return "El número es menor.";
            } else if (num == numeroGenerado) {
                winner = true;
                return "¡Acertado! Has ganado :) \nPulsa cualquier botón para reiniciar partida.";
            }
        }
        //si no hemos acertado en los primeros 2 intentos..
        // Esto verificará el último intento, en el que intentos vale 0 y no entra en el caso de arriba pero queda esa última oportunidad
        if (num == numeroGenerado) {
            winner = true;
            return "¡Acertado! Has ganado :) \nPulsa cualquier botón para reiniciar partida.";
        } else {
            return "No acertaste y no quedan intentos :( \nPulsa cualquier botón para reiniciar partida.";
        }
    }


    public void reiniciarJuego() {
        intentos = 3; // Reinicia el número de intentos

    }
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getNumeroGenerado() {
        return numeroGenerado;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void getWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isWinner() {
        return winner;
    }

}
