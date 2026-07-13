import java.util.Scanner;

class Personagem {
    String nome;
    int hp;
    int forca;

    public Personagem(String nome, int hp, int forca) {
        this.nome = nome;
        this.hp = hp;
        this.forca = forca;
    }

    public void atacar(Personagem alvoPersonagem) {
        // Personagem ataca outro personagem
        System.out.println("\n⚔️ " + this.nome + " ataca " + alvoPersonagem.nome +
                " com força de " + this.forca + "!");

        // Reduz o HP do alvo
        alvoPersonagem.hp = alvoPersonagem.hp - this.forca;

        if (alvoPersonagem.hp < 0) {
            alvoPersonagem.hp = 0;
        }

        System.out.println("🩸 " + alvoPersonagem.nome +
                " perdeu " + this.forca +
                " de HP. (HP restante: " + alvoPersonagem.hp + ")");
    }
}

public class PraticaRPG {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("======================");
        System.out.println(" BEM-VINDO À ARENA ");
        System.out.println("======================");

        System.out.print("Digite o nome do seu personagem: ");
        String nomeHeroi = leitor.nextLine();

        Personagem heroi = new Personagem(nomeHeroi, 100, 50);
        Personagem monstro = new Personagem("KHULISO", 60, 15);

        System.out.println("\nUm " + monstro.nome + " apareceu! Prepare-se para a batalha!");

        while (heroi.hp > 0 && monstro.hp > 0) {

            System.out.println("\n--- SEU TURNO ---");
            System.out.println("1 - Atacar com espada");
            System.out.println("2 - Gritar para intimidar");
            System.out.println("3 - Se defender");
            System.out.print("Sua ação: ");

            int acao = leitor.nextInt();

            switch (acao) {
                case 1:
                    heroi.atacar(monstro);
                    break;

                case 2:
                    System.out.println("\n🗣️" + heroi.nome + " gritou muito alto! Mas nada aconteceu.");
                    System.out.println("O " + monstro.nome + "Riu na sua cara lhe chamou de otário e não sofreu dano!");
                    break;

                default:
                    System.out.println("\n ❌​ Ação inválida! Você perdeu o turno! ");
                    continue;
            }

            // Turno do monstro
            if (monstro.hp > 0) {
                System.out.println("\n--- TURNO DO MONSTRO ---");
                monstro.atacar(heroi);
            }
        }

        System.out.println("\n===== FIM DA BATALHA =====");

        if (heroi.hp > 0) {
            System.out.println("🎉 " + heroi.nome + " venceu!");
        } else {
            System.out.println("💀 " + monstro.nome + " venceu!");
        }

        leitor.close();
    }
}