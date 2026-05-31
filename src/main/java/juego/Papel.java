package juego;

public class Papel implements Jugada {
    @Override
    public void comparar(Jugada jugada) {
        jugada.compararPapel(this);
    }

    @Override
    public void compararPiedra(Piedra piedra) {
        System.out.println("¡Perdiste!");
    }

    @Override
    public void compararPapel(Papel papel) {
        System.out.println("¡Es un empate!");
    }

    @Override
    public void compararTijera(Tijera tijera) {
        System.out.println("¡Ganaste!");
    }
}
