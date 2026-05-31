package juego;

public class Tijera implements Jugada {
    @Override
    public void comparar(Jugada jugada) {
        jugada.compararTijera(this);
    }

    @Override
    public void compararPiedra(Piedra piedra) {
        System.out.println("¡Ganaste!");
    }

    @Override
    public void compararPapel(Papel papel) {
        System.out.println("¡Perdiste!");

    }

    @Override
    public void compararTijera(Tijera tijera) {
        System.out.println("¡Es un empate!");
    }
}
