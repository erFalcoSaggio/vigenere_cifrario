import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lunghezza = 0;
        while (lunghezza <= 0) {
            System.out.print("Inserisci la lunghezza della chiave: ");
            lunghezza = scanner.nextInt();
            if (lunghezza <= 0) {
                System.out.println("Errore: la lunghezza deve essere maggiore di 0.");
            }
        }

        int[] chiave = new int[lunghezza];
        for (int i = 0; i < lunghezza; i++) {
            System.out.print("Inserisci il numero " + (i + 1) + " della chiave: ");
            chiave[i] = scanner.nextInt();
        }

        int operazione = 0;
        while (operazione != 1 && operazione != 2) {
            System.out.print("Scegli l'operazione (1 = cifratura, 2 = decifratura): ");
            operazione = scanner.nextInt();
            if (operazione != 1 && operazione != 2) {
                System.out.println("Errore: operazione non valida.");
            }
        }

        //svuota il buffer dello scanner
        scanner.nextLine();

        System.out.print("Inserisci il testo: ");
        String testo = scanner.nextLine();

        String direzione = operazione == 1 ? "+" : "-";
        String risultato = cifraDecifra(testo, chiave, direzione);

        System.out.println("Risultato: " + risultato);
    }

    public static String cifraDecifra(String testo, int[] chiave, String direzione) {
        StringBuilder risultato = new StringBuilder();
        int indiceChiave = 0;

        for (int i = 0; i < testo.length(); i++) {
            char c = testo.charAt(i);
            if (c >= 32 && c <= 126) {
                Lettera lettera = new Lettera(c);
                lettera.trasla(chiave[indiceChiave % chiave.length], direzione);
                risultato.append(lettera.carattere);
                //avanza la chiave solo per caratteri cifrati
                indiceChiave++;
            } else {
                risultato.append(c);
            }
        }

        return risultato.toString();
    }
}
