public class Memoria {
    private int minimo, maximo;
    private int[] blocos;

    public Memoria(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
        this.blocos = gerarNumeros(maximo-minimo);
    }

    private int[] gerarNumeros(int tamanho) {
        int[] blocos = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            blocos[i] = (int) (Math.random() * 100);
        }

        return blocos;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int[] getBlocos() {
        return blocos;
    }

    public void setBlocos(int[] blocos) {
        this.blocos = blocos;
    }
}
