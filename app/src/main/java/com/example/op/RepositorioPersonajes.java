package com.example.op;

import java.util.ArrayList;

public class RepositorioPersonajes {

    public static ArrayList<Personaje> lista_piratas = new ArrayList<Personaje>();
    public static ArrayList<Personaje> lista_marines = new ArrayList<Personaje>();
    public static ArrayList<Personaje> lista_revolucionarios = new ArrayList<Personaje>();

    public RepositorioPersonajes() {

        if(lista_piratas.isEmpty() || lista_marines.isEmpty() || lista_revolucionarios.isEmpty()){
            // Lista de Piratas
            lista_piratas.add(new Personaje("Monkey D. Luffy", "Pirata", 1500, "Gomu Gomu no Mi", "Capitán de los Piratas de Sombrero de Paja.", R.drawable.img_luffy));
            lista_piratas.add(new Personaje("Roronoa Zoro", "Pirata", 320, "Ninguna", "Espadachín y primer compañero de Luffy.", R.drawable.img_zoro));
            lista_piratas.add(new Personaje("Nami", "Pirata", 66, "Ninguna", "Navegante del barco, experta en clima.", R.drawable.img_nami));
            lista_piratas.add(new Personaje("Usopp", "Pirata", 200, "Ninguna", "Francotirador y contador de historias.", R.drawable.img_usopp));
            lista_piratas.add(new Personaje("Sanji", "Pirata", 330, "Ninguna", "Cocinero y maestro del combate con piernas.", R.drawable.img_sanji));
            lista_piratas.add(new Personaje("Tony Tony Chopper", "Pirata", 100, "Hito Hito no Mi", "Médico del grupo y reno humano.", R.drawable.img_chopper));
            lista_piratas.add(new Personaje("Nico Robin", "Pirata", 130, "Hana Hana no Mi", "Antropóloga y experta en historia antigua.", R.drawable.img_robin));
            lista_piratas.add(new Personaje("Franky", "Pirata", 94, "Ninguna", "Carpintero cibernético del barco.", R.drawable.img_franky));
            lista_piratas.add(new Personaje("Brook", "Pirata", 83, "Yomi Yomi no Mi", "Músico y espadachín esquelético.", R.drawable.img_brook));
            lista_piratas.add(new Personaje("Jinbe", "Pirata", 438, "Ninguna", "Timón del barco y experto en artes marciales del mar.", R.drawable.img_jinbe));
            lista_piratas.add(new Personaje("Portgas D. Ace", "Pirata", 550, "Mera Mera no Mi", "Hermano de Luffy y capitán de la segunda división de los Piratas de Barbablanca.", R.drawable.img_ace));
            lista_piratas.add(new Personaje("Shanks", "Pirata", 4000, "Ninguna", "Capitán de los Piratas de Shanks y exmiembro de los Piratas de Roger.", R.drawable.img_shanks));
            lista_piratas.add(new Personaje("Edward Newgate (Whitebeard)", "Pirata", 5020, "Gura Gura no Mi", "Uno de los piratas más poderosos, conocido como el 'hombre más fuerte del mundo'.", R.drawable.img_white));
            lista_piratas.add(new Personaje("Trafalgar D. Water Law", "Pirata", 500, "Ope Ope no Mi", "Capitán de los Piratas Heart y médico estratégico.", R.drawable.img_law));
            lista_piratas.add(new Personaje("Dracule Mihawk", "Pirata", 3200, "Ninguna", "El mejor espadachín del mundo, conocido como el 'Cazador de Piratas'.", R.drawable.img_mihawk));
            lista_piratas.add(new Personaje("Donquixote Doflamingo", "Pirata", 340, "Ito Ito no Mi", "Exmiembro de los Shichibukai y jefe del crimen en Dressrosa.", R.drawable.img_donquixote));
            lista_piratas.add(new Personaje("Buggy", "Pirata", 15, "Bara Bara no Mi", "Comediante y rival de Luffy, con habilidades de desmembramiento.", R.drawable.img_buggy));

            // Lista de Marines
            lista_marines.add(new Personaje("Sakazuki (Akainu)", "Marine", 2000, "Magu Magu no Mi", "Almirante de la Marina, conocido por su justicia absoluta.", R.drawable.img_akainu));
            lista_marines.add(new Personaje("Borsalino (Kizaru)", "Marine", 0, "Pika Pika no Mi", "Almirante de la Marina, rápido y poderoso.", R.drawable.img_borsalino));
            lista_marines.add(new Personaje("Kuzan (Aokiji)", "Ex-Marine", 0, "Hie Hie no Mi", "Exalcalde de la Marina, conocido por su sentido de la justicia.", R.drawable.img_akaiji));
            lista_marines.add(new Personaje("Monkey D. Garp", "Marine", 500, "Ninguna", "Héroe de la Marina, conocido por su fuerza y vínculos con los piratas.", R.drawable.img_garp));
            lista_marines.add(new Personaje("Smoker", "Marine", 200, "Moku Moku no Mi", "Comandante de la Marina, persigue a los piratas con determinación.", R.drawable.img_smoker));
            lista_marines.add(new Personaje("Tashigi", "Marine", 50, "Ninguna", "Espadachín y teniente de la Marina, lucha por la justicia.", R.drawable.img_tashigi));
            lista_marines.add(new Personaje("Helmeppo", "Marine", 10, "Ninguna", "Teniente de la Marina, aprendiz de Smoker.", R.drawable.img_helmeppo));
            lista_marines.add(new Personaje("Coby", "Marine", 50, "Ninguna", "Un joven marine que busca convertirse en un gran guerrero.", R.drawable.img_coby));
            lista_marines.add(new Personaje("Tsuru", "Marine", 0, "Woshu Woshu no Mi", "Almirante de la Marina, conocida por su inteligencia.", R.drawable.img_tsuru));
            lista_marines.add(new Personaje("Sentomaru", "Marine", 0, "Ninguna", "Comandante de los Pacifistas y asistente de Kuma.", R.drawable.img_sentomaru));

            // Lista de Revolucionarios
            lista_revolucionarios.add(new Personaje("Monkey D. Dragon", "Revolucionario", 0, "Ninguna", "Líder de los Revolucionarios y padre de Luffy.", R.drawable.img_dragon));
            lista_revolucionarios.add(new Personaje("Sabo", "Revolucionario", 602, "Mera Mera no Mi", "Hermano de Luffy y segundo al mando de los Revolucionarios.", R.drawable.img_sabo));
            lista_revolucionarios.add(new Personaje("Bartholomew Kuma", "Ex-Revolucionario", 0, "Nikyu Nikyu no Mi", "Exmiembro de los Revolucionarios, ahora un Pacifista.", R.drawable.img_kuma));
            lista_revolucionarios.add(new Personaje("Ivankov", "Revolucionario", 0, "Horu Horu no Mi", "Líder de la isla Kamabakka y experto en hormonas.", R.drawable.img_ivankov));
            lista_revolucionarios.add(new Personaje("Koala", "Revolucionario", 0, "Ninguna", "Combatiente de los Revolucionarios, exesclava de la familia Donquixote.", R.drawable.img_koala));
            lista_revolucionarios.add(new Personaje("Belo Betty", "Revolucionario", 0, "Kobu Kobu no Mi", "Miembro de los Revolucionarios que inspira a la gente a luchar.", R.drawable.img_belo));
            lista_revolucionarios.add(new Personaje("Inazuma", "Revolucionario", 0, "Choki Choki no Mi", "Miembro de los Revolucionarios con habilidades únicas.", R.drawable.img_inazuma));
            lista_revolucionarios.add(new Personaje("Karasu", "Revolucionario", 0, "Ninguna", "Experto en el uso de pájaros para espionaje.", R.drawable.img_karasu));
            lista_revolucionarios.add(new Personaje("Morley", "Revolucionario", 0, "Pusha Pusha no Mi", "Gigante y defensor de los derechos de los seres humanos.", R.drawable.img_morley));

        }
    }

    public static ArrayList<Personaje> getLista_piratas() {
        return lista_piratas;
    }

    public static void setLista_piratas(ArrayList<Personaje> lista_piratas) {
        RepositorioPersonajes.lista_piratas = lista_piratas;
    }

    public static ArrayList<Personaje> getLista_marines() {
        return lista_marines;
    }

    public static void setLista_marines(ArrayList<Personaje> lista_marines) {
        RepositorioPersonajes.lista_marines = lista_marines;
    }

    public static ArrayList<Personaje> getLista_revolucionarios() {
        return lista_revolucionarios;
    }

    public static void setLista_revolucionarios(ArrayList<Personaje> lista_revolucionarios) {
        RepositorioPersonajes.lista_revolucionarios = lista_revolucionarios;
    }









}
