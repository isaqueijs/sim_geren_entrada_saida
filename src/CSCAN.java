import java.util.ArrayList;

public class CSCAN {
    private Memoria memoria;
    ArrayList<Integer> reqBlocos;

    public CSCAN(Memoria memoria, ArrayList<Integer> reqBlocos) {
        this.memoria = memoria;
        this.reqBlocos = reqBlocos;
    }

    public void escalonar() {

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
                + "Realizando escalonamento com C-SCAN (cabeca = |▶️ ◀️|)" + "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int qtdBlocos = this.memoria.getBlocos().length;
        int tempoSeekTotal = 0, seek = 0;

        System.out.println(this.memoria.toString());

        while (this.reqBlocos.size() > 0) {

            Main.delay(500);

            if (this.reqBlocos.contains(this.memoria.getPosCabeca())) {
                System.out.println("Atendendo requisicao. Visitando bloco " + this.memoria.getPosCabecaBloco() + " 🟢" +
                        "----------------------------------------------------------------------------------------------------------------------");
                System.out.println(this.memoria.toString());
                int index = this.reqBlocos.indexOf(this.memoria.getPosCabeca());
                this.reqBlocos.remove(index);
                System.out.println("Seek Parcial: " + seek);
                tempoSeekTotal += seek;
                seek = 0;
            } else if (this.memoria.getPosCabeca() == qtdBlocos - 1) {
                this.memoria.setPosCabeca(0);
                seek += qtdBlocos - 1;
                System.out.println("Movendo cabeca para inicio 🔁-----------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(this.memoria.toString());
            } else {
                this.memoria.setPosCabeca(this.memoria.getPosCabeca() + 1);
                seek++;
                System.out.println("Movendo cabeca ⏩-----------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(this.memoria.toString());
            }
        }
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                "Tempo Seek Total: " + tempoSeekTotal +
                "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

}
