package juego;

public class Piedra implements Jugada {
    @Override
    public void comparar(Jugada jugada) {
        jugada.compararPiedra(this);
    }

    @Override
    public void compararPiedra(Piedra piedra) {
        System.out.println("¡Es un empate!");
    }

    @Override
    public void compararPapel(Papel papel) {
        System.out.println("¡Ganaste!");
    }

    @Override
    public void compararTijera(Tijera tijera) {
        System.out.println("¡Perdiste!");
    }
}
