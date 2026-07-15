import java.util.Random;
import java.util.Scanner;

class Personagem {

    private String nome;
    private int hp;
    private int hpMax;
    private int forca;
    private int pocoes;
    private int manaMax;
    private String classe;
    private boolean defendendo;
    private boolean escudoMagico;
    private int poderMagico;

    public Personagem(String nome, int hp, int forca, String classe) {

        this.nome = nome;
        this.hp = hp;
        this.hpMax = hp;
        this.forca = forca;
        this.pocoes = 3;
        this.classe = classe;
        this.defendendo = false;
        this.escudoMagico = false;
        this.poderMagico = 30;

        if (classe.equals("Mago")) {

            this.mana = 120;
            this.manaMax = 120;

        } else {

            this.mana = 0;
            this.manaMax = 0;

        }

    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getMana() {
        return mana;
    }

    public int getManaMax() {
        return manaMax;
    }

    public String getClasse() {
        return classe;
    }

    public void atacar(Personagem alvo) {
        Random random = new Random();
        int dano = forca;

        if(random.nextInt(100) < 20){
            dano *= 2;
            System.out.println("💥 ATAQUE CRÍTICO!");

        }

        if(alvo.escudoMagico){
            dano /= 2;
            alvo.escudoMagico = false;
            System.out.println("🛡️ Escudo mágico reduziu o dano!");

        }

        if(alvo.defendendo){
            dano /= 2;
            alvo.defendendo = false;
            System.out.println("🛡️ Defesa reduziu o dano!");

        }

        alvo.hp -= dano;
        if(alvo.hp < 0){
            alvo.hp = 0;
        }

        System.out.println("⚔️ " + nome + " causou " + dano + " de dano.");
        System.out.println(alvo.nome + " possui " + alvo.hp + " HP.");

    }

    public void golpePesado(Personagem alvo){
        int dano = forca + 20;
        alvo.hp -= dano;
        if(alvo.hp < 0){
            alvo.hp = 0;
        }

        System.out.println("🗡️ GOLPE PESADO!");
        System.out.println(
            "Causou " + dano + " de dano."
        );

    }
    
        public void bolaDeFogo(Personagem alvo){
        if(mana >= 20){
            mana -= 20;
            int dano = 50;
            Random random = new Random();
            if(random.nextInt(100) < 25){
                dano *= 2;
                System.out.println("🔥 CRÍTICO DE FOGO!");

            }

            alvo.hp -= dano;
            if(alvo.hp < 0){
                alvo.hp = 0;
            }

            System.out.println("🔥 " + nome + " lançou BOLA DE FOGO!");
            System.out.println("Causou " + dano + " de dano mágico.");

            System.out.println("Mana restante: " + mana);

        }else{

            System.out.println("❌ Mana insuficiente!");

        }

    }

    public void raioArcano(Personagem alvo){
        if(mana >= 25){
            mana -= 25;
            int dano = poderMagico + 25;
            Random random = new Random();
            if(random.nextInt(100) < 35){
                dano *= 2;
                System.out.println("⚡ RAIO CRÍTICO!");

            }

            alvo.hp -= dano;
            if(alvo.hp < 0){
                alvo.hp = 0;
            }

            System.out.println("⚡ " + nome + " lançou RAIO ARCANO!");

            System.out.println("Dano causado: " + dano);

        }else{

            System.out.println("❌ Mana insuficiente!");

        }

    }

    public void congelar(Personagem alvo){
        if(mana >= 30){
            mana -= 30;
            alvo.forca -= 5;
            if(alvo.forca < 1){
                alvo.forca = 1;
            }

            System.out.println("❄️ " + nome + " congelou o inimigo!");

            System.out.println("A força do inimigo diminuiu!");

        }else{

            System.out.println("❌ Mana insuficiente!");

        }

    }

    public void drenarVida(Personagem alvo){
        if(mana >= 35){
            mana -= 35;
            int dano = 40;
            alvo.hp -= dano;
            if(alvo.hp < 0){
                alvo.hp = 0;
            }

            hp += dano;

            if(hp > hpMax){
                hp = hpMax;
            }

            System.out.println("🌑 " + nome + " usou DRENAR VIDA!");

            System.out.println("Roubei " + dano + " de vida!");

            System.out.println("HP atual: " + hp);

        }else{

            System.out.println("❌ Mana insuficiente!");

        }

    }

    public void escudoMagico(){
        if(mana >= 20){
            mana -= 20;
            escudoMagico = true;
            System.out.println("🛡️ " + nome + " criou um ESCUDO MÁGICO!");

            System.out.println("O próximo ataque terá dano reduzido.");

        }else{

            System.out.println("❌ Mana insuficiente!");

        }

    }

    public void recuperarMana(){
        if(classe.equals("Mago")){
            mana += 30;
            if(mana > manaMax){
                mana = manaMax;
            }

            System.out.println("💧 Mana recuperada!");

            System.out.println("Mana atual: " + mana);

        }else{

            System.out.println("❌ Apenas magos podem recuperar mana.");

        }

    }

    public void curaDivina(){
        int cura = 40;
        hp += cura;
        if(hp > hpMax){
            hp = hpMax;
        }

        System.out.println("✨ " + nome + " usou CURA DIVINA!");

        System.out.println("HP atual: " + hp);

    }

    public void usarPocao(){
        if(pocoes > 0){
            hp += 30;
            if(hp > hpMax){
                hp = hpMax;
            }

            pocoes--;

            System.out.println("🧪 Poção usada!");

            System.out.println("HP atual: " + hp);

            System.out.println("Poções restantes: " + pocoes);

        }else{

            System.out.println("❌ Sem poções!");

        }

    }

    public void defender(){
        defendendo = true;
        System.out.println("🛡️ " + nome + " está defendendo!");

    }

}

public class PraticaRPG {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("===========================");
        System.out.println("        ⚔️ ARENA RPG ⚔️");
        System.out.println("===========================");

