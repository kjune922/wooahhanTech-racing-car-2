package racingcar.generate;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public int randomNumberGenerate(){
        return Randoms.pickNumberInRange(0,9);
    }
}
