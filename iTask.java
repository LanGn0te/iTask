/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe para gerenciamento de tarefas Quando invocada gera um arquivo
 * "tarefas.txt" para armazenar as tarefas
 *
 * @version BETA 1.2
 * @author LanGn0te
 */
public class Tarefa {

    int totalTarefas;
    String conteudo[], materia[], dataEntrega[], modoEntrega[], comentario[];

    /**
     * Cria uma nota tarefa depois de todas as outras
     *
     * @param conteudo
     * @param materia
     * @param dataEntrega
     * @param modoEntrega
     * @param comentario
     */
    public void nova(String conteudo, String materia, String dataEntrega, String modoEntrega, String comentario) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("tarefasTMP.txt"));   //Abre um writer que vai escrever no arquivo "tarefasTMP.txt"
            BufferedReader reader = new BufferedReader(new FileReader("tarefas.txt"));      //Abre um reader que vai ler as tarefas no arquivo "tarefas.txt"
            String linha;
            while ((linha = reader.readLine()) != null) {   //While roda enquanto o arquivo nao chegar ao fim, String linha = linha atual do arquivo "tarefas.txt"
                writer.write(linha + "\n");                 //Escreve a String linha no arquivo "tarefasTMP.txt"
            }
            writer.write(conteudo + "\n");      //Escreve o parametro passado como conteudo e insere uma linha logo apos
            writer.write(materia + "\n");       //Escreve o parametro passado como materia e insere uma linha logo apos
            writer.write(dataEntrega + "\n");   //Escreve o parametro passado como data de entrega e insere uma linha logo apos
            writer.write(modoEntrega + "\n");   //Escreve o parametro passado como modo de entrega e insere uma linha logo apos
            writer.write(comentario + "\n");    //Insere o parametro passado como comentario e insere uma linha logo apos
            writer.write("\n");                 //Insere uma linha para encerrar a tarefa
            writer.close(); //Fecha o writer para salvar memoria
            reader.close(); //Fecha o reader para salvar memoria
            new File("tarefas.txt").delete();                               //Deleta o arquivo "tarefas.txt" que ja teve seus dados tranferidos e editados
            new File("tarefasTMP.txt").renameTo(new File("tarefas.txt"));   //Renomeia o arquivo "tarefasTMP.txt" para "tarefas.txt" a fim de substituir seu anterior
        } catch (IOException ex) {
            Logger.getLogger(Tarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
            recarregar();   //Recarrega o array contendo as tarefas
    }

    /**
     * Recarregas os arrays contendo as tarefas
     *
     */
    public void recarregar() {
        this.totalTarefas = 0;
        File tarefasTxt;
        tarefasTxt = new File("tarefas.txt");
        if (tarefasTxt.exists()) {

            try {
                Scanner tarefas;
                tarefas = new Scanner(new FileReader("tarefas.txt")).useDelimiter("\n");
                while (tarefas.hasNext()) {
                    totalTarefas++;
                    conteudo[totalTarefas] = tarefas.next();
                    materia[totalTarefas] = tarefas.next();
                    dataEntrega[totalTarefas] = tarefas.next();
                    modoEntrega[totalTarefas] = tarefas.next();
                    comentario[totalTarefas] = tarefas.next();
                    tarefas.next();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Tarefa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                tarefasTxt.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Tarefa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getConteudo(int numTarefa) {
        recarregar();
        return conteudo[numTarefa];

    }

    public String getMateria(int numTarefa) {
            recarregar();
            return materia[numTarefa];

    }

    public String getDataEntrega(int numTarefa) {
            recarregar();
            return dataEntrega[numTarefa];
    }

    public String getModoEntrega(int numTarefa) {
            recarregar();
            return modoEntrega[numTarefa];
    }

    public String getComentario(int numTarefa) {
            recarregar();
            return comentario[numTarefa];

    }

    public int getNumTarefas() {
        return totalTarefas;
    }

    public Tarefa() {
        recarregar();
    }
}

    /*
     Aqui nos escrevemos a musica;

     ***********************************************

     Do tamanho do meu punho é o meu coracao
     As arterias levam o sangue pela pulsacao
     Leva meus nutrientes bem rapidamente
     Pelo meio da dupla circulacao

     Uma sísole e uma contracao
     Que ocorre no coracao
     Uma diastole e o relaxamento
     Que ocorre a  -  todo momento

     Os meus vazos sanguineos distribuem igualmente
     Todos os nutrientes que eu preciso
     Veias e arterrias sao construidas
     Por três tunicas ou menbranas desobistruidas

     Uma sísole e uma contracao
     Que ocorre no coracao
     Uma diastole e o relaxamento
     Que ocorre a  -  todo momento

     A circulacao depende dos batimentos
     De forma ritmica e controlada ao tudo ao mesmo tempo
     O sabgue arterial e rico em oxigenio
     Mas o sangue venoso nao contem veneno

     Uma sísole e uma contracao
     Que ocorre no coracao
     Uma diastole e o relaxamento
     Que ocorre a  -  todo momento

     By Gustavo, Isaac e Nicolas;

     ***********************************************

     ACABOU! ACABOU! ACABOU!;
     EH TETRA! EH TETRA! EH TETRA! EH TETRA!;
     */