        System.out.print("Nome do herói: ");
        String nome = leitor.nextLine();

        System.out.println("\nEscolha sua classe:");
        System.out.println("1 - 🗡️ Guerreiro");
        System.out.println("2 - 🔮 Mago");
        System.out.println("3 - 🏹 Arqueiro");
        System.out.println("4 - ✨ Paladino");

        int classeEscolhida = leitor.nextInt();

        Personagem heroi;

        switch(classeEscolhida){

            case 1:
                heroi = new Personagem(nome + " (Guerreiro)",120,25,"Guerreiro");
            break;

            case 2:
                heroi = new Personagem(nome + " (Mago)",80,20,"Mago");
            break;

            case 3:

                heroi = new Personagem(nome + " (Arqueiro)",90,30,"Arqueiro");
            break;

            default:
                heroi = new Personagem(nome + " (Paladino)",140,20,"Paladino");

        }

        Personagem monstro = new Personagem("👹 THANOS",160,22,"Monstro");

        while(
            heroi.getHp() > 0 &&
            monstro.getHp() > 0
        ){


            System.out.println("\n===========================");



            System.out.println(
                heroi.getNome() + " HP: " + heroi.getHp() + "/" + heroi.getHpMax());
            
            if(heroi.getClasse().equals("Mago")){

                System.out.println("🔮 Mana: " + heroi.getMana() + "/" + heroi.getManaMax());

            }

            System.out.println(monstro.getNome() + " HP: " + monstro.getHp());
            
            System.out.println("===========================");

            System.out.println("1 - ⚔️ Ataque normal");
            System.out.println("2 - ✨ Magia/Habilidade");
            System.out.println("3 - 🛡️ Defender");
            System.out.println("4 - 🧪 Poção");
            System.out.println("5 - 💧 Recuperar Mana");

            int opcao = leitor.nextInt();

            switch(opcao){
                case 1:
                    heroi.atacar(monstro);
                break;

                case 2:
                    System.out.println("\n✨ Escolha sua habilidade:");
                    switch(heroi.getClasse()){
                        
                        case "Guerreiro":heroi.golpePesado(monstro);
                        break;

                        case "Mago":System.out.println("1 - 🔥 Bola de Fogo");

                            System.out.println(
                                "2 - ⚡ Raio Arcano"
                            );

                            System.out.println(
                                "3 - ❄️ Congelar"
                            );

                            System.out.println(
                                "4 - 🌑 Drenar Vida"
                            );

                            System.out.println(
                                "5 - 🛡️ Escudo Mágico"
                            );



                            int magia = leitor.nextInt();



                            switch(magia){



                                case 1:

                                    heroi.bolaDeFogo(monstro);

                                break;



                                case 2:

                                    heroi.raioArcano(monstro);

                                break;



                                case 3:

                                    heroi.congelar(monstro);

                                break;



                                case 4:

                                    heroi.drenarVida(monstro);

                                break;



                                case 5:

                                    heroi.escudoMagico();

                                break;



                                default:

                                    System.out.println(
                                        "Magia inválida!"
                                    );

                            }


                        break;





                        case "Arqueiro":

                            heroi.atacar(monstro);

                            heroi.atacar(monstro);

                        break;





                        case "Paladino":

                            heroi.curaDivina();

                        break;

                    }


                break;





                case 3:

                    heroi.defender();

                break;





                case 4:

                    heroi.usarPocao();

                break;





                case 5:

                    heroi.recuperarMana();

                break;





                default:

                    System.out.println(
                        "Ação inválida!"
                    );

            }





            // TURNO DO MONSTRO

            if(monstro.getHp() > 0){



                System.out.println(
                    "\n----- TURNO DO THANOS -----"
                );



                Random random = new Random();



                if(random.nextInt(100) < 30){



                    System.out.println(
                        "👹 THANOS usou GOLPE BRUTAL!"
                    );


                    monstro.golpePesado(heroi);



                }else{


                    monstro.atacar(heroi);

                }

            }



        }





        System.out.println(
            "\n==========================="
        );



        if(heroi.getHp() > 0){


            System.out.println(
                "🏆 VOCÊ VENCEU A BATALHA!"
            );


            System.out.println(
                "✨ O reino foi salvo!"
            );


        }else{


            System.out.println(
                "☠️ Você foi derrotado..."
            );


            System.out.println(
                "O monstro dominou a arena."
            );


        }



        leitor.close();

    }

}