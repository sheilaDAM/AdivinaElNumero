package com.sheilajnieto.adivinaelnmero;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private boolean gameover = false;
    private Juego juego;
    private int numeroAleatorio;
    private TextView tvImagen;
    private TextView tvMensajeResultado;
    private TextView tvIntentos;
    private int contadorClicks = 0;

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b10;
    private int num = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //DECLARAMOS TODOS LOS VIEWS NECESARIOS PARA IDENTIFICARLOS

        tvImagen = findViewById(R.id.imagen);
        tvMensajeResultado = findViewById(R.id.tvMensajeResultado);
        tvIntentos = findViewById(R.id.tvIntentos);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);

        juego = new Juego(10, 1);
        numeroAleatorio = juego.generarNumAleatorio();
        tvIntentos.setText("nº de intentos: " + String.valueOf(juego.getIntentos()));

        //ELECCIÓN DEL/A JUGADOR/A
        View.OnClickListener listener = view -> {

            int id = view.getId();

                if (id == R.id.b1)
                    num = 1; //guardamos la elección del número en una variable de tipo entero para compararla con el número generado aleatoriamente
                else if (id == R.id.b2) num = 2;
                else if (id == R.id.b3) num = 3;
                else if (id == R.id.b4) num = 4;
                else if (id == R.id.b5) num = 5;
                else if (id == R.id.b6) num = 6;
                else if (id == R.id.b7) num = 7;
                else if (id == R.id.b8) num = 8;
                else if (id == R.id.b9) num = 9;
                else if (id == R.id.b10) num = 10;


                if(gameover == false) {
                    //como al entrar aquí ya hemos pulsado 1 botón, le restamos 1 a intentos
                    juego.setIntentos(juego.getIntentos() - 1);
                    //comprobamos el intento con el método de la clase juego comprobarIntentos pasándole nuestra elección
                    tvMensajeResultado.setText(juego.comprobarIntento(num));
                    //actualizamos los intentos restantes que se muestran en pantalla
                    tvIntentos.setText("nº de intentos: " + juego.getIntentos());

                    //comprobamos el resultado de nuestro intento tras llamar al método de comprobación
                    //si la variable winner se puso a true es que el número coincide y hemos acertado
                    if (juego.isWinner() == true) {
                        tvImagen.setText(String.valueOf(num)); //mostramos el número por pantalla
                        tvImagen.setTextColor(Color.GREEN); //lo mostramos en color verde
                        gameover = true; //cambiamos esta variable para que ya no compruebe más intentos y al volver a pulsar un botón reinicie
                    //si no se puso winner a true es que no hemos acertado y se va al else
                    } else {
                        //si ya hemos agotado los intentos se mostrará en rojo el número que se generó aleatoriamente entre 1 y 10
                        if (juego.getIntentos() == 0) {
                            tvImagen.setText(String.valueOf(numeroAleatorio));
                            tvImagen.setTextColor(Color.RED);
                            //volvemos a habilitar los botones para que pulsando el que sea se reinicie
                            b1.setEnabled(true);
                            b2.setEnabled(true);
                            b3.setEnabled(true);
                            b4.setEnabled(true);
                            b5.setEnabled(true);
                            b6.setEnabled(true);
                            b7.setEnabled(true);
                            b8.setEnabled(true);
                            b9.setEnabled(true);
                            b10.setEnabled(true);
                            gameover = true;
                            Toast.makeText(MainActivity.this, "No hay más intentos, total:" + juego.getIntentos(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, "gameover: " + gameover, Toast.LENGTH_SHORT).show();
                        //si quedan intentos deshabilitamos el botón que no ha acertado para intentar otro y volvemos a pulsar otro número
                        } else {
                            Button button = findViewById(id);
                            button.setEnabled(false);
                            Toast.makeText(MainActivity.this, "intentos " + juego.getIntentos(), Toast.LENGTH_SHORT).show();
                        }
                    }
                //si gameover es true vendrá a este else, sea porque se ha acertado el número o bien hemos agotados los intentos sin éxito
                }else {
                    reiniciarJuego(tvImagen, tvMensajeResultado, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);
                    Toast.makeText(MainActivity.this, "nuevo número generado " + numeroAleatorio, Toast.LENGTH_SHORT).show();
                }


            };

            // Asignamos el OnClickListener a todos los botones
            b1.setOnClickListener(listener);
            b2.setOnClickListener(listener);
            b3.setOnClickListener(listener);
            b4.setOnClickListener(listener);
            b5.setOnClickListener(listener);
            b6.setOnClickListener(listener);
            b7.setOnClickListener(listener);
            b8.setOnClickListener(listener);
            b9.setOnClickListener(listener);
            b10.setOnClickListener(listener);
        }

    private void reiniciarJuego(TextView tvImagen, TextView tvMensajeResultado, Button b1, Button b2, Button b3,Button b4, Button b5, Button b6, Button b7, Button b8,Button b9,Button b10) {

        // Habilitamos de nuevo todos los botones
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        b10.setEnabled(true);

        // Reiniciamos los intentos a 3 y creamos un nuevo número aleatorio
        juego.reiniciarJuego();
        juego.setWinner(false); //al reiniciar el juego ya no hay ganador establecido, lo ponemos a false también
        numeroAleatorio = juego.generarNumAleatorio();

        // Mostrar imagen con signos de interrogación
        tvImagen.setText("¿?");
        tvImagen.setTextColor(getResources().getColor(R.color.color_verde_interrogacion_inicial));
        tvMensajeResultado.setText("");
        tvIntentos.setText("nº de intentos: " + juego.getIntentos());

        gameover = false;

        Toast.makeText(MainActivity.this, "entró en reiniciar, gameover=  " + gameover, Toast.LENGTH_SHORT).show();

    }
}