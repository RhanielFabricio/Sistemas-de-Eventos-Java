public class Eventos {

    String nome;
    String local;
    String data;
    double cache;

    @Override
    public String toString() {
        return "Nome: " + nome +
               "\nLocal: " + local +
               "\nData: " + data +
               "\nCache: R$ " + cache;
    }
}