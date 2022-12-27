package lotto;

import java.util.HashMap;
import java.util.Map;

public enum Prize {

    FIRST_PRIZE (2000000000),
    SECOND_PRIZE (30000000),
    THIRD_PRIZE (1500000),
    FORTH_PRIZE (50000),
    FIFTH_PRIZE (5000);



    private final int reward;

    private static Map<Prize, Integer> prizeHashMap= new HashMap<>();;

    Prize(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public static int calcReword(){
        int sum = 0;
        setHashMap();
        for (Prize prize : Prize.values()) {
            sum += prize.getReward()*prizeHashMap.get(prize);
        }
        return sum;
    }

    public static void addPrizeHashMap(Prize prize){
        setHashMap();
        prizeHashMap.put(prize, prizeHashMap.get(prize)+1);
    }

    public static int showPrizeHashMap(Prize prize){
        setHashMap();
        return prizeHashMap.get(prize);
    }

    private static void setHashMap(){
        if(prizeHashMap.isEmpty()){
        prizeHashMap.put(FIRST_PRIZE,0);
        prizeHashMap.put(SECOND_PRIZE,0);
        prizeHashMap.put(THIRD_PRIZE,0);
        prizeHashMap.put(FORTH_PRIZE,0);
        prizeHashMap.put(FIFTH_PRIZE,0);}
    }
}
