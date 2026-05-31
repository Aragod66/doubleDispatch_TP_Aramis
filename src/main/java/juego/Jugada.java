package juego;

public interface Jugada {
    public void comparar(Jugada jugada);
    public void compararPiedra(Piedra piedra);
    public void compararPapel(Papel papel);
    public void compararTijera(Tijera tijera);
}
