public class Memoria {
    private int minimo, maximo;
    private int posCabeca;
    private int[] blocos;

    public Memoria(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
        this.posCabeca = (int) Math.ceil((maximo - minimo) / 2);
        this.blocos = gerarBlocos(maximo - minimo + 1);
    }

    private int[] gerarBlocos(int tamanho) {
        int[] blocos = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            blocos[i] = (int) (Math.random() * 99);
        }

        return blocos;
    }

    public int getPosCabeca() {
        return posCabeca;
    }

    public void setPosCabeca(int posCabeca) {
        this.posCabeca = posCabeca;
    }

    public int getPosCabecaBloco() {
        return posCabeca + this.minimo;
    }

    public int[] getBlocos() {
        return blocos;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Blocos{ ");
        int bloco;
        for (int i = 0; i < this.blocos.length; i++) {
            bloco = this.minimo + i;

            sb.append("#" + bloco + "➡");
//            sb.append("#");

            if (i == this.posCabeca) {
                sb.append("|▶️" + this.blocos[i] + "◀️|");
            } else {
                sb.append("|  " + this.blocos[i] + "  |");
            }

            if (i != this.blocos.length - 1) sb.append(", ");
        }

        sb.append("}");

        return sb.toString();
    }
}
