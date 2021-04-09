package dicegames;

import java.util.ArrayList;
import java.util.Random;

public class DiceGames {

    private int N;
    private Random r = new Random();
    private ArrayList<Integer> arrLScore;
    private ArrayList<Integer> indexPlayer;
    private ArrayList<Integer> delete;
    private int max;
    private int repeat;
    
    public DiceGames(int N) {
        this.N = N;
        everyoneThrows();
        //repeatSeven();
    }
    
    public String getPlayerOrComp() {
        return playerCopm(indexPlayer.get(0));
    }
    
    public void repeatSeven() {
        firstThrows();
    }
    
    private void firstThrows() {
        System.out.println(playerCopm(indexPlayer.get(0)) + " " + indexPlayer.get(0) + " кидает первым");
        arrLScore.set(indexPlayer.get(0), 1 + r.nextInt(6));
        System.out.println("У " + playerCopm(indexPlayer.get(0)) + " " + indexPlayer.get(0) + " выпало: " + arrLScore.get(indexPlayer.get(0)));
        
        for (int i = 0; i < arrLScore.size(); i++) {
            if(i == indexPlayer.get(0))
                continue;
            arrLScore.set(i, 1 + r.nextInt(6));
            System.out.println("У " + playerCopm(i) + " " + i + " выпало: " + arrLScore.get(i));
        }
        choiceWon();
    }
    
    private void choiceWon(){
        max = arrLScore.get(0);
        
        for (int i = 0; i < arrLScore.size(); i++) {
            if(max < arrLScore.get(i)){
                max = arrLScore.get(i);
            }
        }
        indexPlayer.clear();
        delete.add(-1);
        for (int i = 0; i < arrLScore.size(); i++) {
            if(max == arrLScore.get(i)){
                indexPlayer.add(i);
            }
        }
        if(indexPlayer.size() > 1) {
            for (int i = 0; i < indexPlayer.size(); i++) {
                System.out.println("Одинаковые у игроков "+indexPlayer.get(i)+" Значения: "+arrLScore.get(indexPlayer.get(i)));
            }
        }
        
        while(indexPlayer.size() > 1){
            System.out.println("Эти игроки кидают кости для определения победителя");
            for (int i = 0; i < indexPlayer.size(); i++) {
                arrLScore.set(indexPlayer.get(i), 1 + r.nextInt(6));
                if(indexPlayer.get(i) < arrLScore.size()-1)
                    System.out.println("У " + indexPlayer.get(i) + " игрока выпало: " + arrLScore.get(indexPlayer.get(i)));
                else
                    System.out.println("У " + indexPlayer.get(i) + " компа выпало: " + arrLScore.get(indexPlayer.get(i)));
            }
            max = arrLScore.get(indexPlayer.get(0));
            for (int i = 0; i < indexPlayer.size(); i++) {
                if(max < arrLScore.get(indexPlayer.get(i))){
                    max = arrLScore.get(indexPlayer.get(i));
                }
            }
            
            for (int i = 0; i < indexPlayer.size(); i++) {
                if(max == arrLScore.get(indexPlayer.get(i))){
                    //indexPlayer.set(i, indexPlayer.get(i));
                    System.out.println("index = "+indexPlayer.get(i)+" MaxValue = "+arrLScore.get(indexPlayer.get(i)));
                }else{
                    indexPlayer.set(i, -1);
                }
            }
            indexPlayer.removeAll(delete);
        }
        System.out.println("Выйграл " + playerCopm(indexPlayer.get(0)) + " под номером: "+ indexPlayer.get(0)+" Max: "+arrLScore.get(0));
    }
    
    private String playerCopm(int i) {
            if(i < arrLScore.size()-1) {
                return "Игрок";
            }else{
                return "comp's";
            }
    }
    
    private void everyoneThrows() {
        arrLScore = new ArrayList<>(N);
        indexPlayer = new ArrayList<>();
        delete = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            arrLScore.add(0);
        }
        
        
        for (int i = 0; i < arrLScore.size(); i++) {
            arrLScore.set(i, 1 + r.nextInt(6));
            if(i < arrLScore.size()-1)
                System.out.println("У " + i + " игрока выпало: " + arrLScore.get(i));
            else
                System.out.println("У " + i + " компа выпало: " + arrLScore.get(i));
        }
        choiceWon();
        
    }
    
}
